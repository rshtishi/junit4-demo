package com.github.rshtishi;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class ReadCSVJUnitParamsTes {

    @Test
    @FileParameters(value = "classpath:test-data.csv", mapper = CsvWithHeaderMapper.class)
    public void shouldCalculateDiscount(double value, double expectedResult) {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        double result = discountCalculator.calculate(value);
        assertEquals(expectedResult,result,0);
    }
}
