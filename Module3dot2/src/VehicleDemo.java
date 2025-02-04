abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type;
    protected String fueltype;
    protected String color;

    public AbstractVehicle(String type, String fueltype, String color) {
        this.type = type;
        this.fueltype = fueltype;
        this.color = color;
    }

    public void getInfo() {
        System.out.println("Type: " + this.type);
        System.out.println("Fuel Type: " + this.fueltype);
        System.out.println("Color: " + this.color);
    }

    public int getfuelconsumption(String fueltype) {
        if (type.equals("Car")) {
            return 8;
        } else if (type.equals("Bus")) {
            return 21;
        } else if (type.equals("Motorcycle")) {
            return 4;
        } else if (type.equals("Electric Car")) {
            return 15;
        } else if (type.equals("Electric Motorcycle")) {
            return 10;
        } else {
            return 0;
        }
    }

    public void start() {
        System.out.println(this.type + " is starting");
    }

    public void stop() {
        System.out.println(this.type + " is stopping");
    }
}

interface ElectricVehicle {
    void charge();
}

interface Vehicle {
    void start();
    void stop();
    void calculatefuelefficiency();
}

class Car extends AbstractVehicle {
    public Car(String fueltype, String color) {
        super("Car", fueltype, color);
    }

    @Override
    public void charge() {
        System.out.println("This action is unavailable");
    }

    @Override
    public void calculatefuelefficiency() {
        System.out.println(getfuelconsumption(type) + " liters per 100 kilometers");
    }
}

class Bus extends AbstractVehicle {
    public Bus(String fueltype, String color) {
        super("Bus", fueltype, color);
    }

    @Override
    public void charge() {
        System.out.println("This action is unavailable");
    }

    @Override
    public void calculatefuelefficiency() {
        System.out.println(getfuelconsumption(type) + " liters per 100 kilometers");
    }
}

class Motorcycle extends AbstractVehicle {
    public Motorcycle(String fueltype, String color) {
        super("Motorcycle", fueltype, color);
    }

    @Override
    public void charge() {
        System.out.println("This action is unavailable");
    }

    @Override
    public void calculatefuelefficiency() {
        System.out.println(getfuelconsumption(type) + " liters per 100 kilometers");
    }
}

class ElectricCar extends AbstractVehicle {
    public ElectricCar(String color) {
        super("Electric Car", "Electric", color);
    }

    @Override
    public void charge() {
        System.out.println(super.type + " is charging");
    }

    @Override
    public void calculatefuelefficiency() {
        System.out.println(getfuelconsumption(type) + " kWh per 100 kilometers");
    }
}

class ElectricMotorcycle extends AbstractVehicle {
    public ElectricMotorcycle(String color) {
        super("Electric Motorcycle", "Electric", color);
    }

    @Override
    public void charge() {
        System.out.println(super.type + " is charging");
    }

    @Override
    public void calculatefuelefficiency() {
        System.out.println(getfuelconsumption(type) + " kWh per 100 kilometers");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Car car = new Car("Petrol", "Blue");
        ElectricCar electricCar = new ElectricCar("Red");

        car.getInfo();
        car.charge();
        car.start();
        car.stop();
        car.calculatefuelefficiency();

        System.out.println();

        electricCar.getInfo();
        electricCar.charge();
        electricCar.start();
        electricCar.stop();
        electricCar.calculatefuelefficiency();
    }
}
