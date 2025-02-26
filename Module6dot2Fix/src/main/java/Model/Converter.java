package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Converter {
    private HashMap<String, List> currencies;

    public Converter() {
        this.currencies = new HashMap<>();
    }

    public HashMap getall() {
        return currencies;
    }

    public String convert(String convertablekey, String convertedkey, String value) {

        if (Double.parseDouble(value) <= 0) {
            return String.valueOf("Invalid Amount!");
        } else if (currencies.containsKey(convertablekey) && currencies.containsKey(convertedkey)) {
            double convertablevalue = (double) currencies.get(convertablekey).get(1);
            double convertedvalue = (double) currencies.get(convertedkey).get(1);

            return String.valueOf("%,.2f".formatted(Double.parseDouble(value) * (convertedvalue / convertablevalue)));
        } else {
            return String.valueOf("Invalid Currency!");
        }
    }

    public synchronized void add(String key, String name, double value) {
        List<Object> currency = new ArrayList<>();
        currency.add(name);
        currency.add(value);

        this.currencies.put(key, currency);
        System.out.println(key + " " + currencies.get(key).get(0) + " " + currencies.get(key).get(1));
    }
}
