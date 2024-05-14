package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        GuessNumber game = new GuessNumber(inputNames());
        String answer = "yes";
        do {
            if (answer.equals("yes")) {
                game.start();
            }
            System.out.println("\n\nХотите продолжить игру? [yes/no]: ");
            answer = scan.nextLine();
        } while (!answer.equals("no"));
    }

    public static String[] inputNames() {
        String[] serialNumb = {"Первый ", "Второй ", "Третий "};
        String[] names = new String[serialNumb.length];
        for (int i = 0; i < names.length; i++) {
            System.out.println(serialNumb[i] + "игрок, представьтесь!");
            names[i] = scan.nextLine();
        }
        return names;
    }
}
