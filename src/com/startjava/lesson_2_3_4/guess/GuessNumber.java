package com.startjava.lesson_2_3_4.guess;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private static final int PLAYERS_LIMIT = 3;
    private static final int ROUNDS_LIMIT = 3;
    private static final int TARGET_NUMB_LIMIT = 100;
    private static final int TRIES_LIMIT = 10;
    private final Player[] players = new Player[PLAYERS_LIMIT];
    private final Random random = new Random();
    private final Scanner scan = new Scanner(System.in);
    private int targetNumb;
    private int currentRound;

    public GuessNumber(String[] names) {
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(names[i]);
        }
    }

    public void start() {
        currentRound = 0;
        for (Player player : players) {
            player.setWinCount(0);
        }
        shuffle();
        while (currentRound < ROUNDS_LIMIT) {
            startRound();
            endGame();
        }
        defineWinner();
    }

    public void startRound() {
        targetNumb = random.nextInt(TARGET_NUMB_LIMIT) + 1;
        System.out.println("\n" + targetNumb);

        System.out.println("\nИгра началась! У каждого игрока по " + TRIES_LIMIT + " попыток.\n" +
                    (currentRound + 1) + " раунд.");

        do {
            for (Player player : players) {
                if (player.getCountTries() < TRIES_LIMIT) enterNumb(player);
                if (isGuessed(player)) return;
            }
        } while (players[players.length - 1].getCountTries() < TRIES_LIMIT);
        System.out.println("\nНикому не удалось отгадать число: " + targetNumb);
    }

    private void shuffle() {
        int length = players.length;
        for (int i = length - 1; i >= 1; i--) {
            int randomNumb = random.nextInt(i + 1);

            Player tmp = players[i];
            players[i] = players[randomNumb];
            players[randomNumb] = tmp;
        }
    }

    private void enterNumb(Player player) {
        int playerNumb;
        do {
            System.out.print("\n" + player.getName() + ", введи число из полуинтервала (0, 100]: ");
            playerNumb = scan.nextInt();
        } while (!player.addNumb(playerNumb));
    }

    private boolean isGuessed(Player player) {
        int playerNum = player.getNumb();
        if (playerNum == targetNumb) {
            System.out.println("\nИгрок " + player.getName() + " угадал  число \"" + targetNumb +
                    "\" c " + (player.getCountTries()) + " попытки.");
            player.setWinCount(player.getWinCount() + 1);
            return true;
        }

        System.out.println("Число " + playerNum + (playerNum > targetNumb ? " больше" : " меньше") +
                " того, что загадал компьютер");
        checkTries(player);
        return false;
    }

    private void endGame() {
        System.out.println("Игра окончена!");
        for (Player player : players) {
            if (player.getCountTries() > 0) {
                printNumbs(player);
                player.clear();
            }
        }
        currentRound++;
    }

    private void checkTries(Player player) {
        System.out.println("У " + player.getName() + (player.getCountTries() < TRIES_LIMIT ? " осталось " +
                (TRIES_LIMIT - player.getCountTries()) + " попыток." : " закончились попытки."));
    }

    private static void printNumbs(Player player) {
        System.out.print("\nЧисла игрока " + player.getName() + ":\n");
        for (int numb : player.getNumbs()) {
            System.out.printf("%3d%s", numb, " ");
        }
        System.out.println();
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
        System.out.println("\nПо итогам " + currentRound + " раундов");
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
