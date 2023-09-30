package com.github.rshtishi;

import java.util.List;

public class Money2 {

    private final int amount;
    private final String currency;
    private static CurrencyDAO currencyDAO ;

    public static void setCurrencyDAO(CurrencyDAO currencyDAO){
        Money2.currencyDAO = currencyDAO;
    }

    private Money2(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money2 getInstance(int amount, String currency){
        if (amount < 0) {
            throw new IllegalArgumentException("illegal amount: [" + amount + "]");
        }
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("illegal currency: [" + currency + "]");
        }
        List<String> allowedCurrencies = currencyDAO.getValidCCY();
        if(allowedCurrencies!=null && !allowedCurrencies.contains(currency)){
            throw new IllegalArgumentException("The currency: ["+currency+"] is not allowed");
        }
        return new Money2(amount, currency);
    }

    public int getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
