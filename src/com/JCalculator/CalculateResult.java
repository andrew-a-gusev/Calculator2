package com.JCalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.JCalculator.Calculator.*;

public class CalculateResult extends ExtendsMathFormul {
    public void result(String resultation) throws IOException {
        Pattern p = Pattern.compile("[0-9,+,-,*,/]+");
        Matcher m = p.matcher(example);
        if (!m.find()) throw new NumberFormatException();
        if (example.length() == 1) throw new NumberFormatException();
        resultation += example;
        example = resultation;
        int singTest = 0;
        int singTestR = 0;

        ArrayList<Character> cList = new ArrayList<Character>();
        for (int i = 0; i < example.length(); i++) {
            cList.add(example.charAt(i));
        }
        for (int i = 0; i < cList.size() - 1; i++) {

            if (cList.get(0) == '-') {
                cList.remove(0);
                singTestR++;
            }


        }
        StringBuilder out = new StringBuilder(cList.size());

        for (Character c : cList) {
            out.append(c);
        }
        example = out.toString();


        String[] result = example.split("(-|\\+|\\*|\\/)");

        ArrayList<Integer> singList = new ArrayList<Integer>();


        if (singTestR > 0)
            result[0] = "-" + result[0];

        for (int i = 0; i < example.length(); i++) {
            if (example.charAt(i) == '+' || example.charAt(i) == '-' || example.charAt(i) == '*' || example.charAt(i) == '/')
                listOperations.add(Character.toString(example.charAt(i)));

        }

        for (int i = 0; i < listOperations.size() - 1; i++) {
            if ((listOperations.get(i).equals("/") && listOperations.get(i + 1).equals("-")) || (listOperations.get(i).equals("*") && listOperations.get(i + 1).equals("-"))) {
                singList.add(i + 2);
                listOperations.remove(i + 1);
            }

        }


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


        multiAndDivision();
        additionAndSubtraction();


        if (singTest % 2 != 0) {
            String singString = "-";
            singString += listNumbers.get(0);
            listNumbers.set(0, singString);
        }

    }


}