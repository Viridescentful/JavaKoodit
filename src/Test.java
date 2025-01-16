public class Test {
    public static void main(String[] args) {
        try {
            System.out.println("Thread Started");
            Thread.sleep(3000);  // 1000 ms = 1s
            System.out.println("Thread Stopped");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
