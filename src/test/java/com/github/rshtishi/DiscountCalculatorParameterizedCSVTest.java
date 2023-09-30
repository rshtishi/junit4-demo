package com.github.rshtishi;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class DiscountCalculatorParameterizedCSVTest {


    @Test
    @FileParameters(value = "classpath:test-data.csv")
    public void shouldCalculateDiscount(double value, double expectedResult) {
        //setup
        DiscountCalculator discountCalculator = new DiscountCalculator();
        //execute
        double result = discountCalculator.calculate(value);
        //verify
        assertEquals(expectedResult,result,0);
    }
}
