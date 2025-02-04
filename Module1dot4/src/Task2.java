import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an array size: "); int arraysize = scanner.nextInt();
        int[] array = new int[arraysize];

        System.out.println("Enter integers into the array:");

        for (int i = 0; i < arraysize; i++) {
            System.out.print("Enter integer " + (i + 1) + ": "); array[i] = scanner.nextInt();
        }

        int maxsum = Integer.MIN_VALUE;
        int startindex = 0;
        int endindex = 0;

        for (int i = 0; i < arraysize; i++) {
            int currentsum = 0;
            for (int j = i; j < arraysize; j++) {
                currentsum += array[j];

                if (currentsum > maxsum) {
                    maxsum = currentsum;
                    startindex = i;
                    endindex = j;
                }
            }
        }

        System.out.println();
        System.out.println("Maximum sum: " + maxsum);
        System.out.println("Integers: " + (startindex++) + "-" + (endindex++));
    }
}
