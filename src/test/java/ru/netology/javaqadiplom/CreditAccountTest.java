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
    public void shouldThrowExceptionIfRateLessZero() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                -15
        );


        Assertions.assertThrows(IllegalArgumentException.class,
                () -> account.getRate ()
        );
    }
    @Test
    public void shouldThrowExceptionIfCreditLimitLessZero() {  ///// под этот тест надо довести метод с Exception до ума
        CreditAccount account = new CreditAccount(
                1_000,
                -5_000,
                15
        );


        Assertions.assertThrows(IllegalArgumentException.class,
                () -> account.getCreditLimit ()
        );
    }
    @Test
    public void shouldThrowExceptionIfBalanceLessZero() { ///// под этот тест надо довести метод с Exception до ума
        CreditAccount account = new CreditAccount(
                -1_000,
                5_000,
                15
        );


        Assertions.assertThrows(IllegalArgumentException.class,
                () -> account.getBalance ()
        );
    }
    @Test
    public void ifPayLessLimit() {
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
    public void ifPayMorelLimit() {                        ///// этот тест не срабатывает потому что в методе надо доделать нормально условие чт опроиходит когда платеж больше лимита
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void rateIfBalanceNegative() {                        // надо доделать метод и все тесты по этому методу подкорректировать
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

       account.yearChange();

        Assertions.assertEquals(-30, account.getBalance());
    }

    @Test
    public void rateIfBalanceZero() {                        // надо доделать метод и все тесты по этому методу подкорректировать
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void rateIfBalancePositive() {                        // надо доделать метод и все тесты по этому методу подкорректировать
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(0, account.getBalance());
    }


}

