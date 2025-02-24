package Task1;

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

        for (int i = 0; i < 16; i++) {
            Main main = new Main(theater);
            main.start();
        }
    }
}
