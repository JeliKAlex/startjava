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
        } while (player2.getCountTries() != 0);
        System.out.println("\nНикому не удалось отгадать число: " + targetNum);
        endGame(player1, player2);
    }

    private void enterNum(Player player) {
        if (player.getCountTries() > 0) {
            int position = player.getNumbs().length - player.getCountTries();
            do {
                System.out.print("\n" + player.getName() + ", введи число из полуинтервала (0, 100]: ");
                player.setNumbs(scan.nextInt(), position);
            } while (player.getNumbs()[position] <= 0 || player.getNumbs()[position] > 100);
            player.setCountTries(player.getCountTries() - 1);
        }
    }

    private boolean isGuessed(Player player) {
        int playerNum = player.getNumbs()[countTries - player.getCountTries() - 1];
        if (playerNum == targetNum) {
            System.out.println("\nИгрок " + player.getName() + " угадал  число \"" + targetNum +
                    "\" c " + (countTries - player.getCountTries()) + " попытки.");
            return true;
        }

        System.out.println("Число " + playerNum + (playerNum > targetNum ? " больше" : " меньше") +
                " того, что загадал компьютер\n" + "У " + player.getName() + (player.getCountTries() > 0 ?
                " осталось " + player.getCountTries() + " попыток." : " закончились попытки."));

        return false;
    }

    private static void endGame(Player player1, Player player2) {
        System.out.println("Игра окончена!");
        player1.printArray();
        player1.resetResults();
        player2.printArray();
        player2.resetResults();
    }
}
