package Module3dot1.Part;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine("turboprop", "ep4682", "Europrop", "Airbus A400M", 38e6f);
        System.out.println(engine.getEngineType());
        System.out.println(engine.getManufacturer());

        Radar radar = new Radar(17.5f, "r2156", "Thales", "AirMaster", 1.3e6f);
        System.out.println(radar.getPeakPower() + "kW");
        System.out.println(radar.getManufacturer());
    }
}