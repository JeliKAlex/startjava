public class GuessNumber{
    public static void main(String[] args){
        int computerNum = 55;
        int playerNum = 50;
        boolean isWinner = false;

        if (computerNum > 0 && computerNum <= 100) {
            System.out.println();
            while (!isWinner) {
                if (computerNum == playerNum) {
                    isWinner = true;
                    System.out.println("\nВы победили!");
                } else {
                    if (playerNum < computerNum) {
                        System.out.println("Число " + playerNum + " меньше того, что загадал компьютер..");
                        playerNum++;
                    } else {
                        System.out.println("Число " + playerNum + " больше того, что загадал компьютер..");
                        playerNum--;
                    }
                }
            }
        } else {
            System.out.println("\nКомпьютер должен загадать целое число в полуинтервале (0, 100].\nЧисло " +
                    computerNum + " не подходит!");
        }
    }
}