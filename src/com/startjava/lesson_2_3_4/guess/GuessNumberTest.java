package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Первый игрок, представьтесь!");
        String name1 = scan.nextLine();
        System.out.println("Второй игрок, представьтесь!");
        String name2 = scan.nextLine();

        GuessNumber game = new GuessNumber(name1, name2);
        String answer = "yes";
        do {
            if (answer.equals("yes")) {
                game.start();
            }
            System.out.println("\n\nХотите продолжить игру? [yes/no]: ");
            answer = scan.nextLine();
        } while (!answer.equals("no"));
    }
}
