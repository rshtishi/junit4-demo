package com.github.rshtishi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyTest {

    /*
    Test Class (MoneyTest) -> SUT(Money)
     */
    @Test
    public void constructorShouldSetAmountAndCurrency() {
        Money money = new Money(10, "USD");
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
    public void constructorShouldThrowIllegalAmountException(){
        Money money = new Money(-1,"");
    }

}