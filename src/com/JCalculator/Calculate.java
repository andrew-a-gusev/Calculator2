package com.JCalculator;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.JCalculator.Calculator.*;

public class Calculate extends MathFormula {

    public void result(String resultation) throws IOException {
        Pattern p = Pattern.compile("[0-9,+,-,*,/]+");
        Matcher m = p.matcher(example);
        if (!m.find()) throw new NumberFormatException();
        resultation += example;
        example = resultation;
        String[] result = example.split("(-|\\+|\\*|\\/)");

        for (int i = 0; i < result.length; i++) {
            listNumbers.add(result[i]);
        }

        for (int i = 0; i < example.length(); i++) {
            if (example.charAt(i) == '+' || example.charAt(i) == '-' || example.charAt(i) == '*' || example.charAt(i) == '/')
                listOperations.add(Character.toString(example.charAt(i)));
        }

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


}
