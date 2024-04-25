package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private String name;
    private int countTries;
    private int capacity = 10;
    private int[] numbs = new int[capacity];

    private int winCount;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCountTries() {
        return countTries;
    }

    public int[] getNumbs() {
        return Arrays.copyOf(numbs, (countTries == 0 ? 1 : countTries));
    }

    public boolean addNumb(int num) {
        if (num > 0 && num <= 100) {
            this.numbs[countTries] = num;
            countTries++;
            return true;
        }
        System.out.println("Ввёденное Вами число не соответсвует требованию, повторите ввод!");
        return false;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getNumb(int position) {
        return numbs[position];
    }

    public void clear() {
        Arrays.fill(numbs, 0, countTries, 0);
        countTries = 0;
    }
}
