package cards;

import java.util.List;

public class DebetCard extends BankCard {

    public DebetCard() {
        super(0.0);
    }

    @Override
    public void topUp(Double sum) {
        balance = balance + sum;
    }

    @Override
    public Boolean pay(Double sum) {
        return null;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public List<Double> getInfoAboutTotalMany() {
        return null;
    }

//    @Override
//    public List<Double> getInfoAboutTotalMany() {
//        return List.of(balance, 0.0);
//    }
//
//    @Override
//    public Boolean pay(Double sum) {
//Boolean payResult = true;
//if (sum >= balance) {
//    balance = balance - sum;
//} else {
//    payResult = false;
//}
//return payResult;
//    }
//
//    @Override
//    public double getCurrentLimit() {
//        return 0;
//    }
}
