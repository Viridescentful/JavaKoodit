package Simulation1.Task3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Customer {
    private static int totalid = 1;

    private int id;
    private long starttime;
    private long endtime;

    public Customer() {
        setId(totalid);
        totalid++;
    }

    public void setId(int newid) {
        this.id = newid;
    }

    public void setStarttime() {
        this.starttime = System.currentTimeMillis();
    }

    public void setEndtime() {
        this.endtime = System.currentTimeMillis();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long truestarttime = System.currentTimeMillis();

        Queue<Customer> customerList = new LinkedList<>();
        Queue<Customer> customerQueue = new LinkedList<>();

        customerList.add(new Customer());
        customerList.add(new Customer());
        customerList.add(new Customer());
        customerList.add(new Customer());

        try {
            Thread.sleep(3000);  // 1000 ms = 1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (!customerList.isEmpty()) {

            System.out.println("Would you like to add or remove a customer from queue?"); String response = scanner.nextLine();

            if (response.equals("add")) {
                Customer customer = pollCustomer(customerList);
                addCustomer(customerQueue, customer);

                customer.setStarttime();

                double starttimeseconds = (customer.starttime - truestarttime) / 1000.0;
                System.out.println(customer.id + ", Start time: " + starttimeseconds);
            } else if (response.equals("remove")) {
                Customer customer = pollCustomer(customerQueue);

                customer.setEndtime();

                double starttimeseconds = (customer.starttime - truestarttime) / 1000.0;
                double queuetimeseconds = (customer.endtime - customer.starttime) / 1000.0;

                System.out.println(customer.id + ", Start time: " + starttimeseconds + ", Queue time: " + queuetimeseconds);
            }
        }
    }

    public static Customer pollCustomer(Queue<Customer> queue) {
        return queue.poll();
    }

    public static Customer addCustomer(Queue<Customer> queue, Customer customer) {
        queue.add(customer);
        return customer;
    }
}
