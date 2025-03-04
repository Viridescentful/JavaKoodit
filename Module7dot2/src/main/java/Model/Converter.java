package Model;

import dao.CurrencyDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Converter {
    private HashMap<String, List> currencies;
    private CurrencyDao dao;

    public Converter() {
        this.dao = new CurrencyDao();
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
