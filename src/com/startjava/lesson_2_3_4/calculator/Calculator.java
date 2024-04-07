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

    public int calculate() {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '%':
                return a % b;
            case '^':
                int result = 1;
                for (int i = 0; i < b; i++) {
                    result *= a;
                }
                return result;
            default:
                System.out.println("\nДанная математическая операция не поддерживается!\n");
                return 0;
        }
    }
}
