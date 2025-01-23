package Simulation2.Task2;

import java.util.PriorityQueue;

public class Events implements Comparable<Events> {
    private double eventtime;
    private EventType eventtype;

    public enum EventType {
        ARRIVAL, ROUTER, EXIT, DIVERT
    }

    public Events(double eventtime, EventType eventtype) {
        setEventtime(eventtime);
        setEventtype(eventtype);
    }

    public void setEventtime(double eventtime) {
        this.eventtime = eventtime;
    }

    public void setEventtype(EventType eventtype) {
        this.eventtype = eventtype;
    }

    public int compareTo(Events o) {
        if (eventtime == o.eventtime)
            return 0;
        else if (eventtime > o.eventtime)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Event Type: " + eventtype + ", Time: " + eventtime;
    }
}

class EventList {
    private PriorityQueue<Events> allevents;

    public EventList() {
        allevents = new PriorityQueue<>();
    }

    public void addEvent(Events event) {
        allevents.add(event);
    }
    public void printEvents() {
        while(!allevents.isEmpty()) {
            System.out.println(allevents.poll());
        }
    }

    public static void main(String[] args) {
        EventList eventList = new EventList();

        eventList.addEvent(new Events(1.322, Events.EventType.DIVERT));
        eventList.addEvent(new Events(16.1, Events.EventType.ARRIVAL));
        eventList.addEvent(new Events(4, Events.EventType.EXIT));
        eventList.addEvent(new Events(565, Events.EventType.ROUTER));

        eventList.printEvents();
    }
}
