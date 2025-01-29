package Module3dot1.Part;

public class Radar extends Part {
    private double peakPower;

    public Radar(double peakPower, String identifier, String manufacturer, String description, double cost) {
        super(identifier, manufacturer, description, cost);
        this.peakPower = peakPower;
    }

    public double getPeakPower() { return peakPower; }
}
