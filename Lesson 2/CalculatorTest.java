import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculatorOne = new Calculator();
        Scanner scan = new Scanner(System.in);
        String answer;

        do {
            System.out.print("\nВведите первое число: ");
            calculatorOne.setA(scan.nextInt());
            System.out.print("Введите знак математической операции: ");
            calculatorOne.setOperation(scan.next().charAt(0));
            System.out.print("Введите второе число: ");
            calculatorOne.setB(scan.nextInt());

            System.out.println("Ответ: " + calculatorOne.calculate());

            do {
                System.out.println("\nХотите продолжить вычисления? [yes/no]: ");
                answer = scan.next();
            } while (!answer.equals("yes") && !answer.equals("no"));
        } while (answer.equals("yes"));
    }
}
