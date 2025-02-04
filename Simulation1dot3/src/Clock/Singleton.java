package Clock;

public class Singleton {
    // Private static member to hold the unique instance
    private static Singleton instance;
    private int timeunits;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
        this.timeunits = 0;
    }

    public void addTimeunits(int timeunits) {
        this.timeunits += timeunits;
    }

    public void setTimeunits(int timeunits) {
        this.timeunits = timeunits;
    }

    public int getTimeunits() {
        return this.timeunits;
    }

    // Public static method to access the unique instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
