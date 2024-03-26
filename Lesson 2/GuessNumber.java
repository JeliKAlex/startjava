import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int computerNum;
    private Random random = new Random();
    private Scanner scan = new Scanner(System.in);

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startGame() {
        computerNum = random.nextInt(100) + 1;

        System.out.println(computerNum);

        do {
            do {
                enterNum(player1);
            } while (!checkInterval(player1.getNum()));
            compareNum(player1);

            if (player1.getNum() != computerNum) {
                do {
                    enterNum(player2);
                } while (!checkInterval(player2.getNum()));
                compareNum(player2);
            }
        } while (computerNum != player1.getNum() && computerNum != player2.getNum());
    }

    private boolean checkInterval(int num) {
        if (num > 0 && num <= 100) {
            return true;
        } else {
            System.out.println("Введи число из полуинтервала (0, 100]");
            return false;
        }
    }

    private void compareNum(Player player) {
        if (player.getNum() == computerNum) {
            System.out.println(player.getName() + " отгадал загаданное число: " + computerNum);
        } else {
            if (player.getNum() > computerNum) {
                System.out.println("Число " + player.getNum() + " больше того, что загадал компьютер");
            } else {
                System.out.println("Число " + player.getNum() + " меньше того, что загадал компьютер");
            }
        }
    }

    private void enterNum(Player player) {
        System.out.print(player.getName() + ", отгадывай число: ");
        player.setNum(scan.nextInt());
    }
}
