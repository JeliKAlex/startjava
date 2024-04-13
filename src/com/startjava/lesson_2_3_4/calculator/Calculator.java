package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public static double calculate(String mathExpression) {
        String[] elements = mathExpression.split(" ");
        if (elements.length != 3) {
            throw new RuntimeException("Длина математического выражения должна быть равна 3");
        }

        int a;
        try {
            a = Integer.parseInt(elements[0]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Первый аргумент не является целым числом");
        }

        char operation = elements[1].charAt(0);

        int b;
        try {
            b = Integer.parseInt(elements[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Второй аргумент не является целым числом");
        }

        if (a <= 0 || b <= 0) {
            throw new RuntimeException("Числа должны быть положительными");
        }

        return switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> (double) a / b;
            case '%' -> a % b;
            case '^' -> Math.pow(a, b);
            default ->
                throw new RuntimeException("Математическая операция не поддерживается");
        };
    }
}
