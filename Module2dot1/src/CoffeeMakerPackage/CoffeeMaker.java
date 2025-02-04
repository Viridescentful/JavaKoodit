package CoffeeMakerPackage;

public class CoffeeMaker {
    private boolean on;
    private String coffeetype;
    private int coffeeamount;

    public CoffeeMaker() {
        this.on = false;
        this.coffeetype = "";
        this.coffeeamount = 0;
    }

    public void turnOnOff() {
        this.on = !this.on;
    }

    public boolean getStatus() {
        return this.on;
    }

    public int getCoffeeAmount() {
        return this.coffeeamount;
    }

    public String getCoffeetype() {
        return this.coffeetype;
    }

    public void setcoffeetype(String coffeetype) {
        if (this.on) {
            this.coffeetype = coffeetype;
        }
    }

    public void setcoffeeamount(int coffeeamount) {
        if (this.on) {
            this.coffeeamount = coffeeamount;
        }
    }
}
