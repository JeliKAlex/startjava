public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("\n1.Перевод псевдокода на язык Java\n");

        boolean isMale = true;
        int age = 21;
        float height = 1.83f;
        if (!isMale) {
            System.out.println("Женский пол");
        } else {
            System.out.println("Мужской пол");
        }

        if (age > 18) {
            System.out.println("Вы совершеннолетний!");
        } else {
            System.out.println("Вы не являетесь совершеннолетним!");
        }

        if (height < 1.8) {
            System.out.println("Этот мир слишком большой для Вас!");
        } else {
            System.out.println("Как погодка на такой высоте?");
        }

        char firstNameLetter = "Александр".charAt(0);
        if (firstNameLetter == 'M') {
            System.out.println("Max?");
        } else if (firstNameLetter == 'I') {
            System.out.println("Iгорь?");
        } else {
            System.out.println("Я сдаюсь..");
        }

        System.out.println("\n2.Поиск большего числа\n");

        int num1 = 55;
        int num2 = 55;
        if (num1 > num2) {
            System.out.println("Число " + num1 + " больше чем " + num2);
        } else if (num2 > num1) {
            System.out.println("Число " + num2 + " больше чем " + num1);
        } else {
            System.out.println("Число " + num2 + " и " + num1 + " равны!");
        }

        System.out.println("\n3.Проверка числа\n");

        int num = -229;
        if (num == 0) {
            System.out.println("Число является нулём!");
        } else {
            String parity;
            String sign;
            if (num % 2 == 0) {
                parity = "четным";
            } else {
                parity = "нечетным";
            }
            if (num > 0) {
                sign = "положительным";
            } else {
                sign = "отрицательным";
            }
            System.out.println(num + " является " + sign + " и " + parity);
        }

        System.out.println("\n4.Поиск одинаковых цифр в числах\n");

        boolean hasEqualOnes = num1 % 10 == num2 % 10;
        boolean hasEqualTens = num1 % 100 / 10 == num2 % 100 / 10;
        boolean hasEqualHundreds = num1 / 100 == num2 / 100;
        if (!hasEqualOnes && !hasEqualTens && !hasEqualHundreds) {
            System.out.println("Числа " + num1 + " и " + num2 +" не имеют равных цифр");
        } else {
            String identicalDigits = "";
            String ranks = "";
            if (hasEqualOnes) {
                identicalDigits += num1 % 10;
                ranks += 1;
            }
            if (hasEqualTens) {
                identicalDigits += " " + num1 % 100 / 10;
                ranks += " " + 2;
            }
            if (hasEqualHundreds) {
                identicalDigits += " " + num1 / 100;
                ranks += " " + 3;
            }
            System.out.println("Исходные числа " + num1 + " и " + num2 +
                    "\nОдинаковые цифры " + identicalDigits + 
                    "\nНомера разрядов " + ranks);
        }


        System.out.println("\n5.Определение символа по его коду\n");

        char symbol = '\u0057';
        String nameSymbol;
        if (symbol >= 'A' && symbol <= 'Z') {
            nameSymbol = "большой буквой";
        } else if (symbol >= 'a' && symbol <= 'z') {
            nameSymbol = "маленькой буквой";
        } else if (symbol >= '0' && symbol <= '9') {
            nameSymbol = "цифрой";
        } else {
            nameSymbol = "не буквой и не цифрой";
        }
        System.out.println("Символ " + symbol + " является " + nameSymbol);

        System.out.println("\n6.Подсчет суммы вклада и начисленных банком %\n");

        int deposit = 301_000;
        int percent;
        if (deposit < 100_000) {
            percent = 5;
        } else if (deposit >= 100_000 && deposit <=300_000) {
            percent = 7;
        } else {
            percent = 10;
        }
        int profit = deposit / 100 * percent;
        int totalSum = deposit + profit;
        System.out.println("Сумма вклада: " + deposit +
                "\nСумма начисленного %: " + profit + 
                "\nИтоговая сумма: " + totalSum);

        System.out.println("\n7.Определение оценки по предметам\n");

        float percentHistory = 59f;
        float gradeHistory = 2;
        if (percentHistory > 91) {
            gradeHistory = 5;
        } else if (percentHistory > 73) {
            gradeHistory = 4;
        } else if (percentHistory > 60) {
            gradeHistory = 3;
        }
        float percentProgramming = 92f;
        float gradeProgramming = 2;
        if (percentProgramming > 91) {
            gradeProgramming = 5;
        } else if (percentProgramming > 73) {
            gradeProgramming = 4;
        } else if (percentProgramming > 60) {
            gradeProgramming = 3;
        }
        float averagePercent = (percentHistory + percentProgramming) / 2;
        float averageGrade = (gradeHistory + gradeProgramming) / 2;
        System.out.println("Оценка по истории: " + gradeHistory +
                "\nОценка по программированию: " + gradeProgramming +
                "\nСредний балл оценок по предметам: " + averageGrade +
                "\nСредний % по предметам: " + averagePercent);

        System.out.println("\n8.Расчет годовой прибыли\n");

        int income = 13_000;
        int rentPremises = 5_000;
        int costPrice = 9_000;
        int annualProfit = (income - rentPremises - costPrice) * 12;
        String mathSymbol = "";
        if (annualProfit > 0) {
            mathSymbol = "+";
        }
        System.out.println("Прибыль за год: " + mathSymbol + annualProfit + " руб.");
    }
}