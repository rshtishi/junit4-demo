package com.github.rshtishi.doc;

public class AverageCalculator {

    public double compute(int num1,int num2) {
        int sum = calculateSum(num1, num2);
        return sum / 2;
    }

    private int calculateSum(int num1,int num2) {
        return num1+num2;
    }
}
