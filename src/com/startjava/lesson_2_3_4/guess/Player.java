package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private String name;
    private int countTries = 0;
    private int len = 10;
    private int[] numbs = new int[len];

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
        return len;
    }

    public int[] getNumbs() {
        return Arrays.copyOf(numbs, (countTries == 0 ? 1 : countTries));
    }

    public void setNumb(int num) {
        if (num > 0 && num <= 100) {
            this.numbs[countTries] = num;
            countTries++;
        }
    }

    public void clear() {
        Arrays.fill(numbs, 0, (countTries), 0);
        countTries = 0;
    }
}
