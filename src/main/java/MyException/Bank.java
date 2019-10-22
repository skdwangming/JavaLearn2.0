package MyException;

public class Bank {
    //余额
    private double balence;

    //存钱
    public void pushMoney(double amount) {
        balence += amount;
    }

    //取钱
    public void pullMoney(double amount) throws LackMoneyException {
        if (amount <= balence) {
            balence -= amount;
        } else if (amount > balence) {
            double lackMoney = amount - balence;
            throw new LackMoneyException(lackMoney);
        }
    }
}
