package ua.pb.currency.dao;

import ua.pb.currency.model.Currency;

import java.util.List;

public interface CurrencyDao {

    void addCurrency(Currency currency);

    void updateCurrency(Currency currency);

    void removeCurrency(int id);

    Currency getCurrencyById(int id);

    List<Currency> listCurrency();
}
