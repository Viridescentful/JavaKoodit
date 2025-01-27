package Simulation3.Clock;

import Simulation3.Clock.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        singleton.addTimeunits(10);
        System.out.println(singleton.getTimeunits());
        singleton.addTimeunits(9);
        System.out.println(singleton.getTimeunits());
        singleton.setTimeunits(892);

        System.out.println(singleton.getTimeunits());
    }
}
