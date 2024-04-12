package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculatorOne = new Calculator();
        Scanner scan = new Scanner(System.in);
        String answer = "yes";

        do {
            if (answer.equals("yes")) {
                System.out.print("\nВведите математическое выражение: ");
                String line = scan.nextLine();
                double result = calculatorOne.calculate(line);
                calculatorOne.print(result, line);
            }

            System.out.println("\nХотите продолжить вычисления? [yes/no]: ");
            answer = scan.nextLine();
        } while (!answer.equals("no"));
    }
}
