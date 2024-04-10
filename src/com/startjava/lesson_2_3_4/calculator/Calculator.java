package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    private int a;
    private int b;
    private char operation;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public double calculate() {
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
}
