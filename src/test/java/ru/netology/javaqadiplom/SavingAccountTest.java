package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldShowJustBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddToEqualMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(2_000 + 8_000, account.getBalance());
    }

    @Test
    public void shouldAddToEqualMinBalanceIfPayZero() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldAddToMakeOverMaxBalance() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        account.add(10_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldTestPayIfFalse() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        boolean actual = account.pay(3000);

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldTestPayIfTrue() {
        SavingAccount account = new SavingAccount(
                4_000,
                1_000,
                10_000,
                5
        );

        boolean actual = account.pay(3000);

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldTestPay() {
        SavingAccount account = new SavingAccount(
                10_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(7_000, account.getBalance());
    }

    @Test
    public void shouldTestIfPayMakeLowMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldTestIfPayMakeMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }

    @Test
    public void shouldTestIfPayZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldTestIfPayLowZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-1_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }


    @Test
    public void shouldCountRate() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(300, account.getRate());
    }

    @Test
    public void shouldCountRateIfBalanceMin() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(150, account.getRate());
    }

    @Test
    public void shouldCountRateIfBalanceMax() {
        SavingAccount account = new SavingAccount(
                10_000,
                1_000,
                10_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(1500, account.getRate());
    }

    @Test
    public void shouldCountRateZero() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                0
        );

        account.yearChange();

        Assertions.assertEquals(0, account.getRate());
    }


    @Test
    public void shouldShowExceptions() {
        SavingAccount account = new SavingAccount(1000,2000,10000,15);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new SavingAccount(1000,2000,10000,15);
                });
    }


}
