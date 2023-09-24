package com.github.rshtishi;

import java.util.List;

public class Money2 {

    private final int amount;
    private final String currency;
    private CurrencyDAO currencyDAO ;

    public Money2(int amount, String currency,CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
        List<String> validCurrencyList = currencyDAO.getValidCCY();
        if (amount < 0) {
            throw new IllegalArgumentException("illegal amount: [" + amount + "]");
        }
        if (currency == null || currency.isEmpty() || !validCurrencyList.contains(currency)) {
            throw new IllegalArgumentException("illegal currency: [" + currency + "]");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
