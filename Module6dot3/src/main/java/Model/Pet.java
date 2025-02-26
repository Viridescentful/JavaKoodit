package Model;

import java.util.ArrayList;

public class Pet {
    private ArrayList<Double> location;

    public Pet () {
        location = new ArrayList<>();
        location.add(0.0);
        location.add(0.0);
    }

    public ArrayList<Double> getLocation() {
        System.out.println("Mouse location: " + location.get(0) + ", " + location.get(1));

        return location;
    }

    public void setLocation(double x, double y) {
        location.set(0, x);
        location.set(1, y);
    }
}
