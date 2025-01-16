package Module1dot3;

import java.util.Scanner;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Random random = new Random();

            int playerpoints = 0;

            for (int i = 0; i < 10; i++) {
                int first = random.nextInt(1, 10);
                int second = random.nextInt(1, 10);

                System.out.println(first + " * " + second + " = ?");
                System.out.println("Give the correct answer:"); int answer = Integer.parseInt(scanner.nextLine());

                if (answer == first * second) {
                    playerpoints++;

                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong!");
                }

                System.out.println();
            }

            if (playerpoints >= 10) {
                System.out.println("Congratulations! You win!");
                break;
            } else {
                System.out.println("Unfortunately, you will have to try again! You got " + playerpoints + " points.");
                System.out.println();
            }
        }
    }
}
