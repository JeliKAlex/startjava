package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculatorOne = new Calculator();
        Scanner scan = new Scanner(System.in);
        String answer;

        do {
            System.out.print("\nВведите математическое выражение: ");
            String line = scan.nextLine();
            String [] mathExpression = line.split(" ");
            calculatorOne.setA(Integer.parseInt(mathExpression[0]));
            calculatorOne.setOperation(mathExpression[1].charAt(0));
            calculatorOne.setB(Integer.parseInt(mathExpression[2]));
            double result = calculatorOne.calculate();

            if (result % (int) result > 0) {
                System.out.printf("%s%.3f", line + " = ", calculatorOne.calculate());
            } else {
                System.out.printf("%s%.0f", line + " = ", calculatorOne.calculate());
            }

            do {
                System.out.println("\nХотите продолжить вычисления? [yes/no]: ");
                answer = scan.nextLine();
            } while (!answer.equals("yes") && !answer.equals("no"));
        } while (answer.equals("yes"));
    }
}
