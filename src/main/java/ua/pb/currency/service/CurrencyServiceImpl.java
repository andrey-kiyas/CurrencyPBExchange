package ua.pb.currency.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pb.currency.dao.CurrencyDao;
import ua.pb.currency.model.Currency;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private CurrencyDao currencyDao;

    public void setCurrencyDao(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }

    @Transactional
    public void addCurrency(Currency currency) {
        this.currencyDao.addCurrency(currency);
    }

    @Transactional
    public void updateCurrency(Currency currency) {
        this.currencyDao.updateCurrency(currency);
    }

    @Transactional
    public void removeCurrency(int id) {
        this.currencyDao.removeCurrency(id);
    }

    @Transactional
    public Currency getCurrencyById(int id) {
        return this.currencyDao.getCurrencyById(id);
    }

    @Transactional
    public List<Currency> listCurrency() {
        return this.currencyDao.listCurrency();
    }
}
