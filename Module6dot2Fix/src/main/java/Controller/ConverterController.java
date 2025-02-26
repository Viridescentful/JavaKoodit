package Controller;

import View.ConverterView;
import Model.Converter;

import java.util.ArrayList;

public class ConverterController {

    private ConverterView gui;
    private Converter converter = new Converter();

    public ConverterController(ConverterView gui) {
        this.gui = gui;

        converter.add("USD", "United States Dollar", 1.0);
        converter.add("EUR", "EURO", 0.95);
        converter.add("SEK", "Swedish Krona", 10.59);

        gui.setchoices(converter.getall());
    }

    public void calculate(String convertablekey, String convertedkey, String value) {
        if (!isValidDouble(value)) {
            gui.setResult("Invalid Amount!");
            return;
        }
        gui.setResult(converter.convert(convertablekey, convertedkey, value));
    }

    public static boolean isValidDouble(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
