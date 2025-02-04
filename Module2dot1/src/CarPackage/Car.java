package CarPackage;

/* Define a class Car (convention capitalizes class names).
 * Car is public (as classes usually are, more on this later).
 */
public class Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    private double speed;
    private double gasolineLevel;
    private double gasolineCapacity;
    private double topspeed;

    private boolean cruiseControl;
    private double cruiseSpeed;
    private double cruiseMaxSpeed;
    private double cruiseMinSpeed;

    private String typeName;

    /* This is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */
    public Car(String typeName) {
        speed = 0; gasolineLevel = 0; gasolineCapacity = 60; topspeed = 200;
        cruiseControl = false; cruiseSpeed = 0; cruiseMaxSpeed = 60; cruiseMinSpeed = 0;
        this.typeName = typeName;   // this refers to the object itself.
        // The reference is useful if you want to use parameter names that are
        // identical to instance variable names (and for more, later on)
    }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
    public void accelerate() {
        if (gasolineLevel > 0) {
            if (cruiseControl) {
                if (speed + 10 >= cruiseSpeed) {
                    speed = cruiseSpeed;
                } else {
                    speed += 10;
                }
            } else {
                if (speed + 10 >= topspeed) {
                    speed = topspeed;
                } else {
                    speed += 10;
                }
            }
        } else {
            speed = 0;
        }

    }

    void decelerate(int amount, int low) {
        if (gasolineLevel > 0) {
            if (amount > low)
                speed = Math.max(low, speed - amount);
        } else
            speed = 0;
    }

    double getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    void toggleCruise() {
        cruiseControl = !cruiseControl;
    }

    void setCruiseSpeed(double cruiseSpeed) {
        if (cruiseControl) {
            if (cruiseSpeed <= cruiseMaxSpeed){
                this.cruiseSpeed = cruiseSpeed;
            } else {
                System.out.printf("CruiseSpeed Exceeded the maximum speed of %.2f\n", cruiseMaxSpeed);
                System.out.println("Turning off cruise");
                System.out.println();
                toggleCruise();
            }
        }
    }

    void fillTank() {
        gasolineLevel = gasolineCapacity;
    }
    double getGasolineLevel() {
        return gasolineLevel;
    }
}
