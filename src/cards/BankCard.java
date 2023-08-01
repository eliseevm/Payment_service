package cards;

import java.util.List;

public abstract class BankCard {
    protected double balance;

    protected BankCard(double balance) {
        this.balance = balance;
    }

    public abstract void topUp(double sum);

    public abstract Boolean pay(double sum);

    public abstract List<Double> getInfoAboutTotalMany();

    public double getBalance() {
        return balance;
    }
}
