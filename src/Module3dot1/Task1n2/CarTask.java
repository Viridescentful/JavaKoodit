package Module3dot1.Task1n2;

class Car {
    protected String name;

    public Car(String name) {
        this.name = name;
    }

    public void drive() {
        System.out.println(name + " is driving");
    }


}

class SportsCar extends Car {
    public SportsCar(String name) {
        super(name);
    }

    public void honk() {
        System.out.println(name + " is honking");
    }
}

class Bus extends Car {
    private int passangeramount;

    public Bus(String name) {
        super(name);

        this.passangeramount = 0;
    }

    public void showpassangers() {
        System.out.println(name + " has " + passangeramount + " passanger(s)");
    }

    public void takepassangers(int passagers) {
        if (this.passangeramount - passagers <= 0) {
            this.passangeramount = 0;
        } else {
            this.passangeramount -= passagers;
        }

        showpassangers();
    }

    public void removepassangers(int passagers) {
        this.passangeramount += passagers;
        showpassangers();
    }
}

public class CarTask {
    public static void main(String[] args) {
        SportsCar sportscar = new SportsCar("FastCar7872");
        Bus bus = new Bus("NormalBus");

        sportscar.drive();
        sportscar.honk();

        bus.takepassangers(10);
        bus.removepassangers(6);
    }
}
