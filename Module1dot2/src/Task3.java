import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double luoti = 13.28;
        double naula = luoti * 32;
        double leiviskä = naula * 20;

        System.out.println("Give a gram amount:"); double grams = Double.parseDouble(scanner.nextLine());
        double leiviskäleft = grams % leiviskä;
        double naulaleft = leiviskäleft % naula;

        int leiviskäamount = (int) ((grams - leiviskäleft) / leiviskä);
        int naulaamount = (int) ((leiviskäleft - naulaleft) / naula);
        double luotiamount = naulaleft / luoti;

        System.out.printf(leiviskäamount + ", " + naulaamount + ", %.2f", luotiamount);
    }
}
