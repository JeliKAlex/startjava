package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private final Player player1;
    private final Player player2;
    private int targetNumb;
    private final Random random = new Random();
    private final Scanner scan = new Scanner(System.in);
    private final int triesLimit = 10;
    private int playerNum;

    public GuessNumber(String name1, String name2) {
        player1 = new Player(name1);
        player2 = new Player(name2);
    }

    public void start() {
        targetNumb = random.nextInt(100) + 1;
        System.out.println(targetNumb);

        System.out.println("\nИгра началась! У каждого игрока по " + triesLimit + " попыток.");

        do {
            enterNum(player1);
            if (isGuessed(player1)) {
                return;
            }

            enterNum(player2);
            if (isGuessed(player2)) {
                return;
            }
        } while (player2.getCountTries() < triesLimit);
        System.out.println("\nНикому не удалось отгадать число: " + targetNumb);
    }

    private void enterNum(Player player) {
        if (player.getCountTries() < triesLimit) {
            do {
                System.out.print("\n" + player.getName() + ", введи число из полуинтервала (0, 100]: ");
                playerNum = scan.nextInt();
            } while (playerNum <= 0 || playerNum > 100);
            player.addNumb(playerNum);
        }
    }

    private boolean isGuessed(Player player) {
        playerNum = player.getNumb(player.getCountTries() - 1);
        if (playerNum == targetNumb) {
            System.out.println("\nИгрок " + player.getName() + " угадал  число \"" + targetNumb +
                    "\" c " + (player.getCountTries()) + " попытки.");
            return true;
        }

        System.out.println("Число " + playerNum + (playerNum > targetNumb ? " больше" : " меньше") +
                " того, что загадал компьютер");
        System.out.println("У " + player.getName() + (player.getCountTries() < 10 ? " осталось " +
                (triesLimit - player.getCountTries()) + " попыток." : " закончились попытки."));

        return false;
    }

    public void end() {
        System.out.println("Игра окончена!");
        printNumbs(player1);
        player1.clear();
        if (player2.getCountTries() > 0) {
            printNumbs(player2);
            player2.clear();
        }
    }

    private static void printNumbs(Player player) {
        System.out.print("\nЧисла игрока " + player.getName() + ":\n");
        int count = 1;
        for (int numb : player.getNumbs()) {
            System.out.printf("%3d%s", numb, (count == player.getLen() / 2 ? "\n" : " "));
            count++;
        }
        System.out.println();
    }
}
