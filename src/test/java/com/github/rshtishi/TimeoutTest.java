package com.github.rshtishi;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutTest {

    @Rule
    public Timeout globalTimeout = Timeout.millis(20);

    @Test
    public void willFail() throws InterruptedException {
        Thread.sleep(100);
    }
    @Test
    public void willPass() throws InterruptedException {
        Thread.sleep(10);
    }
}
