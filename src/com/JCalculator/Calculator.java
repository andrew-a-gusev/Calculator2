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
/**
 * 1. This trick makes it absolutelly unclear of how to feed calculator with values.
 *    While tricks are acceptable somethimes, we should avoid it if we can, as future support of such code is expensive
 * 2. Now we have a HARD dependency between two classes, say I want to re-use CalculateResult in my new project, 
  *   how can I do it without having access to its source code ?
 */
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



