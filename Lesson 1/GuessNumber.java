public class GuessNumber {
    public static void main(String[] args) {
        int computerNum = 55;
        int playerNum = 60;

        if (computerNum > 0 && computerNum <= 100) {
            System.out.println();
            while (computerNum != playerNum) {
                if (playerNum < computerNum) {
                    System.out.println("Число " + playerNum + " меньше того, что загадал компьютер..");
                    playerNum++;
                } else {
                    System.out.println("Число " + playerNum + " больше того, что загадал компьютер..");
                    playerNum--;
                }
            }
        } else {
            System.out.println("\nКомпьютер должен загадать целое число в полуинтервале (0, 100].\nЧисло " +
                    computerNum + " не подходит!");
        }
        System.out.println("\nВы победили!");
    }
}