package MyException;

import org.junit.jupiter.api.Test;

public class Start {
    @Test
    public void test1() throws LackMoneyException {
        Bank bank = new Bank();
        bank.pushMoney(100);
        try {
            bank.pullMoney(200);
        } catch (LackMoneyException m) {
            m.printStackTrace();
            System.out.println(m.getAmount());
        }
    }
}
