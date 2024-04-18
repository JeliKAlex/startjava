package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private final Player player1;
    private final Player player2;
    private int targetNum;
    private final Random random = new Random();
    private final Scanner scan = new Scanner(System.in);
    private final int countTries = 10;

    public GuessNumber(String name1, String name2) {
        player1 = new Player(name1);
        player2 = new Player(name2);
    }

    public void start() {
        targetNum = random.nextInt(100) + 1;
        System.out.println(targetNum);

        System.out.println("\nИгра началась! У каждого игрока по " + countTries + " попыток.");

        do {
            enterNum(player1);
            if (isGuessed(player1)) {
                endGame(player1, player2);
                return;
            }

            enterNum(player2);
            if (isGuessed(player2)) {
                endGame(player1, player2);
                return;
            }
        } while (player2.getCountTries() != 10);
        System.out.println("\nНикому не удалось отгадать число: " + targetNum);
        endGame(player1, player2);
    }

    private void enterNum(Player player) {
        if (player.getCountTries() < countTries) {
            int inputNum;
            do {
                System.out.print("\n" + player.getName() + ", введи число из полуинтервала (0, 100]: ");
                inputNum = scan.nextInt();
            } while (inputNum <= 0 || inputNum > 100);
            player.setNumb(inputNum);
        }
    }

    private boolean isGuessed(Player player) {
        int playerNum = player.getNumbs()[player.getCountTries() - 1];
        if (playerNum == targetNum) {
            System.out.println("\nИгрок " + player.getName() + " угадал  число \"" + targetNum +
                    "\" c " + (player.getCountTries()) + " попытки.");
            return true;
        }

        System.out.println("Число " + playerNum + (playerNum > targetNum ? " больше" : " меньше") +
                " того, что загадал компьютер\n" + "У " + player.getName() +
                (player.getCountTries() < 10 ? " осталось " + (countTries - player.getCountTries()) +
                " попыток." : " закончились попытки."));

        return false;
    }

    private static void endGame(Player player1, Player player2) {
        System.out.println("Игра окончена!");
        printArray(player1);
        player1.clear();
        if (player2.getCountTries() > 0) {
            printArray(player2);
            player2.clear();
        }
    }

    private static void printArray(Player player) {
        System.out.print("\nЧисла игрока " + player.getName() + ":\n");
        for (int i = 0; i < player.getNumbs().length; i++) {
            if (player.getLen() / 2 == i) {
                System.out.println();
            }
            System.out.printf("%3d ", player.getNumbs()[i]);
        }
        System.out.println();
    }
}
