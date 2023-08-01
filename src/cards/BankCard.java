package Cards;

public abstract class BankCard {
    protected double balance;
    protected BankCard (Double balance) {
        this.balance = balance;
    }

    public abstract void topUp(Double sum);
    public double getBalance() {
        return balance;
    }

    public abstract void pay(Double sum);

    public abstract double getCurrentLimit();
    @Override
    public String toString() {
        return "BankCard{" +
                "balance=" + balance +
                '}';
    }
}
