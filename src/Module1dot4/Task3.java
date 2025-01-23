package Module1dot4;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an array size: "); int arraysize = scanner.nextInt();
        int[] array = new int[arraysize];

        System.out.println("Enter integers into the array:");

        for (int i = 0; i < arraysize; i++) {
            System.out.print("Enter integer " + (i + 1) + ": "); array[i] = scanner.nextInt();
        }

        int[] finalarray = new int[arraysize];
        int uniqueCount = 0;

        for (int i = 0; i < arraysize; i++) {
            boolean isduplicate = false;

            for (int j = 0; j < uniqueCount; j++) {
                if (array[i] == finalarray[j]) {
                    isduplicate = true;
                    break;
                }
            }

            if (!isduplicate) {
                finalarray[uniqueCount] = array[i];
                uniqueCount++;
            }
        }

        System.out.println("Array without duplicates:");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(finalarray[i]);
        }
    }
}
