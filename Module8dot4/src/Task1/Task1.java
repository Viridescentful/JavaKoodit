package Task1;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Task1 {
    public static void main(String[] args) {
        int[] numbers = {10, 5, 8, 20, 15, 3, 12};

        OptionalDouble mean = Arrays.stream(numbers).average();

        mean.ifPresent(m -> System.out.println("Mean: " + String.format("%.2f", m)));
    }
}