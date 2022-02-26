package com.github.rshtishi;

public class Caclulator {

    public static double divide(int num1,int num2){
        if (num2 == 0) {
            throw new IllegalArgumentException("divider cannot be 0");
        }
        double result = num1/num2;
        return result;
    }
}
