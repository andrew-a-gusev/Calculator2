package com.JCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Calculator {
   public static ArrayList<String> listOperations = new ArrayList<String>();
    public static ArrayList<String> listNumbers = new ArrayList<String>();
    public static String resultation = "";
    public static String example="";
    public static void main(String[] args) throws IOException {
         try {
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             System.out.println("Enter example ");
             example=reader.readLine();
             Calculate calculate = new Calculate();
             while (!example.equals("exit"))  {

 if (example.length()==1) throw new NumberFormatException();
                 resultation+=example;
                 example=resultation;
                 String[] result = example.split("(-|\\+|\\*|\\/)");
             for (int i = 0; i < result.length; i++) {
                 listNumbers.add(result[i]);
             }


             for (int i = 0; i < example.length(); i++) {
                 if (example.charAt(i) == '+' || example.charAt(i) == '-' || example.charAt(i) == '*' || example.charAt(i) == '/')
                     listOperations.add(Character.toString(example.charAt(i)));
             }

                calculate.result(resultation);

             System.out.println("Resultat: "+listNumbers.get(0));
                 resultation=listNumbers.get(0);
                 listNumbers.remove(0);
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
