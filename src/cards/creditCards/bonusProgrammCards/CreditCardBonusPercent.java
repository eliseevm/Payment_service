package cards.creditCards.bonusProgrammCards;

import cards.creditCards.CreditCard;

import java.util.List;

public class CreditCardBonusPercent extends CreditCard {

    private final double BONUS_SIZE;
    private double sumBonus;

    public CreditCardBonusPercent(double bonus, double limit) {
        super(limit);
        this.BONUS_SIZE = bonus / 100;
        this.sumBonus = 0.0;
    }

    @Override
    public List<Double> getInfoAboutTotalMany() {
        return List.of(balance, currentLimit, sumBonus);
    }

    @Override
    public Boolean pay(double sum) {
        Boolean payResult = true;
        if (sum < balance) {
            balance = balance - sum;
            sumBonus = sumBonus + sum * BONUS_SIZE;
        } else if (sum == balance) {
            balance = 0.0;
            sumBonus = sumBonus + sum * BONUS_SIZE;
        } else if (sum > balance) {
            currentLimit = currentLimit - (sum - balance);
            balance = 0.0;
            sumBonus = sumBonus + sum * BONUS_SIZE;
        } else if (sum > (currentLimit + balance)) {
            payResult = false;
        }
        return payResult;
    }

}
