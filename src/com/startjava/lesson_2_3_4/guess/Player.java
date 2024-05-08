package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private final String name;
    private int triesCount;
    private final int capacity = 10;
    private final int[] numbs = new int[capacity];

    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCountTries() {
        return triesCount;
    }

    public int[] getNumbs() {
        return Arrays.copyOf(numbs, (triesCount == 0 ? 1 : triesCount));
    }

    public int getNumb() {
        return numbs[triesCount - 1];
    }

    public boolean addNumb(int num) {
        if (num > 0 && num <= 100) {
            numbs[triesCount] = num;
            triesCount++;
            return true;
        }
        System.out.println("Введенное Вами число не соответствует требованию, повторите ввод!");
        return false;
    }

    public int getWinCount() {
        return score;
    }

    public void setWinCount(int winCount) {
        this.score = winCount;
    }

    public void clear() {
        Arrays.fill(numbs, 0, triesCount, 0);
        triesCount = 0;
    }
}
