package com.github.rshtishi;

public class DiscountCalculator {

    private double discountPercentage = 0.2;

    public double calculate(double value){
        double result = value * discountPercentage;
        return result;
    }
}
