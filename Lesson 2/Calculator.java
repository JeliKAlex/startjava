public class Calculator {

    private int firstNum;
    private int secondNum;
    private char operation;

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public int calculate() {
        switch (operation) {
            case '+' :
                return firstNum + secondNum;
            case '-' :
                return firstNum - secondNum;
            case '*' :
                return firstNum * secondNum;
            case '/' :
                return firstNum / secondNum;
            case '%' :
                return firstNum % secondNum;
            case '^' :
                int result = 1;
                for (int i = 0; i < secondNum; i++) {
                    result *= firstNum;
                }
                return result;
            default :
                System.out.println("\nДанная математическая операция не поддерживается!\n" + 
                        "По умолчанию выполняется сложение");
                return firstNum + secondNum;
        }
    }
}
