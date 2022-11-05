package com.github.rshtishi;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneTest {

    @Test
    public void costructionshouldInitilizedCorrectlyWhenInputIsCorrect(){
        //setup
        String prefix = "355";
        String number = "12345678";
        //execute
        Phone phone = new Phone(prefix,number);
        //verify
        assertEquals(prefix,phone.getPrefix());
        assertEquals(number, phone.getNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowInvalidPrefixExceptionForInvalidPrefix(){
        //setup
        String prefix = "12";
        String number = "12345678";
        //execute
        try {
            Phone phone = new Phone(prefix, number);
        } catch(IllegalArgumentException exception){
            //verify
            String expectedMessage = "illegal prefix: [" + prefix + "]";
            assertEquals(expectedMessage,exception.getMessage());
            throw exception;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowInvalidNumberExceptionForInvalidNumber(){
        //setup
        String prefix = "123";
        String number = "1234567";
        //execute
        try {
            Phone phone = new Phone(prefix, number);
        } catch(IllegalArgumentException exception){
            //verify
            String expectedMessage = "illegal number: [" + number + "]";
            assertEquals(expectedMessage,exception.getMessage());
            throw exception;
        }
    }



}