package Task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        // Step 1: Create a List of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30, "New York"));
        people.add(new Person("Bob", 25, "San Francisco"));
        people.add(new Person("Charlie", 22, "New York"));
        people.add(new Person("David", 35, "Chicago"));
        people.add(new Person("Eve", 28, "New York"));

        people.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("List by age: ");
        people.forEach(System.out::println);
        System.out.println();

        people.removeIf(person -> !person.getCity().equals("New York"));
        System.out.println("Filtered by New York: ");
        people.forEach(System.out::println);
    }
}