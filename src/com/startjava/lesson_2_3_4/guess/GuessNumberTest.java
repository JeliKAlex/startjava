package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

public class GuessNumberTest {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String[] names = new String[3];
        names[0] = inputName("Первый ");
        names[1] = inputName("Второй ");
        names[2] = inputName("Третий ");

        GuessNumber game = new GuessNumber(names);
        String answer = "yes";
        do {
            if (answer.equals("yes")) {
                game.start();
            }
            System.out.println("\n\nХотите продолжить игру? [yes/no]: ");
            answer = scan.nextLine();
        } while (!answer.equals("no"));
    }

    public static String inputName(String numb) {
        System.out.println(numb + "игрок, представьтесь!");
        return scan.nextLine();
    }
}
