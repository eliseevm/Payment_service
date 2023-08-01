package tests;

import cards.creditCards.CreditCard;

import static org.junit.jupiter.api.Assertions.*;

import cards.creditCards.bonusProgrammCards.CreditCardBonusPercent;
import cards.creditCards.bonusProgrammCards.CreditCardCashBack;
import cards.creditCards.bonusProgrammCards.CreditCardSaveMoney;
import cards.debitCards.DebitCard;
import cards.debitCards.bonusProgrammCards.DebitCardBonusInPercent;
import cards.debitCards.bonusProgrammCards.DebitCardSaveMoney;
import org.junit.Test;

public class CardTest {

    @Test
    public void topUpAndPayCreditCard() {
        CreditCard card = new CreditCard(10000);
        card.topUp(5000.0);
        assertEquals(10000.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(5000.0, card.getBalance());

        card.pay(5000.0);
        assertEquals(10000.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(0.0, card.getBalance());


        card.pay(3000.0);
        assertEquals(7000.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(0.0, card.getBalance());

        card.topUp(2000.0);
        assertEquals(9000.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(0.0, card.getBalance());

        card.topUp(2000.0);
        assertEquals(10000.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(1000.0, card.getBalance());
    }


    @Test
    public void topUpAndPayDebitCard() {
        DebitCard debCard = new DebitCard();
        debCard.topUp(3000.0);
        assertEquals(3000.0, debCard.getBalance());

        debCard.pay(2000.0);
        assertEquals(1000.0, debCard.getBalance());

        assertFalse(debCard.pay(3000.0));

        debCard.topUp(2000.0);
        assertEquals(3000.0, debCard.getBalance());
    }

    @Test
    public void topUpAndPayCreditCardBonus() {
        CreditCardBonusPercent card = new CreditCardBonusPercent(2, 100000);
        card.topUp(15000.0);
        assertEquals(100000.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(15000.0, card.getBalance());

        card.pay(7000.0);
        assertEquals(100000.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(8000.0, card.getBalance());
        assertEquals(140.0, card.getInfoAboutTotalMany().get(2));

        card.pay(30500.0);
        assertEquals(77500.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(0.0, card.getBalance());
        assertEquals(750, card.getInfoAboutTotalMany().get(2));

    }

    @Test
    public void topUpAndPayCreditCardCash() {
        CreditCardCashBack card = new CreditCardCashBack(5, 120000);
        card.topUp(17000.0);
        assertEquals(120000.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(17000.0, card.getBalance());

        card.pay(72000.0);
        assertEquals(48000.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(0.0, card.getBalance());
        assertEquals(3600.0, card.getInfoAboutTotalMany().get(3));

        card.pay(30500.0);
        assertEquals(17500.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(0.0, card.getBalance());
        assertEquals(5125, card.getInfoAboutTotalMany().get(3));

    }

    @Test
    public void topUpAndPayCreditCardSM() {
        CreditCardSaveMoney card = new CreditCardSaveMoney(0.005, 80000);
        card.topUp(14000.0);
        assertEquals(80000.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(14000.0, card.getBalance());
        assertEquals(0.7000000000000001, card.getInfoAboutTotalMany().get(4));

        card.pay(24000.0);
        assertEquals(70000.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(0.0, card.getBalance());


        card.topUp(4000.0);
        assertEquals(74000.0, card.getInfoAboutTotalMany().get(1));
        assertEquals(0.0, card.getBalance());
        assertEquals(0.7000000000000001, card.getInfoAboutTotalMany().get(4));

    }

    @Test
    public void topUpAndPayDebitCardBonus() {
        DebitCardBonusInPercent card = new DebitCardBonusInPercent(2);
        card.topUp(5000.0);
        assertEquals(5000.0, card.getBalance());

        assertFalse(card.pay(7000.0));

        card.pay(3500.0);
        assertEquals(70.0, card.getInfoAboutTotalMany().get(2));
        assertEquals(1500.0, card.getBalance());
    }

    @Test
    public void topUpAndPayDebitCardCash() {
        DebitCardBonusInPercent card = new DebitCardBonusInPercent(8);
        card.topUp(55000.0);
        assertEquals(55000.0, card.getBalance());

        assertFalse(card.pay(70000.0));

        card.pay(3500.0);
        assertEquals(280.0, card.getInfoAboutTotalMany().get(2));
        assertEquals(51500.0, card.getBalance());
    }

    @Test
    public void topUpAndPayDebitCardSM() {
        DebitCardSaveMoney card = new DebitCardSaveMoney(3);
        card.topUp(44000.0);
        assertEquals(44000.0, card.getBalance());
        assertEquals(1320.0, card.getInfoAboutTotalMany().get(4));

        assertFalse(card.pay(50000.0));

        card.pay(3900.0);
        assertEquals(40100.0, card.getBalance());
    }
}
