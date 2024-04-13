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
        print(reversedNumbs, len);

        for (int i = 0; i <= len / 2; i++) {
            int temp = reversedNumbs[i];
            reversedNumbs[i] = reversedNumbs[--len];
            reversedNumbs[len] = temp;
        }

        System.out.print("\nПосле реверса: [");
        print(reversedNumbs, reversedNumbs.length);
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
        print(randomNumbs, len);

        float averageNumb = randomNumbs[len / 2];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (randomNumbs[i] > averageNumb) {
                randomNumbs[i] = 0;
                count++;
            }
        }

        System.out.println("\nИзмененный массив:");
        print(randomNumbs, len);
        System.out.println("\nКоличество обнуленных ячеек: " + count);
    }

    private static void outputLadder() {
        System.out.println("\n4. Вывод алфавита лесенкой\n");

        int len = 26;
        char[] alphabet = new char[len];
        for (int i = 0; i < len; i++) {
            alphabet[i] = (char) ('A' + i);
        }

        int countStrings = len;
        int countSymbols = 1;
        while (countStrings > 0) {
            for (int i = 0; i < countSymbols; i++) {
                System.out.print(alphabet[len - 1 - i]);
            }
            System.out.println();
            countStrings--;
            countSymbols++;
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
                "-------",
                "|     |",
                "|     O",
                "|    /|\\",
                "|    / \\"
        };
        int lenGallows = gallows.length;
        String[] guessedWords = {"СЛОВО", "КОШКА", "МАШИНА", "МОЛОКО", "КОМПЬЮТЕР"};
        String guessedWord = guessedWords[(int) (Math.random() * guessedWords.length)];
        StringBuilder maskWord = new StringBuilder("_".repeat(guessedWord.length()));
        int countTries = lenGallows - 1;
        Scanner scan = new Scanner(System.in);
        char inputLetter;
        boolean isGuessedLetter;
        StringBuilder fallLetters = new StringBuilder();

        do {
            do {
                isGuessedLetter = false;
                print(maskWord);
                System.out.println("Ошибочные буквы: " + fallLetters);
                System.out.print("Количество попыток: " + countTries + "\nВведите букву(от А до Я): ");
                inputLetter = scan.nextLine().toUpperCase().charAt(0);
                System.out.println();
            } while (inputLetter < 'А' || inputLetter > 'Я');

            for (int i = 0; i < guessedWord.length(); i++) {
                if (inputLetter == guessedWord.charAt(i)) {
                    if (maskWord.charAt(i) != inputLetter) {
                        maskWord.setCharAt(i, inputLetter);
                        boolean hasAddTry = countTries < lenGallows - 1 &&
                                maskWord.indexOf(String.valueOf(inputLetter)) == i;
                        if (hasAddTry) {
                            countTries++;
                        }
                    }
                    isGuessedLetter = true;
                }
            }

            boolean isFall = !isGuessedLetter &&
                    !fallLetters.toString().contains(String.valueOf(inputLetter));
            if (isFall) {
                countTries--;
                fallLetters.append(inputLetter).append(" ");
            }

            if (guessedWord.contentEquals(maskWord)) {
                System.out.println("\nТы отгадал слово: " + guessedWord);
                System.out.println("Осталось попыток: " + countTries);
                return;
            }
            if ((lenGallows - 1 - countTries) > 0) {
                print(gallows, countTries);
            }
            if (countTries == 0) {
                System.out.println("\nТы не отгадал слово: " + guessedWord);
                return;
            }
        } while (!guessedWord.contentEquals(maskWord));
    }

    private static void outputTypeWriter() throws InterruptedException {
        System.out.println("\n7. Вывод текста с эффектом пишущей машинки\n");
        String text1 = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки. \n" +
                "- James Gosling";
        String text = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его. \n" +
                "- Robert Martin";
        String cleanedText = text.replaceAll("[^\\p{L}\\s-+*/]", "");
        String[] cleanedWords = cleanedText.split(" ");
        int wordMinLength = cleanedWords[0].length();
        int wordMaxLength = 0;
        int indexStart = 0;
        int indexEnd = 0;
        
        for (int i = 0; i < cleanedWords.length; i++) {
            int lenWord = cleanedWords[i].length();

            if (lenWord > wordMaxLength && !cleanedWords[i].equals("-")) {
                wordMaxLength = lenWord;
                indexEnd = i;
            } else if (lenWord < wordMinLength && !cleanedWords[i].equals("-")) {
                wordMinLength = lenWord;
                indexStart = i;
            }
        }

        if (indexStart > indexEnd) {
            int temp = indexStart;
            indexStart = indexEnd;
            indexEnd = temp;
        }

        String[] words = text.split(" ");
        String[] wordsCopy = new String[cleanedWords.length];
        for (int i = 0; i < wordsCopy.length; i++) {
            if (i >= indexStart && i <= indexEnd) {
                wordsCopy[i] = words[i].toUpperCase();
            } else {
                wordsCopy[i] = words[i];
            }
        }

        for (String s : wordsCopy) {
            for (int i = 0; i < s.length(); i++) {
                System.out.print(s.charAt(i));
                Thread.sleep(100);
            }
            System.out.print(" ");
        }
    }

    private static void print(int[] reversedNumbs, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(reversedNumbs[i] + (i == len - 1 ? "]" : ", "));
        }
    }

    private static void print(float[] randomNumbs, int len) {
        for (int i = 0; i < len; i++) {
            if (i == 8) {
                System.out.println();
            }
            System.out.printf("%6.3f ", randomNumbs[i]);
        }
    }

    private static void print(String[] gallows, int countTry) {
        for (int i = 1; i < gallows.length - countTry; i++) {
            System.out.println(gallows[i]);
        }
        System.out.println();
    }

    private static void print(StringBuilder maskWord) {
        for (int i = 0; i < maskWord.length(); i++) {
            System.out.print(maskWord.charAt(i) + " ");
        }
        System.out.println();
    }
}