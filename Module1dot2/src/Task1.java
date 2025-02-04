import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give Fahrenheit:"); double first = Double.parseDouble(scanner.nextLine());
        System.out.println("The given Fahrenheit is " + ((first - 32) * (5 / 9.0)));
    }
}
