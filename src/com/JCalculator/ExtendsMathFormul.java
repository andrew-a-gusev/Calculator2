package com.JCalculator;


import java.util.ArrayList;

import static com.JCalculator.Calculator.resultation;

public class ExtendsMathFormul extends MathFormula {
    OperatorsAndOperands operatorsAndOperands = new OperatorsAndOperands(resultation);
    ArrayList<String> listOperations = operatorsAndOperands.getOperators();
    ArrayList<String> listNumbers = operatorsAndOperands.getOperands();

    public void multiAndDivision() {
        for (int i = 0; i < listOperations.size(); ) {
            if (listOperations.get(i).equals("*")) {
                resultation = multiplication(resultation, Double.parseDouble(listNumbers.get(i)), Double.parseDouble(listNumbers.get(i + 1)));
                listNumbers.set(i, resultation);
                listNumbers.remove(i + 1);
                listOperations.remove(i);
            } else if (listOperations.get(i).equals("/")) {
                resultation = division(resultation, Double.parseDouble(listNumbers.get(i)), Double.parseDouble(listNumbers.get(i + 1)));
                listNumbers.set(i, resultation);
                listNumbers.remove(i + 1);
                listOperations.remove(i);
            } else i++;
        }
    }

    public void additionAndSubtraction() {
        for (int i = 0; i < listOperations.size(); ) {
            if (listOperations.get(i).equals("+")) {
                resultation = addition(resultation, Double.parseDouble(listNumbers.get(i)), Double.parseDouble(listNumbers.get(i + 1)));
                listNumbers.set(i, resultation);
                listNumbers.remove(i + 1);
                listOperations.remove(i);

            } else if (listOperations.get(i).equals("-")) {
                resultation = subtraction(resultation, Double.parseDouble(listNumbers.get(i)), Double.parseDouble(listNumbers.get(i + 1)));
                listNumbers.set(i, resultation);
                listNumbers.remove(i + 1);
                listOperations.remove(i);
            } else i++;
        }
    }

    public void operationsPreority() {
        multiAndDivision();
        additionAndSubtraction();
    }

}
