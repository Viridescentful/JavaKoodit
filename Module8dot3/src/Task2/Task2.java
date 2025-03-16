package Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

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

        Predicate<Integer> isEven = n -> n % 2 == 0;
        numbers.removeIf(isEven);
        System.out.println("Odd list: " + numbers);

        UnaryOperator<Integer> doubleOdd = n -> n % 2 != 0 ? n * 2 : n;
        numbers.replaceAll(doubleOdd);
        System.out.println("Doubled odds list: " + numbers);


        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum of list: " + sum);
    }
}
