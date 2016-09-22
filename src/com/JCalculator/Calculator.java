package com.JCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the first number: ");
            double firstNumber = Double.parseDouble(reader.readLine());
            System.out.print("Enter operation +,-,* or / :");
            String sign = reader.readLine();
            System.out.print("Enter the second number:");
            double secondNumber = Double.parseDouble(reader.readLine());


            switch (sign) {
                case "+":
                    System.out.println("Result: " + (firstNumber + secondNumber));
                    break;
                case "-":
                    System.out.println("Result: " + (firstNumber - secondNumber));
                    break;
                case "*":
                    System.out.println("Result: " + (firstNumber * secondNumber));
                    break;
                case "/":
                    if (secondNumber == 0) System.out.println("Division by zero");
                    System.out.println("Result: " + (firstNumber / secondNumber));
                    break;
                default:
                    System.out.println("Error operation");
                    break;

            }


        } catch (NumberFormatException e) {
            System.out.println("Error : enter the number");
        }


    }
}
