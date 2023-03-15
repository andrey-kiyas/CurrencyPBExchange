package ua.pb.currency.service;

import ua.pb.currency.model.Currency;

import java.util.List;

public interface CurrencyService {

    void addCurrency(Currency currency);

    void updateCurrency(Currency currency);

    void removeCurrency(int id);

    Currency getCurrencyById(int id);

    List<Currency> listCurrency();
}
