package com.JCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Calculator {
    public static void main(String[] args) throws IOException {
       // try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter example ");
            String example=reader.readLine();
        int j;
        String [] result=example.split("[+-/*]");
        String resultation="";
        ArrayList<String> list=new ArrayList<String>();
        ArrayList<String> list2=new ArrayList<String>();
        for (int i = 0; i < result.length; i++) {
            list2.add(result[i]);
        }

        Calculate calculate=new Calculate();
        for (int i = 0; i <example.length() ; i++) {
            if(example.charAt(i)=='+' || example.charAt(i)=='-' || example.charAt(i)=='*' || example.charAt(i)=='/')
                list.add(Character.toString(example.charAt(i)));
        }

        for (int i = 0; i <list.size() ; ) {
            if (list.get(i).equals("/") || list.get(i).equals("*")) {
                if (list.get(i).equals("/")) {
                    resultation = Double.toString(calculate.division(Double.parseDouble(list2.get(i)), Double.parseDouble(list2.get(i + 1))));
                    list2.set(i, resultation);
                    list2.remove(i + 1);
                    list.remove(i);
                } else
                if (list.get(i).equals("*")) {
                    resultation = Double.toString(calculate.multiplication(Double.parseDouble(list2.get(i)), Double.parseDouble(list2.get(i + 1))));
                    list2.set(i, resultation);
                    list2.remove(i + 1);
                    list.remove(i);
                }
            } else i++;
        }

        for (int i = 0; i <list.size() ; ) {
            if (list.get(i).equals("+") || list.get(i).equals("-")) {
                if (list.get(i).equals("-")) {
                    resultation = Double.toString(calculate.subtraction(Double.parseDouble(list2.get(i)), Double.parseDouble(list2.get(i + 1))));
                    list2.set(i, resultation);
                    list2.remove(i + 1);
                    list.remove(i);
                }
                else
                if (list.get(i).equals("+")) {
                    resultation = Double.toString(calculate.addition(Double.parseDouble(list2.get(i)), Double.parseDouble(list2.get(i + 1))));
                    list2.set(i, resultation);
                    list2.remove(i + 1);
                    list.remove(i);
                }
            } else i++;
        }



        System.out.println("Resultat: "+list2);

    }
}
