package dao;


import Model.*;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {

    public void persist(Currency currency) {
        EntityManager em = datasource.MariaDbConnection.getInstance();
        em.getTransaction().begin();
        em.persist(currency);
        em.getTransaction().commit();
    }

    public Currency find(String id) {
        EntityManager em = datasource.MariaDbConnection.getInstance();
        Currency emp = em.find(Currency.class, id);
        return emp;
    }

    public ArrayList<Currency> findAll() {
        EntityManager em = datasource.MariaDbConnection.getInstance();
        List<Currency> currencyList = em.createQuery("select e from Currency e").getResultList();
        return new ArrayList<Currency>(currencyList);
    }

    public void update(Currency currency) {
        EntityManager em = datasource.MariaDbConnection.getInstance();
        em.getTransaction().begin();
        em.merge(currency);
        em.getTransaction().commit();
    }

    public void delete(Currency currency) {
        EntityManager em = datasource.MariaDbConnection.getInstance();
        em.getTransaction().begin();
        em.remove(currency);
        em.getTransaction().commit();
    }


    /*
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
