package Part;

public class Engine extends Part {
    private String engineType;

    public Engine(String engineType, String identifier, String manufacturer, String description, double cost) {
        super(identifier, manufacturer, description, cost);
        this.engineType = engineType;
    }

    public String getEngineType() { return engineType; }
}
