package MyException;

public class LackMoneyException extends Exception {

    //取钱时缺少的钱
    private double amount;

    public LackMoneyException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
