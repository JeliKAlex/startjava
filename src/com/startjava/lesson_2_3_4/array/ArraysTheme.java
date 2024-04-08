package com.startjava.lesson_2_3_4.array;

import java.util.Scanner;

public class ArraysTheme {
    public static void main(String[] args) throws InterruptedException {
        reverseArray();
        calculateFactorial();
        deleteElement();
        outputLadder();
        fillRandomNumbs();
        startGameGallows();
        outputTypeWriter();
    }

    private static void reverseArray() {
        System.out.println("1. Реверс значений массива\n");

        int[] reversNumbs = {1, 7, 4, 5, 2, 6, 3};
        System.out.print("   До реверса: [");
        outputTask1Array(reversNumbs);

        for (int i = 0; i < reversNumbs.length / 2; i++) {
            int temp = reversNumbs[i];
            reversNumbs[i] = reversNumbs[reversNumbs.length - 1 - i];
            reversNumbs[reversNumbs.length - 1 - i] = temp;
        }

        System.out.print("\nПосле реверса: [");
        outputTask1Array(reversNumbs);
    }

    private static void outputTask1Array(int[] reversNumbs) {
        for (int i = 0; i < reversNumbs.length; i++) {
            System.out.print(reversNumbs[i] + (i == reversNumbs.length - 1 ? "]" : ", "));
        }
    }

    private static void calculateFactorial() {
        System.out.println("\n\n2. Вычисление факториала\n");

        int len = 10;
        int[] factorialNumbs = new int[len];
        int factorial = 1;
        for (int i = 0; i < len; i++) {
            factorialNumbs[i] = i;
        }

        for (int i = 1; i < len - 1; i++) {
            factorial *= factorialNumbs[i];
            System.out.print(factorialNumbs[i] + (i == len - 2 ? " = " : " * "));
        }
        System.out.print(factorial);
    }

    private static void deleteElement() {
        System.out.println("\n\n3. Удаление элемента массива\n");

        int len = 15;
        float[] changeNumbs = new float[len];
        for (int i = 0; i < len; i++) {
            changeNumbs[i] = (float) Math.random();
        }

        System.out.println("Исходный массив:");
        outputTask3Array(changeNumbs);

        float averageNumb = changeNumbs[len / 2];
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (changeNumbs[i] > averageNumb) {
                changeNumbs[i] = 0;
                count++;
            }
        }

        System.out.println("\nИзмененный массив:");
        outputTask3Array(changeNumbs);
        System.out.println("\nКоличество обнуленных ячеек: " + count);
    }

    private static void outputTask3Array(float[] changeNumbs) {
        for (int i = 0; i < changeNumbs.length; i++) {
            if (i == 8) {
                System.out.println();
            }
            System.out.printf("%6.3f ", changeNumbs[i]);
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

    private static void fillRandomNumbs() {
        System.out.println("\n5. Заполнение массива уникальными числами\n");

        int len = 30;
        int[] randomNumbs = new int[len];

        for (int i = 0; i < len; i++) {
            int randomNumb = (int) (Math.random() * 40 + 60);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (randomNumbs[j] == randomNumb) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                randomNumbs[i] = randomNumb;
            } else {
                i--;
            }
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (randomNumbs[i] > randomNumbs[j]) {
                    int temp = randomNumbs[i];
                    randomNumbs[i] = randomNumbs[j];
                    randomNumbs[j] = temp;
                }
            }
        }

        System.out.print("Полученный массив:\n");
        for (int i = 0; i < len; i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
            System.out.printf("%3d", randomNumbs[i]);
        }
    }

    private static void startGameGallows() {
        System.out.println("\n\n6. Игра \"Виселица\"\n");

        String[] gallows = new String[6];
        gallows[5] = """
                |----|
                |    O
                |   /|\\
                |   / \\
                |
                """;
        gallows[4] = """
                |----|
                |    O
                |   /|\\
                |
                |
                """;
        gallows[3] = """
                |----|
                |
                |
                |
                |
                """;
        gallows[2] = """
                |--
                |
                |
                |
                |
                """;
        gallows[1] = """
                
                |
                |
                |
                |
                """;
        gallows[0] = """
                
                
                
                
                
                """;
        String[] hiddenWords = {"СЛОВО", "КОШКА", "МАШИНА", "МОЛОКО", "КОМПЬЮТЕР"};
        String hiddenWord = hiddenWords[(int) (Math.random()*hiddenWords.length)];
        StringBuilder maskWord = new StringBuilder();
        maskWord.append("_".repeat(hiddenWord.length()));
        int countTry = 5;
        Scanner scan = new Scanner(System.in);
        char inputLetter;
        boolean isGuessedLetter;
        StringBuilder fallLetters = new StringBuilder();

        do {
            do {
                isGuessedLetter = false;
                System.out.println(gallows[gallows.length - 1 - countTry]);
                System.out.println(maskWord);
                System.out.println("Ошибочные буквы: " + fallLetters);
                System.out.print("Количество попыток: " + countTry + "\nВводи букву(от А до Я): ");
                inputLetter = scan.nextLine().charAt(0);
            } while (inputLetter < (char) 1040 || inputLetter > (char) 1071);

            for (int i = 0; i < hiddenWord.length(); i++) {
                if (inputLetter == hiddenWord.charAt(i)) {
                    maskWord.setCharAt(i, inputLetter);
                    isGuessedLetter = true;
                    if (countTry < 5) {
                        countTry++;
                    }
                }
            }

            if (!isGuessedLetter && !fallLetters.toString().contains(String.valueOf(inputLetter))) {
                countTry--;
                fallLetters.append(inputLetter).append(" ");
            }

            if (hiddenWord.contentEquals(maskWord)) {
                System.out.println("\nТы отгдал слово: " + maskWord);
                System.out.println("Осталось попыток: " + countTry);
                if (countTry < 5) {
                    System.out.println(gallows[gallows.length - 1 - countTry]);
                }
                return;
            }
            if (countTry == 0) {
                System.out.println("\nТы не отгадала слово: " + hiddenWord);
                System.out.println(gallows[gallows.length - 1]);
                return;
            }
        } while (!hiddenWord.contentEquals(maskWord));
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
            if(words[i].length() > wordBigLength && !words[i].equals("--")) {
                wordBigLength = words[i].length();
                indexEnd = i;
            } else if (words[i].length() < wordSmallLength &&  !words[i].equals("--")) {
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