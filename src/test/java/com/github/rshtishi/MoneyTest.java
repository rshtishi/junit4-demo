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

}