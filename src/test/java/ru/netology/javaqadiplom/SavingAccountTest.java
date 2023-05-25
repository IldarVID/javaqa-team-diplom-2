package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000+3_000, account.getBalance());
    }

    @Test
    public void shouldTestTest() {
        SavingAccount account = new SavingAccount(
                1000,
                11_000,
                10_000,
                5
        );

//        account.add(3_000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldTestTruOrFalse() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        boolean actual = account.pay(3000);

        Assertions.assertFalse(actual);
    }


}
