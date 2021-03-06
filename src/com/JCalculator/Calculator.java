package com.JCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Calculator {
    public static void main(String[] args) throws IOException {
         try {
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             System.out.println("Enter example ");

             String example=reader.readLine();;
             String resultation = "";


             Calculate calculate = new Calculate();
             while (!example.equals("exit"))  {
                 resultation+=example;
                 example=resultation;
                 String[] result = example.split("(-|\\+|\\*|\\/)");

                 ArrayList<String> listOperations = new ArrayList<String>();
                 ArrayList<String> listNumbers = new ArrayList<String>();
             for (int i = 0; i < result.length; i++) {
                 listNumbers.add(result[i]);
             }


             for (int i = 0; i < example.length(); i++) {
                 if (example.charAt(i) == '+' || example.charAt(i) == '-' || example.charAt(i) == '*' || example.charAt(i) == '/')
                     listOperations.add(Character.toString(example.charAt(i)));
             }

             for (int i = 0; i < listOperations.size(); ) {
                 if (listOperations.get(i).equals("/") || listOperations.get(i).equals("*")) {
                     if (listOperations.get(i).equals("/")) {
                         resultation = Double.toString(calculate.division(Double.parseDouble(listNumbers.get(i)), Double.parseDouble(listNumbers.get(i + 1))));
                         listNumbers.set(i, resultation);
                         listNumbers.remove(i + 1);
                         listOperations.remove(i);
                     } else if (listOperations.get(i).equals("*")) {
                         resultation = Double.toString(calculate.multiplication(Double.parseDouble(listNumbers.get(i)), Double.parseDouble(listNumbers.get(i + 1))));
                         listNumbers.set(i, resultation);
                         listNumbers.remove(i + 1);
                         listOperations.remove(i);
                     }
                 } else i++;
             }

             for (int i = 0; i < listOperations.size(); ) {

                 if (listOperations.get(i).equals("+") || listOperations.get(i).equals("-")) {
                     if (listOperations.get(i).equals("-")) {
                         resultation = Double.toString(calculate.subtraction(Double.parseDouble(listNumbers.get(i)), Double.parseDouble(listNumbers.get(i + 1))));
                         listNumbers.set(i, resultation);
                         listNumbers.remove(i + 1);
                         listOperations.remove(i);
                     } else if (listOperations.get(i).equals("+")) {
                         resultation = Double.toString(calculate.addition(Double.parseDouble(listNumbers.get(i)), Double.parseDouble(listNumbers.get(i + 1))));
                         listNumbers.set(i, resultation);
                         listNumbers.remove(i + 1);
                         listOperations.remove(i);
                     }
                 } else i++;
             }

             System.out.println("Resultat: "+listNumbers.get(0));
                 example= reader.readLine();
         }
    }
         catch (NumberFormatException e)   {
             System.out.println("Error: data entry ");
         }
         catch (IndexOutOfBoundsException e)  {
             System.out.println("Error: data entry ");
         }
         catch (ArithmeticException e)  {
             System.out.println("Error: Divide by zero");
         }





    }
}
