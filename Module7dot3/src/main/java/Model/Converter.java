package Model;

import Controller.ConverterController;
import dao.CurrencyDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Converter {
    private ArrayList<Currency> currencies;
    private CurrencyDao dao;
    private ConverterController controller;

    public Converter(ConverterController controller) {
        this.dao = new CurrencyDao();
        this.controller = controller;

        ArrayList<Currency> alldata = dao.findAll();

        if (alldata == null) {
            System.out.println("Error: Could not retrieve currency data.");
            this.controller.setResult("Error: Could not retrieve currency data.");
            System.exit(1);
        }

        this.currencies = alldata;
    }

    public ArrayList<Currency> getall() {
        return currencies;
    }

    public String convert(String convertablekey, String convertedkey, String value) {
        if (Double.parseDouble(value) <= 0) {
            return String.valueOf("Invalid Amount!");
        } else if ((dao.find(convertablekey).getConversionRate() != 0.0) && (dao.find(convertablekey).getConversionRate() != 0.0)) {
            double convertablevalue = dao.find(convertablekey).getConversionRate();
            double convertedvalue = dao.find(convertablekey).getConversionRate();

            return String.valueOf("%,.2f".formatted(Double.parseDouble(value) * (convertedvalue / convertablevalue)));
        } else {
            return String.valueOf("Invalid Currency!");
        }
    }
}
