import java.util.ArrayList;
import java.util.Random;

public class Task2 extends Thread {
    private static long sum;

    private int finalsum = 0;
    private int start;
    private int end;

    private ArrayList<Integer> list;

    public Task2(int start, int end, ArrayList<Integer> list) {
        this.start = start;
        this.end = end;
        this.list = list;
    }

    public long getFinalsum() {
        return sum;
    }

    public void run() {
        try {
            System.out.println("Start: " + (this.start + 1) + " End: " + (this.end + 1));

            Thread.sleep(10);

            for (int i = this.start; i <= this.end; i++) {
                finalsum += this.list.get(i);
            }

            sum += finalsum;

            if ((this.end + 1) == list.size()) {
                System.out.println(sum);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        int threads = Runtime.getRuntime().availableProcessors();

        Random random = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            numbers.add(random.nextInt(1, 10));
        }

        int divisor = numbers.size() / threads;
        int leftover = numbers.size() % threads;

        try {
            for (int i = 0; i < threads; i++) {
                if (i == threads - 1) {
                    Task2 task = new Task2((divisor * i), (divisor * (i + 1) + leftover - 1), numbers);
                    task.start();
                } else if (i > 0) {
                    Task2 task = new Task2((divisor * i + 1), (divisor * (i + 1)), numbers);
                    task.start();
                } else {
                    Task2 task = new Task2((divisor * i), (divisor * (i + 1)), numbers);
                    task.start();
                }

                Thread.sleep(100);
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
