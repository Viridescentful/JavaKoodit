package Module1dot3;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give a binary number:"); String binarynumber = scanner.nextLine();

        int decimaln = 0;

        for (int i = binarynumber.length() - 1; i >= 0; i--) {

            int digit = Character.getNumericValue(binarynumber.charAt(i));
            int power = binarynumber.length() - i - 1;
            int decimalValue = digit * (int) Math.pow(2, power);

            decimaln += decimalValue;
        }

        System.out.println("The Decimal number of " + binarynumber + " is: " + decimaln);
    }
}
