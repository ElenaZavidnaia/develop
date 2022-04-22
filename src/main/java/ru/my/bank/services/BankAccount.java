package ru.my.bank.services;

import java.util.Random;

public class BankAccount {
    private long accountNumber;

    public BankAccount(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccount() {
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean createAccount(int passportSeries, long passportNumber) {
        boolean result;
        long saveAccount, newAccount = 0;

        if ((passportSeries == 0) || (passportNumber == 0)) {
            System.out.println("Не верно введены данные паспорта");
            result = false;
        } else {
            do {
                saveAccount = newAccount;
                newAccount = new Random().nextLong(1, Long.MAX_VALUE);
            } while ( saveAccount == newAccount );
            this.setAccountNumber(newAccount);
            System.out.println("Вам открыт счёт №" + this.getAccountNumber());
            result = true;
        }
        return result;
    }
}
