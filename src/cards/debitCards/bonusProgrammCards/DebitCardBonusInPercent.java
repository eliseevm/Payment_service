package cards.debitCards.bonusProgrammCards;

import cards.debitCards.DebitCard;

import java.util.List;

public class DebitCardBonusInPercent extends DebitCard {

    private final double BONUS_SIZE;
    private double sumBonus;

    public DebitCardBonusInPercent(double bonus) {
        this.BONUS_SIZE = bonus / 100;
        this.sumBonus = 0.0;
    }

    @Override
    public List<Double> getInfoAboutTotalMany() {
        return List.of(balance, 0.0, sumBonus);
    }

    @Override
    public Boolean pay(double sum) {
        Boolean payResult = true;
        if (sum <= balance) {
            balance = balance - sum;
            sumBonus = sumBonus + sum * BONUS_SIZE;
        } else {
            payResult = false;
        }
        return payResult;
    }
}
