package CoffeeMakerPackage;

public class CoffeeMachineDriver {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        coffeeMaker.turnOnOff();
        coffeeMaker.setcoffeetype("Espresso");
        coffeeMaker.setcoffeeamount(50);

        System.out.println(coffeeMaker.getStatus());
        System.out.println(coffeeMaker.getCoffeetype());
        System.out.println(coffeeMaker.getCoffeeAmount() + "ml");

        coffeeMaker.turnOnOff();
        System.out.println(coffeeMaker.getStatus());

        coffeeMaker.setcoffeetype("Caramel Latte");

        System.out.println(coffeeMaker.getCoffeetype());
        System.out.println(coffeeMaker.getCoffeeAmount() + "ml");
    }
}
