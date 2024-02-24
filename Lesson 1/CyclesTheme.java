public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("\n1.Подсчет суммы четных и нечетных чисел\n");

        int startNum = -10;
        int evenSum = 0;
        int unevenSum = 0;
        int count = startNum;
        do {
            if (count % 2 == 0) {
                evenSum += count;
            } else {
                unevenSum += count;
            }
            count++;
        } while (count <= 21);
        System.out.println("В отрезке [" + startNum + ", " + --count + "]" +
                " сумма четных чисел = " + evenSum + ",  а нечетных = " + unevenSum);

        System.out.println("\n2.Вывод чисел в порядке убывания\n");

        int num = 10;
        int num1 = 5;
        int num2 = -1;
        int maxNum = 0;
        if (num > num1 && num > num2) {
            maxNum = num;
        } else if (num1 > num && num1 > num2) {
            maxNum = num1;
        } else if (num2 > num && num2 > num1) {
            maxNum = num2;
        }
        int minNum = 0;
        if (num < num1 && num < num2) {
            minNum = num;
        } else if (num1 < num && num1 < num2) {
            minNum = num1;
        } else if (num2 < num1 && num2 < num) {
            minNum = num2;
        }
        for (int i = maxNum - 1; i > minNum; i--) {
            System.out.print(i + " ");
        }


        System.out.println("\n\n3.Вывод реверсивного числа и суммы его цифр\n");

        num = 1234;
        int reversNum = 0;
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            reversNum = reversNum * 10 + num % 10;
            num /= 10;
        }
        System.out.println("Исходное число в обратном порядке = " + reversNum +
                "\nСумма цифр исходного числа = " + sum);


        System.out.println("\n4.Вывод чисел в несколько строк\n");

        count = 0;
        for (int  i = 1; i < 24; i++) {
            if (i % 2 == 1) {
                System.out.printf("%2d ",i);
                count++;
            }
            if (count % 5 == 0) {
                System.out.println();
            }
        }
        if (count % 5 != 0) {
            while (count % 5 != 0) {
                System.out.printf("%2d ",0);
                count++;
            }
        }


        System.out.println("\n\n5.Проверка количества двоек числа на четность/нечетность\n");

        num = 3242592;
        int countTwos = 0;
        count = num;
        int temp = 0;
        while (count != 0) {
            temp = count % 10;
            if (temp == 2) {
                countTwos++;
            }
            count /= 10;
        }
        String parity = "";
        if (countTwos % 2 == 0) {
            parity = " четное";
        } else {
            parity = " нечетное";
        }
        System.out.println("В " + num + parity + " количество двоек - " + countTwos);

        System.out.println("\n6.Отображение геометрических фигур\n");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        int countStrings = 5;
        while (countStrings > 0) {
            int countSymbols = 1;
            while (countSymbols <= countStrings) {
            System.out.print("#");
            countSymbols++;
            }
        System.out.println();
        countStrings--;
        }

        countStrings = 1;
        int heightTriangle = 3;
        int weightString = 1;
        int increment = 1;
        do {
            int countSymbols = 0;
            do {
                System.out.print("$");
            } while (++countSymbols < weightString);
            System.out.println();
            if (weightString == heightTriangle) {
                increment = -1;
            }
            weightString += increment;
        } while (++countStrings <= 5);

        System.out.println("\n7.Отображение ASCII-символов\n");

        System.out.printf("%-10s%-12s%-11s%n","DECIMAL","CHARACTER","DESCRIPTION");
        for (int i = 15; i < 123; i++) {
            if (i % 2 == 1 && i < 48) {
                System.out.printf("%2s%-12d%-13c%-50s%n"," ",i,(char) i,
                        Character.getName((char) i));
            }
            if (i % 2 == 0 && i > 96 && i < 123) {
                System.out.printf("%2s%-12d%-13c%-50s%n"," ",i,(char) i,
                        Character.getName((char) i));
            }
        }

        System.out.println("\n8.Проверка, является ли число палиндромом\n");

        num = 1234321;
        reversNum = 0;
        count = num;
        while (count != 0) {
            reversNum = reversNum * 10 + count % 10;
            count /= 10;
        }

        System.out.println("Число " + num + ((num == reversNum) ?
                " является" : " не является") + " палиндромом");

        System.out.println("\n9.Проверка, является ли число счастливым\n");

        num = 914851;
        startNum = num / 1000;
        int endNum = num % 1000;
        int startSum = startNum / 100 + startNum % 100 / 10 + startNum % 10;
        int endSum = endNum / 100 + endNum % 100 / 10 + endNum % 10;
        System.out.println("Число " + num + ((startSum == endSum) ?
                " является" : " не является") + " счастливым\n" + "Сумма цифр " +
                startNum + " = " + startSum + ", а сумма " + endNum + " = " + endSum);

        System.out.println("\n10.Отображение таблицы умножения Пифагора\n");

        for (int i = 1; i < 10; i++) {
            if (i == 2) {
                System.out.println("----------------------------");
            }
            for (int j = 1; j < 10; j++) {
                if (j == 2) {
                    System.out.print("| ");
                }
                if (i * j == 1) {
                    System.out.print("   ");
                    continue;
                }
                System.out.printf("%2d ",i * j);

            }
            System.out.println();
        }
    }
}