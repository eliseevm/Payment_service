package cards.debitCards.bonusProgrammCards;

import cards.debitCards.DebitCard;

import java.util.List;

public class DebitCardSaveMoney extends DebitCard {

    private final double PERCENT_SIZE;
    Object object = new Object();


    private double sumPercent;

    public DebitCardSaveMoney(double percentSize) {
        this.PERCENT_SIZE = percentSize / 100;
        this.sumPercent = 0.0;
    }

    @Override
    public void topUp(double sum) {
        balance = balance + sum;
        sumPercent = sumPercent + sum * PERCENT_SIZE;
    }

    @Override
    public List<Double> getInfoAboutTotalMany() {
        return List.of(balance, 0.0, 0.0, 0.0, sumPercent);
    }
}
