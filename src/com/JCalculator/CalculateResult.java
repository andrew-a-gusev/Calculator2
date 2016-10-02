package com.JCalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.JCalculator.Calculator.example;
import static com.JCalculator.Calculator.listNumbers;
import static com.JCalculator.Calculator.listOperations;

public class CalculateResult  {
    public void result(String resultation) throws IOException {

        listCreator(resultation);
        new ExtendsMathFormul().operationsPreority();
        listNumbers.clear();

    }

    void listCreator(String resultation) {
        Pattern p = Pattern.compile("[0-9,+,-,*,/]+");
        Matcher m = p.matcher(example);
        if (!m.find()) throw new NumberFormatException();
        if (example.length() == 1) throw new NumberFormatException();
        resultation += example;
        example = resultation;

        String[] result = example.split("(-|\\+|\\*|\\/)");

        ArrayList<Integer> singList = new ArrayList<Integer>();


        for (int i = 1; i < example.length(); i++) {
            if ((example.charAt(i) == '+' || example.charAt(i) == '-' || example.charAt(i) == '*' || example.charAt(i) == '/'))
                listOperations.add(Character.toString(example.charAt(i)));
        }

        for (int i = 0; i < listOperations.size() - 1; i++) {
            if ((listOperations.get(i).equals("/") && listOperations.get(i + 1).equals("-")) || (listOperations.get(i).equals("*") && listOperations.get(i + 1).equals("-"))) {
                singList.add(i + 2);
                listOperations.remove(i + 1);
            }

        }


        if (example.charAt(0) == '-') {
            listNumbers.add("-" + result[1]);

            for (int i = 2; i < result.length; i++) {
                listNumbers.add(result[i]);
            }
        } else
            for (int i = 0; i < result.length; i++) {
                listNumbers.add(result[i]);
            }

        if (!singList.isEmpty()) {
            for (int i = 0; i < singList.size(); i++) {
                listNumbers.set(singList.get(i), "-" + listNumbers.get(singList.get(i)));
            }
        }


        for (int i = 0; i < listNumbers.size(); i++) {
            if (listNumbers.get(i).isEmpty()) listNumbers.remove(i);
        }

    }

}