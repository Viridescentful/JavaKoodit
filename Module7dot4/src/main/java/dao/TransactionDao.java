package dao;

import Model.Currency;
import Model.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDao {
    public void persist(Transaction transaction) {
        EntityManager em = datasource.MariaDbConnection.getInstance();
        em.getTransaction().begin();
        em.persist(transaction);
        em.getTransaction().commit();
    }

    public Transaction find(int id) {
        EntityManager em = datasource.MariaDbConnection.getInstance();
        Transaction transaction = em.find(Transaction.class, id);
        return transaction;
    }
}
