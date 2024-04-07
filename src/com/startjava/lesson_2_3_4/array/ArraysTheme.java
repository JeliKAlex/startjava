package com.startjava.lesson_2_3_4.array;

import java.util.Scanner;

public class ArraysTheme {
    public static void main(String[] args) throws InterruptedException {
        ReverseArray();
        CalculateFactorial();
        DeleteElement();
        OutputLadder();
        FillRandomNumbs();
        StartGameGallows();
        OutputTypeWriter();
    }

    private static void ReverseArray() {
        System.out.println("1. Реверс значений массива\n");

        int[] numbers = {1, 7, 4, 5, 2, 6, 3};
        System.out.print("   До реверса: [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + (i == numbers.length - 1 ? "]" : ", "));
        }

        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }

        System.out.print("\nПосле реверса: [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + (i == numbers.length - 1 ? "]" : ", "));
        }
    }

    private static void CalculateFactorial() {
        System.out.println("\n\n2. Вычисление факториала\n");

        int[] numbers = new int[10];
        int factorial = 1;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
            if (i > 0 && i < 9) {
                factorial *= numbers[i];
            }
        }

        for (int i = 1; i < numbers.length - 1; i++) {
            System.out.print(numbers[i] + (i == numbers.length - 2 ? " = " : " * "));
        }
        System.out.print(factorial);
    }

    private static void DeleteElement() {
        System.out.println("\n\n3. Удаление элемента массива\n");

        float[] numbers = new float[15];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (float) Math.random();
        }

        System.out.print("  Исходный массив: [");
        for (int i = 0; i < numbers.length; i++) {
            if (i == 8) {
                System.out.println();
            }
            System.out.printf("%6.3f%s", numbers[i], (i == numbers.length - 1 ? "]" : ", "));
        }

        float num = numbers[numbers.length / 2];
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > num) {
                numbers[i] = 0;
                count++;
            }
        }

        System.out.print("\nИзмененный массив: [");
        for (int i = 0; i < numbers.length; i++) {
            if (i == 8) {
                System.out.println();
            }
            System.out.printf("%6.3f%s", numbers[i], (i == numbers.length - 1 ? "]" : ", "));
        }
        System.out.println("\nКоличество обнуленных ячеек: " + count);
    }

    private static void OutputLadder() {
        System.out.println("\n4. Вывод алфавита лесенкой\n");

        char[] alphabet = new char[26];
        char ch = 'A';
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = ch++;
        }

        int countStrings = alphabet.length;
        int coutSimbols = 1;
        while (countStrings > 0) {
            for (int i = 0; i < coutSimbols; i++) {
                System.out.print(alphabet[alphabet.length - 1 - i]);
            }
            System.out.println();
            countStrings--;
            coutSimbols++;
        }
    }

    private static void FillRandomNumbs() {
        System.out.println("\n5. Заполнение массива уникальными числами\n");
        int[] numbers = new int[30];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 40 + 60);
            for (int j = 0; j < i; j++) {
                while (numbers[i] == numbers[j]) {
                    numbers[i] = (int) (Math.random() * 40 + 60);
                    j = 0;
                }
            }
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        System.out.print("Полученный массив: \n[");
        for (int i = 0; i < numbers.length; i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.println();
            }
            System.out.printf("%d%s", numbers[i], (i == numbers.length - 1 ? "]" : ", "));
        }
    }

    private static void StartGameGallows() {
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

    private static void OutputTypeWriter() throws InterruptedException {
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