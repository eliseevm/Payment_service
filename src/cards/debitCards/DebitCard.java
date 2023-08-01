package cards.debitCards;

import cards.BankCard;

import java.util.List;

public class DebitCard extends BankCard {

    public DebitCard() {
        super(0.0);
    }

    @Override
    public void topUp(double sum) {
        balance = balance + sum;
    }

    @Override
    public Boolean pay(double sum) {
        Boolean payResult = true;
        if (sum <= balance) {
            balance = balance - sum;
        } else {
            payResult = false;
        }
        return payResult;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public List<Double> getInfoAboutTotalMany() {
        return null;
    }
}
