package com.github.rshtishi;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class AtomicIdGeneratorTest {

    @Rule
    public ConcurrentRule concurrentRule = new ConcurrentRule();
    @Rule
    public RepeatingRule repeatingRule = new RepeatingRule();

    private AtomicIdGenerator idGenerator = new AtomicIdGenerator();
    private Set<Long> ids = new HashSet<>(100);

    @Test
    @Concurrent(count=7)
    @Repeating(repetition = 100)
    public void idsShouldBeUnique(){
        //execute
        boolean result = ids.add(idGenerator.getNextId());
        //verify
        assertTrue(result);
    }
}