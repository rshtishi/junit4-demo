package com.github.rshtishi;

public class AtomicIdGenerator {

    private static Long nextId = System.currentTimeMillis();

    public Long getNextId(){
        return nextId++;
    }
}
