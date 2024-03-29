import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    private Player player1;
    private Player player2;
    private int targetNum;
    private Random random = new Random();
    private Scanner scan = new Scanner(System.in);

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        targetNum = random.nextInt(100) + 1;

        System.out.println(targetNum);

        do {
            enterNum(player1);
            if (isGuessed(player1)) {
                return;
            }

            enterNum(player2);
            if (isGuessed(player2)) {
                return;
            }
        } while (player1.getNum() != targetNum || player2.getNum() != targetNum);
    }

    private void enterNum(Player player) {
        do {
            System.out.print(player.getName() + ", введи число из полуинтервала (0, 100]: ");
            player.setNum(scan.nextInt());
        } while (player.getNum() <= 0 || player.getNum() > 100);
    }

    private boolean isGuessed(Player player) {
        int playerNum = player.getNum();
        if (playerNum == targetNum) {
            System.out.println(player.getName() + " отгадал загаданное число: " + targetNum);
            return true;
        }
        if (playerNum > targetNum) {
            System.out.println("Число " + playerNum + " больше того, что загадал компьютер");
        } else {
            System.out.println("Число " + playerNum + " меньше того, что загадал компьютер");
        }
        return false;
    }
}
