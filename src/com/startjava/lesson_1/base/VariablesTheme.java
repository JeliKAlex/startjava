package com.startjava.lesson_1.base;

public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1.Вывод характеристик компьютера\n");

        byte typeSystem = 64;
        short capacitySsd = 512;
        int lengthFrame = 350;
        long weightFrame = 175;
        float cpuClockSpeed = 4.7f;
        double amountRam = 16.0;
        boolean isGamingPc = true;
        char amountCoresCpu = '6';;
        System.out.println("Тип системы(разрядность) = " + typeSystem +
                "\nОбъем SSD = " + capacitySsd +
                "\nДлина корпуса = " + lengthFrame +
                "\nШирина корпуса = " + weightFrame +
                "\nТактовая частота процессора = " + cpuClockSpeed +
                "\nОбъем оперативной памяти = " + amountRam +
                "\nЭто игровой пк? " + isGamingPc +
                "\nКоличество ядер процессора = " + amountCoresCpu);

        System.out.println("\n2.Расчет стоимости товара со скидкой\n");

        int costPen = 100;
        int costBook = 200;
        int discount = 11;
        int costGoodsWihoutDiscount = costPen + costBook;
        int sumDiscount = costGoodsWihoutDiscount / 100 * discount;
        int discountCost = costGoodsWihoutDiscount - sumDiscount;
        System.out.println("Общая стоимость товаров без скидки = " + costGoodsWihoutDiscount + 
                "\nСумма скидки = " + sumDiscount +
                "\nОбщая стоимость товаров со скидкой = " + discountCost);

        System.out.println("\n3.Вывод слова JAVA\n");

        System.out.println("   J    a  v     v  a\n" +
                "   J   a a  v   v  a a\n" +
                "J  J  aaaaa  V V  aaaaa\n" +
                " JJ  a     a  V  a     a");

        System.out.println("\n4.Вывод min и max значений целых числовых типов\n");

        byte byteNum = Byte.MAX_VALUE;
        short shortNum = Short.MAX_VALUE;
        int intNum = Integer.MAX_VALUE;
        long longNum = Long.MAX_VALUE;
        System.out.println("Тип данных byte " + byteNum + " " + ++byteNum + " " + --byteNum);
        System.out.println("Тип данных short " + shortNum + " " + ++shortNum + " " + --shortNum);
        System.out.println("Тип данных int " + intNum + " " + ++intNum + " " + --intNum);
        System.out.println("Тип данных long " + longNum + " " + ++longNum + " " + --longNum);

        System.out.println("\n5.Перестановка значений переменных\n");

        int num2 = 2;
        int num5 = 5;

        System.out.println("С помощью третьей переменной\nnum2 = " + num2 +
                " и " + "num5 = " + num5);
        int temp = num2;
        num2 = num5;
        num5 = temp;
        System.out.println("num2 = " + num2 + " и " + "num5 = " + num5);

        System.out.println("С помощью третьей переменной\nnum2 = " + num2 +
                " и " + "num5 = " + num5);
        num2 *= num5;
        num5 = num2 / num5;
        num2 /= num5;
        System.out.println("num2 = " + num2 + " и " + "num5 = " + num5);

        System.out.println("С помощью побитовой операции ^\nnum2 = " + num2 +
                " и " + "num5 = " + num5);
        num2 ^= num5;
        num5 ^= num2;
        num2 ^= num5;
        System.out.println("num2 = " + num2 + " и " + "num5 = " + num5);

        System.out.println("\n6.Вывод символов и их кодов\n");

        char dollar = '$';
        char asterisk = '*';
        char atSign = '@';
        char verticalBar = '|';
        char tilde = '~';
        System.out.println((int) dollar + " = " + dollar + "\n" +
                (int) asterisk + " = " + asterisk + "\n" +
                (int) atSign + " = " + atSign + "\n" +
                (int) verticalBar + " = " + verticalBar + "\n" +
                (int) tilde + " = " + tilde);

        System.out.println("\n7.Вывод в консоль ASCII-арт Дюка\n");

        char slash = '/';
        char backSlash = '\\';
        char underscore = '_';
        char leftParenthesis = '(';
        char rightParenthesis = ')';
        System.out.println("    " + slash + backSlash + "\n" +
                "   " + slash + "  " + backSlash + "\n" +
                "  " + slash + underscore + leftParenthesis + " " + rightParenthesis + backSlash + "\n" +
                " " + slash + "      " + backSlash + "\n" +
                slash + underscore + underscore + underscore + underscore + slash + backSlash +
                underscore + underscore + backSlash);

        System.out.println("\n8.Вывод количества сотен, десятков и единиц числа\n");

        int originalNum = 123;
        int hundreds = originalNum / 100;
        int tens = originalNum % 100 / 10;
        int ones = originalNum % 10;
        int sum = hundreds + tens + ones;
        int multiplication = hundreds * tens * ones;
        System.out.println("Число " + originalNum + " содержит :" +
                "\n   сотен - " + hundreds +
                "\n   десятков - " + tens +
                "\n   единиц - " + ones +
                "\nСумма его цифр = " + sum +
                "\nПроизведение = " + multiplication);

        System.out.println("\n9.Вывод времени\n");

        int originalSecond = 86399;
        int hours = originalSecond / 3600;
        int minuts = (originalSecond % 3600) / 60;
        int seconds = originalSecond % 60;
        System.out.println(hours + ":" + minuts + ":" + seconds);
    }
}