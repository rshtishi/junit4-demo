package com.github.rshtishi;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Money2Test {

    private  CurrencyDAO currencyDAO;

    @Before
    public void setup(){
        List<String> allowedCCY = Arrays.asList("EUR","ALL");
        currencyDAO = mock(CurrencyDAO.class);
        when(currencyDAO.getValidCCY()).thenReturn(allowedCCY);
        Money2.setCurrencyDAO(currencyDAO);
    }

    @Test
    public void whenAmountANdCCYisValidThenCreateMoney() {
        //setup
        int amount = 0;
        String ccy = "EUR";
        // execute
        Money2 money = Money2.getInstance(amount, ccy);
        //verify
        assertEquals(amount, money.getAmount());
        assertEquals(ccy, money.getCurrency());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowNotValidCCYWhenCCYisNotInTheAllowedList(){
        //setup
        int amount = 5;
        try{
            Money2 money2 = Money2.getInstance(amount, "USD");
        } catch(IllegalArgumentException e){
            String expectedMessage = "The currency: [USD] is not allowed";
            assertEquals(expectedMessage,e.getMessage());
            throw e;
        }
    }

}