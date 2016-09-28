package com.JCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Calculator {
    public static ArrayList<String> listOperations = new ArrayList<String>();
    public static ArrayList<String> listNumbers = new ArrayList<String>();
    public static String resultation = "";
    public static String example = "";
    public static BufferedReader reader;

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter example ");
        example = reader.readLine();
        CalculateResult calculate = new CalculateResult();
        try {
            while (!example.equals("exit")) {

                calculate.result(resultation);
                if (listNumbers.get(0).contains("--")) {

                    listNumbers.set(0,listNumbers.get(0).substring(2,listNumbers.get(0).length()-1));
                }
                System.out.println("Resultat: " + listNumbers.get(0));
                resultation = listNumbers.get(0);
                listNumbers.remove(0);
                example = reader.readLine();


            }
        } catch (NumberFormatException e) {
            System.out.println("Error: data entry "+e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: data entry "+e);
        } catch (ArithmeticException e) {
            System.out.println("Error: Divide by zero");
        }
    }
}



