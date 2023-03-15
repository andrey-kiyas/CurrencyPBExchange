package ua.pb.currency.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.pb.currency.model.Currency;

import java.util.List;

@Repository
public class CurrencyDaoImpl implements CurrencyDao {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCurrency(Currency currency) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(currency);
        logger.info("Currency successfully saved. Currency details: " + currency);
    }

    public void updateCurrency(Currency currency) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(currency);
        logger.info("Currency successfully update. Currency details: " + currency);
    }

    public void removeCurrency(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Currency currency = (Currency) session.load(Currency.class, id);
        if (currency != null) {
            session.delete(currency);
        }
        logger.info("Currency successfully removed. Currency details: " + currency);
    }

    public Currency getCurrencyById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Currency currency = (Currency) session.load(Currency.class, id);
        logger.info("Currency successfully loaded. Currency details: " + currency);
        return currency;
    }

    @SuppressWarnings("unchecked")
    public List<Currency> listCurrency() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Currency> currencyList = session.createQuery("from Currency").list();
        for (Currency currency : currencyList) {
            logger.info("Currency list: " + currency);
        }
        return currencyList;
    }
}
