package com.github.rshtishi;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void divideIsSuccessWhenDivederIsNotZero() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void whenDivederIsZeroThrowIllegalArgumentException(){
    }

}