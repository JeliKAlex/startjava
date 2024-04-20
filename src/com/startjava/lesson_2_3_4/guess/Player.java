package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private String name;
    private int countTries;
    private int capacity = 10;
    private int[] numbs = new int[capacity];

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCountTries() {
        return countTries;
    }

    public int getLen() {
        return capacity;
    }

    public int[] getNumbs() {
        return Arrays.copyOf(numbs, (countTries == 0 ? 1 : countTries));
    }

    public void addNumb(int num) {
        if (num > 0 && num <= 100) {
            this.numbs[countTries] = num;
            countTries++;
        }
    }

    public int getNumb(int position) {
        return numbs[position];
    }

    public void clear() {
        Arrays.fill(numbs, 0, countTries, 0);
        countTries = 0;
    }
}
