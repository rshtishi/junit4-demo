package com.github.rshtishi;

import junitparams.FileParameters;
import junitparams.mappers.CsvWithHeaderMapper;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
public class ReadExcelTest {

    @Test
    @DataLoader(filePaths = {"test-data.xls"}, loaderType = LoaderType.EXCEL)
    public void shouldCalculateDiscount(@Param(name = "value") Double value, @Param(name = "result") Double expectedResult) {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        double result = discountCalculator.calculate(value);
        assertEquals(expectedResult, result, 0);
    }
}
