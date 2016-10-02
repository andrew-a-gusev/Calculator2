package com.JCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

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
                if (resultation.contains("--")) {

                    resultation = resultation.substring(2, resultation.length());
                }
                System.out.println("Resultat: " + resultation);
                example = reader.readLine();

            }
        } catch (NumberFormatException e) {
            System.out.println("Error: data entry " + e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: data entry " + e);
        } catch (ArithmeticException e) {
            System.out.println("Error: Divide by zero");
        }
    }
}



