package TestPackage;
import TestPackage.distributions.Normal;


public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(new Normal(100,20).sample());
        }
    }
}
