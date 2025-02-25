package Task1;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Thread {
    private Theater theater;

    public Main(Theater theater) {
       this.theater = theater;
    }

    public void run() {
        Customer newCustomer = new Customer();
        this.theater.reserveTicket(newCustomer, new Random().nextInt(3) + 1);
    }

    public static void main(String[] args) throws InterruptedException {
        Theater theater = new Theater();
        ArrayList<Main> list = new ArrayList();

        int threads = Runtime.getRuntime().availableProcessors();

        for (int i = 0; i < threads; i++) {
            Main main = new Main(theater);
            main.start();
            list.add(main);
        }

        try {
            for (Main main : list) {
                main.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tickets left: " + theater.getTickets());
    }
}
