package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private int a;
    private int b;
    private char operation;

    public double calculate(String line) {
        String[] mathExpression = line.split(" ");
        a = Integer.parseInt(mathExpression[0]);
        operation = mathExpression[1].charAt(0);
        b = Integer.parseInt(mathExpression[2]);

        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return (double) a / b;
            case '%':
                return a % b;
            case '^':
                return Math.pow(a, b);
            default:
                System.out.println("\nОшибка: знак " + operation + " не поддерживается\n");
                return Double.NaN;
        }
    }

    public void print(double result, String line) {
        if (result % (int) result > 0) {
            System.out.printf("%s%.3f", line + " = ", result);
        } else {
            System.out.printf("%s%.0f", line + " = ", result);
        }
    }
}
