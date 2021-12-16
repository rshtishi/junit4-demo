package com.github.rshtishi;

public class Phone {

    private String prefix;
    private String number;

    public Phone(String prefix, String number) {
        if (prefix == null || prefix.isEmpty() || prefix.length() != 3) {
            throw new IllegalArgumentException("illegal prefix: [" + prefix + "]");
        }
        if (number == null || number.isEmpty() || number.length() != 8) {
            throw new IllegalArgumentException("illegal number: [" + number + "]");
        }
        this.prefix = prefix;
        this.number = number;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
