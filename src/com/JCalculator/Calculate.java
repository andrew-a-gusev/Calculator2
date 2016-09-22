package com.JCalculator;

public class Calculate implements MathematicalOperations {
    @Override
    public double addition(double firstNumb, double secondNumb) {
        return (firstNumb+secondNumb);
    }

    @Override
    public double subtraction(double firstNumb, double secondNumb) {
        return (firstNumb-secondNumb);
    }

    @Override
    public double multiplication(double firstNumb, double secondNumb) {
        return (firstNumb*secondNumb);
    }

    @Override
    public double division(double firstNumb, double secondNumb) {
        if(secondNumb==0) throw new ArithmeticException();
        return (firstNumb/secondNumb);
    }
}
