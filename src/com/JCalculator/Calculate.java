package com.JCalculator;

import static com.JCalculator.Calculator.listOperations;
import static com.JCalculator.Calculator.listNumbers;

public class Calculate extends MathFormula {

    public  void result(String resultation)    {
        for (int i = 0; i < listOperations.size(); ) {
            if (listOperations.get(i).equals("*")) {
                resultation = multiplication(resultation,Double.parseDouble(listNumbers.get(i)), Double.parseDouble(listNumbers.get(i + 1)));
                listNumbers.set(i, resultation);
                listNumbers.remove(i + 1);
                listOperations.remove(i);
            }
                else
            if (listOperations.get(i).equals("/")) {
                resultation = division(resultation,Double.parseDouble(listNumbers.get(i)) ,Double.parseDouble(listNumbers.get(i + 1)));
                listNumbers.set(i, resultation);
                listNumbers.remove(i + 1);
                listOperations.remove(i);
            }
            else i++;
        }
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
                }
                else i++;
            }
        }


}
