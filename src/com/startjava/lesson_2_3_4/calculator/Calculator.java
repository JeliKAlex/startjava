package com.startjava.lesson_2_3_4.calculator;

public class Calculator {
    public static double calculate(String mathExpression) {
        String[] elements = mathExpression.split(" ");
        if (elements.length != 3) {
            throw new RuntimeException("Длина математического выражения должна быть равна 3!" +
                    "\n2 аргумента и 1 оператор (Например: 1 + 1).");
        }

        char operation = elements[1].charAt(0);
        int a;
        int b;
        try {
            a = Integer.parseInt(elements[0]);
            b = Integer.parseInt(elements[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Аргументами доллжны выступать положительные числа!");
        }

        if (a <= 0 || b <= 0) {
            throw new RuntimeException("Числа должны быть положительными!");
        }

        return switch (operation) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> (double) a / b;
            case '%' -> a % b;
            case '^' -> Math.pow(a, b);
            default ->
                    throw new RuntimeException("Математическая операция не поддерживается!");
        };
    }
}
