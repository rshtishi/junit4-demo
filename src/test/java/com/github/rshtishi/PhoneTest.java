package com.github.rshtishi;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneTest {

    @Test
    public void whenInputAreValidThenConstructorisSuccess() {
        //setup
        String prefix = "355";
        String number = "12345678";
        //execute
        Phone phone = new Phone(prefix, number);
        //verify
        assertEquals(prefix, phone.getPrefix());
        assertEquals(number, phone.getNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPrefixIsInvalidThenConstructorThrowsException() {
        //setup
        String prefix = "1";
        String number;
        try {
            //execute
        } catch (Exception e) {
            //verify
            String expectedMessage = "illegal prefix: [" + prefix + "]";
        }

    }

}