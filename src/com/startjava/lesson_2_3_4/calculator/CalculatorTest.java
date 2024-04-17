package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String answer = "yes";

        do {
            if (answer.equals("yes")) {
                System.out.print("\nВведите математическое выражение: ");
                String mathExpression = scan.nextLine();
                try {
                    print(Calculator.calculate(mathExpression), mathExpression);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }

            System.out.println("\nХотите продолжить вычисления? [yes/no]: ");
            answer = scan.nextLine();
        } while (!answer.equals("no"));
    }

    public static void print(double result, String mathExpression) {
        System.out.printf(result % (int) result > 0 ? "%s%.3f" : "%s%.0f", mathExpression + " = ", result);
    }
}