package cards;

import java.util.List;

public class CreditCard extends BankCard {
    private final double CREDIT_LIMIT; // Лимит карты устанавливается при открытии карты
    private double currentLimit;

    public CreditCard(Double limit) {
        super(0.0);
        this.CREDIT_LIMIT = limit;
        this.currentLimit = CREDIT_LIMIT;
    }


    public void topUp(Double sum) {
        double difference = CREDIT_LIMIT - currentLimit;
        if (currentLimit == CREDIT_LIMIT) {
            balance = balance + sum;
        } else if (currentLimit < CREDIT_LIMIT && sum == difference) {
            currentLimit = CREDIT_LIMIT;
        } else if (currentLimit < CREDIT_LIMIT && sum < difference) {
            currentLimit = currentLimit + sum;
        } else if (currentLimit < CREDIT_LIMIT && sum > difference) {
            balance = balance + (sum - difference);
            currentLimit = CREDIT_LIMIT;
        }
    }


@Override
    public Boolean pay(Double sum) {
        Boolean payResult = true;
        if (sum < balance) {
            balance = balance - sum;
        } else if (sum == balance) {
            balance = 0.0;
        } else if (sum > balance) {
            balance = 0.0;
            currentLimit = currentLimit - (sum - balance);
        } else if ( sum > (currentLimit + balance)) {
            payResult = false;
        }
        return payResult;
    }

    @Override
    public List<Double> getInfoAboutTotalMany() {
        return List.of(balance, currentLimit);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "CREDIT_LIMIT=" + CREDIT_LIMIT +
                ", currentLimit=" + currentLimit +
                '}';
    }
}
