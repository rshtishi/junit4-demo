package com.github.rshtishi;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneTest {

    @Test
    public void whenInputAreValidThenConstructorisSuccess() {

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