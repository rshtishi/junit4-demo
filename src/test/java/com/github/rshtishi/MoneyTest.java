package com.github.rshtishi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyTest {

    /*
    Test Class (MoneyTest) -> SUT(Money)
     */
    @Test
    public void constructorShouldSetAmountAndCurrencyWhenInputValuesAreCorrect() {
        //setup
        int amount = 10;
        String currency ="USD";
        //execute
        Money money = new Money(amount, currency);
        //verify
        assertEquals(10, money.getAmount());
        assertEquals("USD", money.getCurrency());
    }

    /*
        In this test we are not able to determine if the invalid argument exception is because
        of amount or currency being invalid.
        This could be fixed by creating customer exception class like below:
         - AmountMoneyIllegalArgumentException
         - CurrencyMoneyIllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIllegalAmountException() {

        Money money = new Money(5, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIllegalAmountArgumentException() {
        try {
            Money money = new Money(-1, "");
        } catch (IllegalArgumentException exception) {
            String expectedExceptionMessage = "illegal amount: [-1]";
            assertEquals(expectedExceptionMessage, exception.getMessage());
            throw exception;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIllegalCurrencyException() {
        try {
            Money money = new Money(5, "");
        } catch (IllegalArgumentException exception) {
            String expectedExceptionMessage = "illegal currency: []";
            assertEquals(expectedExceptionMessage, exception.getMessage());
            throw exception;
        }
    }

}