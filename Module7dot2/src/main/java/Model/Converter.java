package Model;

import Controller.ConverterController;
import dao.CurrencyDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Converter {
    private HashMap<String, List> currencies;
    private CurrencyDao dao;
    private ConverterController controller;

    public Converter(ConverterController controller) {
        this.dao = new CurrencyDao();
        this.controller = controller;

        HashMap<String, List> alldata = dao.getAllCurrencies();

        if (alldata == null) {
            System.out.println("Could not retrieve currency data.");
            this.controller.setResult("Could not retrieve currency data.");
            System.exit(1);
        }

        this.currencies = dao.getAllCurrencies();
    }

    public HashMap getall() {
        return currencies;
    }

    public String convert(String convertablekey, String convertedkey, String value) {
        if (Double.parseDouble(value) <= 0) {
            return String.valueOf("Invalid Amount!");
        } else if ((dao.getConversion(convertablekey) != 0.0) && (dao.getConversion(convertablekey) != 0.0)) {
            double convertablevalue = dao.getConversion(convertablekey);
            double convertedvalue = dao.getConversion(convertedkey);

            return String.valueOf("%,.2f".formatted(Double.parseDouble(value) * (convertedvalue / convertablevalue)));
        } else {
            return String.valueOf("Invalid Currency!");
        }
    }
}
