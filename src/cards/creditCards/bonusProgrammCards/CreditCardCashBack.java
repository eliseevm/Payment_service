package cards.creditCards.bonusProgrammCards;

import cards.creditCards.CreditCard;

import java.util.List;

public class CreditCardCashBack extends CreditCard {
    private final double CASH_BACK_SIZE;

    private double sumCashBack;

    public CreditCardCashBack(double cashBackSize, double limit) {
        super(limit);
        this.CASH_BACK_SIZE = cashBackSize / 100;
        this.sumCashBack = 0.0;
    }

    @Override
    public List<Double> getInfoAboutTotalMany() {
        return List.of(balance, currentLimit, 0.0, sumCashBack);
    }

    @Override
    public Boolean pay(double sum) {
        Boolean payResult = true;
        if (sum < balance) {
            balance = balance - sum;
            sumCashBack = sumCashBack + sum * CASH_BACK_SIZE;
        } else if (sum == balance) {
            balance = 0.0;
            sumCashBack = sumCashBack + sum * CASH_BACK_SIZE;
        } else if (sum > balance) {
            balance = 0.0;
            currentLimit = currentLimit - (sum - balance);
            sumCashBack = sumCashBack + sum * CASH_BACK_SIZE;
        } else if (sum > (currentLimit + balance)) {
            payResult = false;
        }
        return payResult;
    }
}
