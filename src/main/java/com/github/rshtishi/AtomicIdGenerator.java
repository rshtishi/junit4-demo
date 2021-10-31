package com.github.rshtishi;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicIdGenerator {

    private static AtomicLong nextId = new AtomicLong(System.currentTimeMillis());

    public Long getNextId(){
        return nextId.incrementAndGet();
    }
}
