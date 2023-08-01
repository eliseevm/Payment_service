package cards.creditCards.bonusProgrammCards;

import cards.creditCards.CreditCard;

import java.util.List;

public class CreditCardSaveMoney extends CreditCard {
    double PERCENT_SIZE;

    private double sumPercent;

    public CreditCardSaveMoney(double percentSize, double limit) {
        super(limit);
        this.PERCENT_SIZE = percentSize / 100;
        this.sumPercent = 0.0;
    }

    @Override
    public void topUp(double sum) {
        double difference = CREDIT_LIMIT - currentLimit;
        if (currentLimit == CREDIT_LIMIT) {
            balance = balance + sum;
            sumPercent = sumPercent + sum * PERCENT_SIZE;
        } else if (currentLimit < CREDIT_LIMIT && sum == difference) {
            currentLimit = CREDIT_LIMIT;
        } else if (currentLimit < CREDIT_LIMIT && sum < difference) {
            currentLimit = currentLimit + sum;
        } else if (currentLimit < CREDIT_LIMIT && sum > difference) {
            balance = balance + (sum - difference);
            currentLimit = CREDIT_LIMIT;
            sumPercent = sumPercent + ((sum - difference) * PERCENT_SIZE);
        }
    }

    @Override
    public List<Double> getInfoAboutTotalMany() {
        return List.of(balance, currentLimit, 0.0, 0.0, sumPercent);
    }
}
