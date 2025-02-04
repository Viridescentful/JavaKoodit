import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first leg of the triangle:"); double first = Double.parseDouble(scanner.nextLine());
        System.out.println("Give the second leg of the triangle:"); double second = Double.parseDouble(scanner.nextLine());
        System.out.println("The hypotenuse of the triangle is:" + Math.sqrt(Math.pow(first, 2) + Math.pow(second, 2)));
    }
}
