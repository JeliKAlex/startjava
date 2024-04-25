package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private  Player[] players = new Player[3];
    private int targetNumb;
    private final Random random = new Random();
    private final Scanner scan = new Scanner(System.in);
    private final int triesLimit = 10;
    private int rounds;

    public GuessNumber(String name1, String name2, String name3) {
        players[0] = new Player(name1);
        players[1] = new Player(name2);
        players[2] = new Player(name3);
    }

    public void start() {
        rounds = 0;
        for (Player player : players) {
            player.setWinCount(0);
        }
        shuffle();
        while (rounds < 3) {
            startRound();
        }
        defineWinner();
    }

    public void startRound() {
        targetNumb = random.nextInt(100) + 1;
        System.out.println("\n" + targetNumb);

        System.out.println("\nИгра началась! У каждого игрока по " + triesLimit + " попыток.\n" +
                    (rounds + 1) + " раунд.");

        do {
            for (Player player : players) {
                enterNumb(player);
                if (isGuessed(player)) return;
            }
        } while (players[players.length - 1].getCountTries() < triesLimit);
        System.out.println("\nНикому не удалось отгадать число: " + targetNumb);
        gameOver();
    }

    private void enterNumb(Player player) {
        if (player.getCountTries() < triesLimit) {
            int playerNum;
            do {
                System.out.print("\n" + player.getName() + ", введи число из полуинтервала (0, 100]: ");
                playerNum = scan.nextInt();
            } while (!player.addNumb(playerNum));
        }
    }

    private boolean isGuessed(Player player) {
        int playerNum = player.getNumb(player.getCountTries() - 1);
        if (playerNum == targetNumb) {
            System.out.println("\nИгрок " + player.getName() + " угадал  число \"" + targetNumb +
                    "\" c " + (player.getCountTries()) + " попытки.");
            player.setWinCount(player.getWinCount() + 1);
            gameOver();
            return true;
        }

        System.out.println("Число " + playerNum + (playerNum > targetNumb ? " больше" : " меньше") +
                " того, что загадал компьютер");
        System.out.println("У " + player.getName() + (player.getCountTries() < triesLimit ? " осталось " +
                (triesLimit - player.getCountTries()) + " попыток." : " закончились попытки."));

        return false;
    }

    private void gameOver() {
        System.out.println("Игра окончена!");
        for (Player player : players) {
            if (player.getCountTries() > 0) {
                printNumbs(player);
                player.clear();
            }
        }
        rounds++;
    }

    private static void printNumbs(Player player) {
        System.out.print("\nЧисла игрока " + player.getName() + ":\n");
        for (int numb : player.getNumbs()) {
            System.out.printf("%3d%s", numb, " ");
        }
        System.out.println();
    }

    private void shuffle() {
        int n = players.length;
        for (int i = n - 1; i >= 1; i--) {
            int j = random.nextInt(i + 1);

            Player tmp = players[i];
            players[i] = players[j];
            players[j] = tmp;
        }
    }

    private void defineWinner() {
        int len = players.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (players[i].getWinCount() > players[j].getWinCount()) {
                    Player tmp = players[i];
                    players[i] = players[j];
                    players[j] = tmp;
                }
            }
        }
        System.out.println("\nПо итогам " + rounds + " раундов");
        Player winner = players[len - 1];
        if (winner.getWinCount() == 0) {
            System.out.println("Никто ни разу не угадал число..");
        } else if (winner.getWinCount() == players[len - 2].getWinCount()) {
            System.out.println("Ничья!");
        } else {
            System.out.println(winner.getName() + " одержал победу!");
        }
    }
}
