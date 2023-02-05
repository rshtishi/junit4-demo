package com.github.rshtishi;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class MoneyParameterizedTest {

    public static final Object[] getTestData() {
        return new Object[]{
                new Object[]{10, "EUR"},
                new Object[]{20, "USD"},
                new Object[]{30, "ALL"},
        };
    }

    public static final Object[] getInvalidAmountTestData(){
        return new Object[]{
                new Object[]{-1,""},
                new Object[]{-5,"EUR"},
                new Object[]{-8, null}
        };
    }

    @Test
    @Parameters(method = "getTestData")
    public void constructorShouldSetAmountAndCurrency(int amount, String currency) {
        Money money = new Money(amount,currency);
        assertEquals(amount,money.getAmount());
        assertEquals(currency,money.getCurrency());
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method="getInvalidAmountTestData")
    public void constructorShouldThrowInvalidAmountExcption(int amount, String currency){
        try{

        } catch(Exception e){
            String expectedMessage = "";
            //assertequal
            throw e;
        }
    }

}