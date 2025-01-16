package Module1dot3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number for a Quadratic Equation:"); int first = Integer.parseInt(scanner.nextLine());
        System.out.println("Give the second number for a Quadratic Equation:"); int second = Integer.parseInt(scanner.nextLine());
        System.out.println("Give the third number for a Quadratic Equation:"); int third = Integer.parseInt(scanner.nextLine());

        if ((Math.pow(second, 2) - 4 * first * third) >= 0) {
            double firstroot = (-second + Math.sqrt((Math.pow(second, 2) - 4 * first * third))) / (2 * first);
            double secondroot = (-second - Math.sqrt((Math.pow(second, 2) - 4 * first * third))) / (2 * first);

            System.out.println(firstroot + ", " + secondroot);
        } else {
            System.out.println("No real roots");
        }
    }
}
