package com.JCalculator;

public class MathFormula implements MathematicalOperations {
    @Override
    public String addition(String resultation, double firstNumb, double secondNumb) {

        resultation = Double.toString(firstNumb + secondNumb);

        return resultation;
    }

    @Override
    public String subtraction(String resultation, double firstNumb, double secondNumb) {
        resultation = Double.toString(firstNumb - secondNumb);
        return resultation;
    }

    @Override
    public String multiplication(String resultation, double firstNumb, double secondNumb) {
        resultation = Double.toString(firstNumb * secondNumb);
        return resultation;
    }

    @Override
    public String division(String resultation, double firstNumb, double secondNumb) {
        if (secondNumb == 0) throw new ArithmeticException();

        resultation = Double.toString(firstNumb / secondNumb);
        return resultation;
    }

}
