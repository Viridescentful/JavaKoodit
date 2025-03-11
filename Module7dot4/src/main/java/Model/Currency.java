package Model;

import jakarta.persistence.*;


@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    private String code;
    @Column(name="currency_name")
    private String currency_name;
    @Column(name="conversion_rate")
    private double conversion_rate;

    public Currency(String code, String currency_name, double conversion_rate) {
        this.code = code;
        this.currency_name = currency_name;
        this.conversion_rate = conversion_rate;
    }

    public Currency() {

    }

    public String getCode() {
        return code;
    }

    public String getCurrencyName() {
        return currency_name;
    }

    public double getConversionRate() {
        return conversion_rate;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCurrencyName(String currency_name) {
        this.currency_name = currency_name;
    }

    public void setConversionRate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    @Override
    public String toString() {
        return code;
    }
}
