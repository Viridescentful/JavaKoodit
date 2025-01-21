package Module1dot4;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstnames = {"John", "Steel", "Kenny"};
        String[] secondnames = {"thatsecondnamewhichmakesnosense", "Cornerstone", "Court"};

        System.out.println("Give an index for First Name table:"); int firstindex = Integer.parseInt(scanner.nextLine());
        System.out.println("Give an index for First Name table:"); int secondindex = Integer.parseInt(scanner.nextLine());

        System.out.println(firstnames[firstindex] + " " + secondnames[secondindex]);
    }
}
