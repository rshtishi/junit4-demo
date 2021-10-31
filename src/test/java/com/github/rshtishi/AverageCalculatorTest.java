package com.github.rshtishi;

import com.github.rshtishi.AverageCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

@RunWith(PowerMockRunner.class)
@PrepareForTest(AverageCalculator.class)
public class AverageCalculatorTest {

    @Test
    public void calculateTheAverageSuccessfully() throws Exception {
        AverageCalculator averageCalculator = spy(new AverageCalculator());
        when(averageCalculator, method(AverageCalculator.class, "calculateSum", int.class, int.class))
                .withArguments(5,5).thenReturn(10);
        double result = averageCalculator.compute(5,5);
        assertEquals(5.0,result,0);

    }

}