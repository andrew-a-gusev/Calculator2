package com.JCalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.JCalculator.Calculator.*;

public class CalculateResult extends MathFormula {

    public void result(String resultation) throws IOException {
        Pattern p = Pattern.compile("[0-9,+,-,*,/]+");
        Matcher m = p.matcher(example);
        if (!m.find()) throw new NumberFormatException();
        resultation += example;
        example = resultation;
        //fix
        int singTest=0;
        int singTestR=0;

        ArrayList<Character> cList=new ArrayList<Character>();
        for (int i = 0; i < example.length(); i++) {
            cList.add(example.charAt(i));
        }
        for (int i = 0; i < cList.size()-1; i++) {

            if (cList.get(0)=='-') {
                cList.remove(0);
                singTestR++;
            }

            if ((cList.get(i) == '*' || cList.get(i) == '/') && cList.get(i + 1) == '-'){
                cList.remove(i + 1);
                singTest++;
            }

        }
        StringBuilder out = new StringBuilder(cList.size());

        for (Character c : cList) {
            out.append(c);
        }
         example = out.toString();
       // System.out.println(example);
//
        String[] result = example.split("(-|\\+|\\*|\\/)");
        if (singTestR>0)
            result[0]="-"+result[0];
        for (int i = 0; i < result.length; i++) {

            listNumbers.add(result[i]);
        }
        //Test
        for (int i = 0; i < listNumbers.size(); i++) {
            if (listNumbers.get(i).equals("")) listNumbers.remove(i);
        }
        //

        for (int i = 0; i < example.length(); i++) {
            if (example.charAt(i) == '+' || example.charAt(i) == '-' || example.charAt(i) == '*' || example.charAt(i) == '/')
                listOperations.add(Character.toString(example.charAt(i)));
        }
        /*System.out.println(listNumbers);
        System.out.println(listOperations);*/
//test


        //testing
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

            }else if (listOperations.get(i).equals("-")) {
                resultation = subtraction(resultation, Double.parseDouble(listNumbers.get(i)), Double.parseDouble(listNumbers.get(i + 1)));
                listNumbers.set(i, resultation);
                listNumbers.remove(i + 1);
                listOperations.remove(i);
            } else i++;
        }
        if (singTest%2!=0) {
            String singString = "-";
            singString += listNumbers.get(0);
            listNumbers.set(0, singString);
        }

    }


}