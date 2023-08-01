import cards.creditCards.CreditCard;
import cards.creditCards.bonusProgrammCards.CreditCardBonusPercent;
import cards.creditCards.bonusProgrammCards.CreditCardCashBack;
import cards.creditCards.bonusProgrammCards.CreditCardSaveMoney;
import cards.debitCards.DebitCard;
import cards.debitCards.bonusProgrammCards.DebitCardBonusInPercent;
import cards.debitCards.bonusProgrammCards.DebitCardCashBack;
import cards.debitCards.bonusProgrammCards.DebitCardSaveMoney;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import tests.CardTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        String number = "";
        while (number != "0") {
            System.out.println("Добро пожаловать в БАНК МЕЧТА" + "\n" + "Выберите карту для клиента");
            System.out.println("1 - Дебетовая карта" + "\n" +
                    "2 - Дебетовая карта с бонусами за покупки" + "\n" +
                    "3 - Дебетовая карта с кешбэком" + "\n" +
                    "4 - Дебетовая карта с процентами на внесенную сумму" + "\n" +
                    "5 - Кредитная карта карта" + "\n" +
                    "6 - Кредитная карта с бонусами" + "\n" +
                    "7 - Кредитная карта с кэшбэком" + "\n" +
                    "8 - Кредитная карта с процентами на сумму поступившую на баланс" + "\n" +
                    "9 - запуск тестирования оборудования " + "\n" +
                    "0 - Выход");

            number = scanner1.nextLine();

            if (number.equals("1")) {
                printMassage();
                double sum = scanner.nextDouble();
                new DebitCard().topUp(sum);
                System.out.println(sum + " - Внесено на карту");
            } else if (number.equals("2")) {
                printMassage();
                double sum = scanner.nextDouble();
                System.out.println("Установите размер бонусов от потрченных сумм в процентах ");
                int percentBonus = scanner.nextInt();
                new DebitCardBonusInPercent(percentBonus).topUp(sum);
                System.out.println(sum + " - Внесено на карту");
            } else if (number.equals("3")) {
                printMassage();
                double sum = scanner.nextDouble();
                System.out.println("Установите размер кэшбэка от потрченных сумм в процентах ");
                int percentCash = scanner.nextInt();
                new DebitCardCashBack(percentCash).topUp(sum);
                System.out.println(sum + " - Внесено на карту");
            } else if (number.equals("4")) {
                printMassage();
                double sum = scanner.nextDouble();
                System.out.println("Установите размер начислений на сумму вносимую на пополнение баланса в процентах ");
                int percentSM = scanner.nextInt();
                new DebitCardSaveMoney(percentSM).topUp(sum);
                System.out.println(sum + " - Внесено на карту");
            } else if (number.equals("5")) {
                printMassage();
                double sum = scanner.nextDouble();
                printOtherMassage();
                int creditLimit = scanner.nextInt();
                new CreditCard(creditLimit).topUp(sum);
                System.out.println(sum + " - Внесено на карту");
            } else if (number.equals("6")) {
                printMassage();
                double sum = scanner.nextDouble();
                printOtherMassage();
                int creditLimit = scanner.nextInt();
                System.out.println("Установите размер бонусов от потрченных сумм в процентах ");
                int bonusPercent = scanner.nextInt();
                new CreditCardBonusPercent(bonusPercent, creditLimit).topUp(sum);
                System.out.println(sum + " - Внесено на карту");
            } else if (number.equals("7")) {
                printMassage();
                double sum = scanner.nextDouble();
                printOtherMassage();
                int creditLimit = scanner.nextInt();
                System.out.println("Установите размер кэшбэка от потрченных сумм в процентах ");
                int cashPercent = scanner.nextInt();
                new CreditCardCashBack(cashPercent, creditLimit).topUp(sum);
                System.out.println(sum + " - Внесено на карту");
            } else if (number.equals("8")) {
                printMassage();
                double sum = scanner.nextDouble();
                printOtherMassage();
                int creditLimit = scanner.nextInt();
                System.out.println("Установите процентную ставку на суммы поступившие на баланс собственных средств");
                double SMPercent = scanner.nextInt();
                new CreditCardSaveMoney(SMPercent, creditLimit).topUp(sum);
                System.out.println(sum + " - Внесено на карту");
            } else if (number.equals("9")) {
                JUnitCore junit = new JUnitCore();
                junit.addListener(new TextListener(System.out));
                junit.run(CardTest.class);
            } else if (number.equals("0")) {
                break;
            } else {
                System.out.println("Введен неверный код меню, повторите прпытку ");
            }
        }
    }

    private static void printMassage() {
        System.out.println("Какую сумму хочет внести клиент? Введите значение ");
    }

    private static void printOtherMassage() {
        System.out.println("Установите размер кредитного лимита в рублях");
    }
}