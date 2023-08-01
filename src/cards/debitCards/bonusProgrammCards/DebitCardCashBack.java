package cards.debitCards.bonusProgrammCards;

import cards.debitCards.DebitCard;

import java.util.List;

public class DebitCardCashBack extends DebitCard {
    private final double CASH_BACK_SIZE;

    private double sumCashBack;

    public DebitCardCashBack(double cashBackSize) {
        this.CASH_BACK_SIZE = cashBackSize / 100;
        this.sumCashBack = 0.0;
    }

    @Override
    public List<Double> getInfoAboutTotalMany() {
        return List.of(balance, 0.0, 0.0, sumCashBack);
    }

    @Override
    public Boolean pay(double sum) {
        Boolean payResult = true;
        if (sum <= balance) {
            balance = balance - sum;
            if (sum > 5000.0) {
                sumCashBack = sumCashBack + sum * CASH_BACK_SIZE;
            }
        } else {
            payResult = false;
        }
        return payResult;
    }
}
