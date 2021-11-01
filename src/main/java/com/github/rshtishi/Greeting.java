package com.github.rshtishi;

import com.github.rshtishi.doc.TimeProvider;

import java.util.Calendar;

public class Greeting {

    private TimeProvider timeProvider;

    public Greeting(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public String greet() {
        Calendar current = timeProvider.getTime();
        if (current.get(Calendar.HOUR_OF_DAY) < 12) {
            return "Good morning!";
        } else {
            return "Good afternoon!";
        }
    }
}
