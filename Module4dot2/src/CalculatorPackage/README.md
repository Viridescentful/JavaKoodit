<p>This program sums up numbers, can show the current sum of all the numbers and also reset the sum to 0, the given number is negative, it will throw an exception</p>

```java
public class Calculator {
    private int sum;

    public Calculator() {
        this.sum = 0;
    }

    public void reset() {
        this.sum = 0;
    }

    public void add(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed.");
        }
        this.sum += number;
    }

    public int getValue() {
        return this.sum;
    }
}
```

<p>The Calculator class is defined with a private integer field sum to store the current sum of the numbers. 
The constructor initializes the sum to 0. The reset method resets the sum to 0. 
The add method takes an integer as an argument and adds it to the sum. 
If the integer is negative, it throws an IllegalArgumentException. 
The getValue method returns the current value of the sum.</p>