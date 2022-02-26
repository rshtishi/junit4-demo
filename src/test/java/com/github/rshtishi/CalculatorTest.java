package com.github.rshtishi;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void divideIsSuccessWhenDivederIsNotZero() {
        //setup
        int num1 = 4;
        int num2 = 2;
        //execute
        double result = Caclulator.divide(num1, num2);
        //verify
        double expectedResult = 2;
        assertEquals(expectedResult,result,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenDivederIsZeroThrowIllegalArgumentException(){
        //setup
        int num1 = 4;
        int num2 = 0;
        //execute
        try{
            double result = Caclulator.divide(num1,num2);
        } catch(Exception e){
            //verify
            String message = e.getMessage();
            String expectedMessage = "divider cannot be 0";
            assertEquals(expectedMessage,message);
            throw e;
        }
    }

}