package com.github.rshtishi;

import com.github.rshtishi.doc.TimeProvider;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
public class GreetingTest {

    private static final Object[] morningHours() {
        return new Object[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    }

    private static final Object[] afternoonHours() {
        return new Object[]{12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
    }

    @Test
    @Parameters(method = "morningHours")
    public void shouldSayGoodMorningInTheMorning(int hour) {
        //setup
        TimeProvider timeProviderMock = mock(TimeProvider.class);
        when(timeProviderMock.getTime()).thenReturn(getCalendar(hour));
        Greeting greeting = new Greeting(timeProviderMock);
        //execute
        String result = greeting.greet();
        //verify
        String expected = "Good morning!";
        assertEquals(expected, result);
    }

    @Test
    @Parameters(method = "afternoonHours")
    public void shouldSayGoodAfternoonInTheNoon(int hour) {
        //setup
        TimeProvider timeProviderMock = mock(TimeProvider.class);
        when(timeProviderMock.getTime()).thenReturn(getCalendar(hour));
        Greeting greeting = new Greeting(timeProviderMock);
        //execute
        String result = greeting.greet();
        //verify
        String expected = "Good afternoon!";
        assertEquals(expected, result);
    }

    private Calendar getCalendar(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        return calendar;
    }

}