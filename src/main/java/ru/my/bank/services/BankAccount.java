package ru.my.bank.services;

import ru.my.bank.people.Client;

import java.util.*;

public class BankAccount {
    private long accountNumber;

 //   public BankAccount(long accountNumber) {
 //       this.accountNumber = accountNumber;
 //   }

    public BankAccount() {
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void createAccount() {

        long saveAccount, newAccount = 0;

        do {
            saveAccount = newAccount;
            newAccount = new Random().nextLong(1, Long.MAX_VALUE);
        } while (saveAccount == newAccount);
        this.setAccountNumber(newAccount);
        System.out.println("Вам открыт счёт №" + this.getAccountNumber());
    }

    public Set<Long> openBankAccount(Client newClient, Map<Client, Set<Long>> clientBase, Scanner scanner) {

        boolean verifyClient;

        if (!(verifyClient = newClient.isClient(newClient, clientBase))) System.out.println("Новый клиент");

        BankAccount bankAccount = new BankAccount();
        bankAccount.createAccount();    //Создать новый счёт

        Set<Long> accountNumber = new HashSet<>();

        if (verifyClient) accountNumber = clientBase.get(newClient);    //Если клиент есть в базе, то получить его счета из базы

        accountNumber.add(bankAccount.getAccountNumber());
        clientBase.put(newClient, accountNumber);
        return accountNumber;   //Возвращает все счета клиента
    }
}
