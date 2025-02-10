import java.io.*;

public class FibonacciCode {
    private final static String FILENAME = "Fibonacci.csv";

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            writer.println("Index,Fibonacci Number");

            long first = 0;
            long second = 1;

            for (int i = 1; i <= 60; i++) {
                writer.println(i + "; " + first);
                long next = first + second;
                first = second;
                second = next;
            }

            System.out.println("Fibonacci sequence written to " + FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
