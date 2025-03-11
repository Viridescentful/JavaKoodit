public class Task1 extends Thread {
    private int start;
    private int end;
    private String mode;


    public Task1( int start, int end, String mode) {
        this.start = start;
        this.end = end;
        this.mode = mode;
    }

    public void run() {
        try {
            if (mode.equals("even")) {

                for (int i = this.start; i <= this.end; i++) {
                    if (i % 2 == 0) {
                        System.out.println("Even Thread: " + i);
                    }
                }
            }

            if (mode.equals("odd")) {
                if (this.start % 2 != 0) {
                    System.out.println("Odd Thread: " + this.start);
                }

                Thread.sleep(100);

                for (int i = this.start + 1; i <= this.end; i++) {
                    if (i % 2 != 0) {
                        System.out.println("Odd Thread: " + i);
                    }
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Task1 firsttask = new Task1(51, 100, "odd");
        Task1 secondtask = new Task1( 51, 100, "even");

        try {
            firsttask.start();
            secondtask.start();

            firsttask.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
