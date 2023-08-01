package cards.debitCards.bonusProgrammCards;

import cards.debitCards.DebitCard;

import java.util.List;

public class DebitCardBonusOnePercent extends DebitCard {
    private Double bonus;

    public DebitCardBonusOnePercent(Double bonus) {
        this.bonus = bonus;
    }

    @Override
    public List<Double> getInfoAboutTotalMany() {
        return List.of(balance, 0.0);
    }

    @Override
    public Boolean pay(Double sum) {
        Boolean payResult = true;
        if (sum <= balance) {
            balance = balance - sum;
        } else {
            payResult = false;
        }
        return payResult;
    }
}
