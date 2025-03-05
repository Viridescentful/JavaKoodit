package dao;

import Model.Converter;
import java.sql.*;
import datasource.MariaDbConnection;
import java.util.*;

public class CurrencyDao {
    public HashMap<String, List> getAllCurrencies() {
        Connection conn = MariaDbConnection.getConnection();

        if (conn == null) {
            return null;
        }

        String sql = "SELECT code, currency_name, conversion_rate FROM currencies";

        HashMap<String, List> alldata = new HashMap<>();

        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                List<Object> currency = new ArrayList<>();
                currency.add(rs.getString(2));
                currency.add(rs.getDouble(3));

                alldata.put(rs.getString(1), currency);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alldata;
    }


    public double getConversion(String key) {
        Connection conn = MariaDbConnection.getConnection();

        if (conn == null) {
            return 0.0;
        }

        String sql = "SELECT conversion_rate FROM currencies WHERE code=?";

        double conversionRate = 0.0;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, key);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                conversionRate = rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conversionRate;
    }
    /*
    public void persist(Employee emp) {
        Connection conn = MariaDbConnection.getConnection();
        String sql = "INSERT INTO employee (first_name, last_name, email, salary) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setString(3, emp.getEmail());
            ps.setDouble(4, emp.getSalary());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


     */
}
