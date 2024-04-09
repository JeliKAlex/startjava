package com.startjava.lesson_2_3_4.array;

import java.util.Scanner;

public class ArraysTheme {
    public static void main(String[] args) throws InterruptedException {
        reverseArray();
        calculateFactorial();
        deleteElements();
        outputLadder();
        fillUniqueNumbs();
        startGameGallows();
        outputTypeWriter();
    }

    private static void reverseArray() {
        System.out.println("1. Реверс значений массива\n");

        int[] reversedNumbs = {1, 7, 4, 5, 2, 6, 3};
        int len = reversedNumbs.length;
        System.out.print("   До реверса: [");
        printTask1(reversedNumbs, len);

        for (int i = 0; i < len / 2; i++) {
            int temp = reversedNumbs[i];
            reversedNumbs[i] = reversedNumbs[len - 1 - i];
            reversedNumbs[len - 1 - i] = temp;
        }

        System.out.print("\nПосле реверса: [");
        printTask1(reversedNumbs, len);
    }

    private static void printTask1(int[] reversedNumbs, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(reversedNumbs[i] + (i == len - 1 ? "]" : ", "));
        }
    }

    private static void calculateFactorial() {
        System.out.println("\n\n2. Вычисление факториала\n");

        int len = 10;
        int[] multipliers = new int[len];
        for (int i = 0; i < len; i++) {
            multipliers[i] = i;
        }

        int factorial = 1;
        for (int i = 1; i < len - 1; i++) {
            factorial *= multipliers[i];
            System.out.print(multipliers[i] + (i == len - 2 ? " = " : " * "));
        }
        System.out.print(factorial);
    }

    private static void deleteElements() {
        System.out.println("\n\n3. Удаление элемента массива\n");

        int len = 15;
        float[] randomNumbs = new float[len];
        for (int i = 0; i < len; i++) {
            randomNumbs[i] = (float) Math.random();
        }

        System.out.println("Исходный массив:");
        printTask3(randomNumbs, len);

        float averageNumb = randomNumbs[len / 2];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (randomNumbs[i] > averageNumb) {
                randomNumbs[i] = 0;
                count++;
            }
        }

        System.out.println("\nИзмененный массив:");
        printTask3(randomNumbs, len);
        System.out.println("\nКоличество обнуленных ячеек: " + count);
    }

    private static void printTask3(float[] randomNumbs, int len) {
        for (int i = 0; i < len; i++) {
            if (i == 8) {
                System.out.println();
            }
            System.out.printf("%6.3f ", randomNumbs[i]);
        }
    }

    private static void outputLadder() {
        System.out.println("\n4. Вывод алфавита лесенкой\n");

        int len = 26;
        char[] alphabet = new char[len];
        for (int i = 0; i < len; i++) {
            alphabet[i] = (char) ('A' + i);
        }

        int countStrings = len;
        int coutSimbols = 1;
        while (countStrings > 0) {
            for (int i = 0; i < coutSimbols; i++) {
                System.out.print(alphabet[len - 1 - i]);
            }
            System.out.println();
            countStrings--;
            coutSimbols++;
        }
    }

    private static void fillUniqueNumbs() {
        System.out.println("\n5. Заполнение массива уникальными числами\n");

        int len = 30;
        int[] uniqueNumbs = new int[len];

        for (int i = 0; i < len; i++) {
            int randomNumb = (int) (Math.random() * 40 + 60);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (uniqueNumbs[j] == randomNumb) {
                    isUnique = false;
                    i--;
                    break;
                }
            }
            if (isUnique) {
                uniqueNumbs[i] = randomNumb;
            }
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (uniqueNumbs[i] > uniqueNumbs[j]) {
                    int temp = uniqueNumbs[i];
                    uniqueNumbs[i] = uniqueNumbs[j];
                    uniqueNumbs[j] = temp;
                }
            }
        }

        System.out.print("Полученный массив:\n");
        for (int i = 0; i < len; i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
            System.out.printf("%3d", uniqueNumbs[i]);
        }
    }

    private static void startGameGallows() {
        System.out.println("\n\n6. Игра \"Виселица\"\n");

        String[] gallows = {"",
                """
                
                |
                |
                |
                |
                """,
                """
                |--
                |
                |
                |
                |
                """,
                """
                |----|
                |
                |
                |
                |
                """,
                """
                |----|
                |    O
                |   /|\\
                |
                |
                """,
                """
                |----|
                |    O
                |   /|\\
                |   / \\
                |
                """};
        int lenGallows = gallows.length;
        String[] guessedWords = {"СЛОВО", "КОШКА", "МАШИНА", "МОЛОКО", "КОМПЬЮТЕР"};
        int lenWords = guessedWords.length;
        String guessedWord = guessedWords[(int) (Math.random() * lenWords)];
        StringBuilder maskWord = new StringBuilder();
        maskWord.append("_".repeat(guessedWord.length()));
        int countTry = lenGallows - 1;
        Scanner scan = new Scanner(System.in);
        char inputLetter;
        boolean isGuessedLetter;
        StringBuilder fallLetters = new StringBuilder();

        do {
            do {
                isGuessedLetter = false;
                if ((lenGallows - 1 - countTry) > 0) {
                    System.out.println(gallows[lenGallows - 1 - countTry]);
                }
                System.out.println(maskWord);
                System.out.println("Ошибочные буквы: " + fallLetters);
                System.out.print("Количество попыток: " + countTry + "\nВводи букву(от А до Я): ");
                inputLetter = scan.nextLine().charAt(0);
                System.out.println();
            } while (inputLetter < 'А' || inputLetter > 'Я');

            for (int i = 0; i < lenWords; i++) {
                if (inputLetter == guessedWord.charAt(i)) {
                    if (maskWord.charAt(i) != inputLetter) {
                        maskWord.setCharAt(i, inputLetter);
                        boolean hasAddTry = countTry < 5 &&
                                maskWord.indexOf(String.valueOf(inputLetter)) == i;
                        if (hasAddTry) {
                            countTry++;
                        }
                    }
                    isGuessedLetter = true;
                }
            }

            boolean isFall = !isGuessedLetter &&
                    !fallLetters.toString().contains(String.valueOf(inputLetter));
            if (isFall) {
                countTry--;
                fallLetters.append(inputLetter).append(" ");
            }

            if (guessedWord.contentEquals(maskWord)) {
                System.out.println("\nТы отгадал слово: " + maskWord);
                System.out.println("Осталось попыток: " + countTry);
                if (countTry < 5) {
                    System.out.println(gallows[lenGallows - 1 - countTry]);
                }
                return;
            }
            if (countTry == 0) {
                System.out.println("\nТы не отгадал слово: " + guessedWord);
                System.out.println(gallows[lenGallows - 1]);
                return;
            }
        } while (!guessedWord.contentEquals(maskWord));
    }

    private static void outputTypeWriter() throws InterruptedException {
        System.out.println("\n7. Вывод текста с эффектом пишущей машинки\n");
        String text1 = "Java -- это C++, из которого убрали все пистолеты, ножи и дубинки. \n" +
                "-- James Gosling";
        String text2 = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его. \n" +
                "-- Robert Martin";
        String[] words = text2.split(" ");
        String[] wordsCopy = new String[words.length];
        int wordSmallLength = words[0].length();
        int wordBigLength = 0;
        int indexStart = 0;
        int indexEnd = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > wordBigLength && !words[i].equals("--")) {
                wordBigLength = words[i].length();
                indexEnd = i;
            } else if (words[i].length() < wordSmallLength && !words[i].equals("--")) {
                wordSmallLength = words[i].length();
                indexStart = i;
            }
        }

        if (indexStart > indexEnd) {
            int temp = indexStart;
            indexStart = indexEnd;
            indexEnd = temp;
        }

        for (int i = 0; i < wordsCopy.length; i++) {
            if (i >= indexStart && i <= indexEnd) {
                wordsCopy[i] = words[i].toUpperCase();
            } else {
                wordsCopy[i] = words[i];
            }
        }

        for (String s : wordsCopy) {
            for (int j = 0; j < s.length(); j++) {
                System.out.print(s.charAt(j));
                Thread.sleep(200);
            }
            System.out.print(" ");
        }
    }
}