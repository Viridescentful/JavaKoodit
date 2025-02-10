package CalculatorPackage;

public class Testing {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            calculator.add(5);
            calculator.add(10);
            calculator.add(15);
            System.out.println("Current sum: " + calculator.getValue());

            calculator.reset();
            System.out.println("After reset, current sum: " + calculator.getValue());

            calculator.add(20);
            System.out.println("Current sum: " + calculator.getValue());

            // This will throw an exception
            calculator.add(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}