package Controller;

import Model.Converter;
import View.ConverterView;

public class ConverterController {
    private ConverterView gui;
    private Converter converter;

    public ConverterController(ConverterView gui) {
        this.converter = new Converter(this);
        this.gui = gui;
        gui.setchoices(converter.getall());
    }

    public void addCurrency(String code, String currencyname, double conversionrate) {
        converter.addCurrency(code, currencyname, conversionrate);
        gui.setchoices(converter.getall());
    }

    public void calculate(String convertablekey, String convertedkey, String value) {
        if (!isValidDouble(value)) {
            gui.setResult("Invalid Amount!");
            return;
        }
        gui.setResult(converter.convert(convertablekey, convertedkey, value));
    }

    public void setResult(String result) {
        gui.setResult(result);
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
