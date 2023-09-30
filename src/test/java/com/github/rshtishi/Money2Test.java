package com.github.rshtishi;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class Money2Test {

    public void whenAmountANdCCYisValidThenCreateMoney() {
        //setup
        CurrencyDAO currencyDAO = null; //mock it
        when(currencyDAO.getValidCCY()).thenReturn(null);
        Money2.setCurrencyDAO(currencyDAO);
        int amount = 0;
        String ccy = "EUR";
        // execute
        Money2 money = Money2.getInstance(amount, ccy);
        //verify
        assertEquals(amount, money.getAmount());
        assertEquals(ccy, money.getCurrency());
    }

}