import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int targetNum;
    private Random random = new Random();
    private Scanner scan = new Scanner(System.in);
    private boolean isСontinue;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        targetNum = random.nextInt(100) + 1;
        isСontinue = true;

        System.out.println(targetNum);

        do {
            enterNum(player1);
            isСontinue = isGuessed(player1);

            if (isСontinue) {
                enterNum(player2);
                isСontinue = isGuessed(player2);
            }
        } while (isСontinue);
    }

    private void enterNum(Player player) {
        do {
            System.out.print(player.getName() + ", введи число из полуинтервала (0, 100]: ");
            player.setNum(scan.nextInt());
        } while (player.getNum() <= 0 || player.getNum() > 100);
    }

    private boolean isGuessed(Player player) {
        if (player.getNum() == targetNum) {
            System.out.println(player.getName() + " отгадал загаданное число: " + targetNum);
            return false;
        } else {
            if (player.getNum() > targetNum) {
                System.out.println("Число " + player.getNum() + " больше того, что загадал компьютер");
            } else {
                System.out.println("Число " + player.getNum() + " меньше того, что загадал компьютер");
            }
        }
        return true;
    }
}
