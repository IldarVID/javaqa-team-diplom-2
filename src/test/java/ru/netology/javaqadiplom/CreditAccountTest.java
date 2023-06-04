package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4000, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalanceIfAmountZero() {
        CreditAccount account = new CreditAccount(
                1500,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalanceIfAmountWrong() {
        CreditAccount account = new CreditAccount(
                1500,
                5_000,
                15
        );

        account.add(-1000);

        Assertions.assertEquals(1_500, account.getBalance());
    }


    @Test
    public void showExceptionIfWrongRate() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CreditAccount(1000, 2000, -15);
                });
    }

    @Test
    public void showExceptionIfWrongInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CreditAccount(-1000, 2000, 15);
                });
    }

    @Test
    public void showExceptionIfWrongCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CreditAccount(1000, -2000, 15);
                });
    }

    @Test
    public void ifPayNotMoreLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(-3_000, account.getBalance());
    }

    @Test
    public void ifPayEqualLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(5_000);

        Assertions.assertEquals(-5_000, account.getBalance());
    }

    @Test
    public void ifPayMorelLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void rateIfBalanceNegative() {
        CreditAccount account = new CreditAccount(
                400,
                5_000,
                15
        );

        account.pay(600);

        Assertions.assertEquals(-30, account.yearChange());

    }

    @Test
    public void rateIfBalanceZero() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        account.pay(200);

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void rateIfBalancePositive() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.pay(200);

        Assertions.assertEquals(0, account.yearChange());
    }


}

