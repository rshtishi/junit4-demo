package com.github.rshtishi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Money2Test {


    @Test
    public void constructorShouldCreateMoneyObjectForValidInput(){
        //setup
        int amount = 10;
        String currency = "EUR";
        CurrencyDAO currencyDAOMock = mock(CurrencyDAO.class);
        when(currencyDAOMock.getValidCCY()).thenReturn(Arrays.asList("EUR"));
        //execute
        Money2 money = new Money2(amount,currency,currencyDAOMock);
        //verify
        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIllegalCurrencyArgument(){
        //setup
        int amount = 5;
        String currency = "NNN";
        CurrencyDAO currencyDAOMock = mock(CurrencyDAO.class);
        when(currencyDAOMock.getValidCCY()).thenReturn(Arrays.asList("ALL","EUR"));
        //execute
        try{
            Money2 money = new Money2(amount,currency,currencyDAOMock);
        } catch(IllegalArgumentException e){
            //verify
            String expectedMessage = "illegal currency: [" + currency + "]";
            assertEquals(expectedMessage, e.getMessage());
            throw e;
        }
    }

}