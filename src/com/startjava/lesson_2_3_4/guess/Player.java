package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private static final int QUANTITY_NUMBS = 10;
    private static final int LIMIT_TARGET_NUMB = 100;
    private final String name;
    private final int[] numbs = new int[QUANTITY_NUMBS];
    private int triesCount;
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
        if (num > 0 && num <= LIMIT_TARGET_NUMB) {
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
