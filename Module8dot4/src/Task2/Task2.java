package Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);

        int sum = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(n -> n * 2)
                .sum();

        System.out.println("List sum: " + sum);
    }
}
