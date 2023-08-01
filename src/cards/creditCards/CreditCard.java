package cards.creditCards;

import cards.BankCard;

import java.util.List;

public class CreditCard extends BankCard {
    protected final double CREDIT_LIMIT; // Лимит карты устанавливается при открытии карты
    protected double currentLimit; // Начальный, текущий лимит равен установленному лимиту

    public CreditCard(double limit) {
        super(0.0);
        this.CREDIT_LIMIT = limit;
        this.currentLimit = CREDIT_LIMIT;
    }

    @Override
    public void topUp(double sum) {
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
    public Boolean pay(double sum) {
        Boolean payResult = true;
        if (sum < balance) {
            balance = balance - sum;
        } else if (sum == balance) {
            balance = 0.0;
        } else if (sum > balance) {
            currentLimit = currentLimit - (sum - balance);
            balance = 0.0;
        } else if (sum > (currentLimit + balance)) {
            payResult = false;
        }
        return payResult;
    }

    @Override
    public List<Double> getInfoAboutTotalMany() {
        return List.of(balance, currentLimit);
    }
    
}
