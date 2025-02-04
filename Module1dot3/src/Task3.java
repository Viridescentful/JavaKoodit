import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give a positive number:"); int first = Integer.parseInt(scanner.nextLine());
        System.out.println("Give a larger positive number:"); int second = Integer.parseInt(scanner.nextLine());

        for (int i = first; i <= second; i++) {
            boolean isprime = true;

            for (int x = 2; x <= i - 1; x++) {
                if (i % x == 0) {
                    isprime = false;
                    break;
                }
            }

            if (isprime == true) {
                System.out.println(i);
            }
        }
    }
}
