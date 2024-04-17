package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

public class Player {
    private String name;
    private int countTries = 10;
    private int[] numbs = new int[countTries];

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCountTries() {
        return countTries;
    }

    public void setCountTries(int countTries) {
        this.countTries = countTries;
    }

    public int[] getNumbs() {
        return numbs;
    }

    public void setNumbs(int num, int i) {
        if (num > 0 && num <= 100) {
            this.numbs[i] = num;
        }
    }

    public void printArray() {
        int[] copyArray = Arrays.copyOf(numbs, numbs.length - countTries);
        System.out.print("\nЧисла игрока " + name + ":\n");
        for (int i = 0; i < copyArray.length; i++) {
            if (copyArray.length / 2 == i) {
                System.out.println();
            }
            System.out.print(copyArray[i] + " ");
        }
        System.out.println();
    }

    public void resetResults() {
        Arrays.fill(numbs, 0, (numbs.length - countTries), 0);
        countTries = 10;
    }
}
