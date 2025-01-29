package Module3dot1.Part;

public class Part {
    private String identifier;
    private String manufacturer;
    private String description;
    private double cost;

    public Part(String identifier, String manufacturer, String description, double cost) {
        this.identifier   = identifier;
        this.manufacturer = manufacturer;
        this.description  = description;
        this.cost         = cost;
    }

    public String getIdentifier() { return identifier; }

    public String getDescription() {
        return description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return description + " (" + cost + "€)";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Part compared = (Part) obj;

        if (this.identifier == null || !this.identifier.equals(compared.getIdentifier())) {
            return false;
        }

        return true;
    }
}


