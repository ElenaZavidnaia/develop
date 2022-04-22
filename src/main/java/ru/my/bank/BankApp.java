package ru.my.bank;

import java.util.*;

import ru.my.bank.bank.Bank;
import ru.my.bank.builders.Builder;
import ru.my.bank.people.Client;
import ru.my.bank.people.CreditExpert;
import ru.my.bank.services.BankAccount;
import ru.my.bank.services.clientDB;
import ru.my.bank.services.Credit;
import ru.my.bank.services.DebitCard;
//import ru.my.bank.base.ClientBase;


public class BankApp {

    public static void main(String[] args) {
        // write your code here

        int clientOption, passportSeries;
        long passportNumber;
        DebitCard debitCard;
        Credit credit;
        CreditExpert creditExpert;
        BankAccount bankAccount;
        clientDB bankServices;
      //  int indexNewClient;

        //Client newClient = Builder.buildClient("Николай", "Петров", 5005, 123456, "высокая", 1234);
        Client newClient = Builder.buildClient("Дмитрий", "Вольский", 5001, 111111111, "высокая", 0);

        Bank officeBank = Builder.buildBank("СберБанк", "просп.имени 50 лет Октября, 58, Саратов, Россия", "Пётр", "Сергеев", "кредитный эксперт");

        creditExpert = officeBank.getBankEmployee().getCreditExpert();

        bankServices = new clientDB();
        Map<Client, Set<Long>> clientBase = bankServices.getClientBase();

        boolean isClient = clientBase.containsKey(newClient);

        Scanner scanner = new Scanner(System.in);

        do {

            System.out.println(" ");
            System.out.println("1: Открыть банковский счёт");
            System.out.println("2: Оформить кредит");
            System.out.println("3: Оформить дебетовую карту");
            System.out.println("4: Выход");
            System.out.println("Выберите вариант");

            clientOption = scanner.nextInt();

            switch (clientOption) {
                case 1 -> {
                    System.out.println("1: Открыть банковский счёт");
                    openBankAccount(newClient, clientBase, isClient, scanner);
                    /*for (Map.Entry<Client, Set<Long>> itr : clientBase.entrySet())
                    {
                        System.out.println(itr.getKey().toString());
                    }
                    */
                    System.out.println(newClient);
                    Iterator<Long> itr = clientBase.get(newClient).iterator();
                    do
                    {
                        System.out.println("Номер счёта :№" + itr.next().toString());
                    }while (itr.hasNext());
                }
                case 2 -> {
                    System.out.println("2: Оформить кредит");
                    credit = new Credit("потребительский", 3000000, (byte) 5, (byte) 6);
                    if (creditExpert.creditOpen(newClient.getCreditworthiness()) &&
                            (credit.getLimit() > 2000000) && (credit.getPeriod() > 10) && (credit.getPeriod() < 3))
                        System.out.println("Кредит можно оформить");
                    else System.out.println("Кредит оформить нельзя");
                }
                case 3 -> {
                    System.out.println("3: Оформить дебетовую карту");
                    debitCard = new DebitCard();
                    debitCard.setOwner(newClient.getFirstName() + " " + newClient.getLastName());
                    System.out.println(debitCard.getOwner());
                }
                case 4 -> System.out.println("4: Выход");
            }
        }
        while (clientOption != 4);

        scanner.close();
    }

    private static void openBankAccount(Client newClient, Map<Client, Set<Long>> clientBase, boolean isClient, Scanner scanner) {
        long passportNumber;
        int passportSeries;
        BankAccount bankAccount;
        if (!isClient) System.out.println("Новый клиент");

        do {
            System.out.println("Введите серию паспорта");
            passportSeries = scanner.nextInt();
            System.out.println("Введите номер паспорта");
            passportNumber = scanner.nextLong();
            bankAccount = new BankAccount();
        } while (!bankAccount.createAccount(passportSeries, passportNumber));

        //newClient.setAccountNumber(bankAccount.getAccountNumber());
        Set<Long> accountNumber = new HashSet<>();

        if (isClient) accountNumber = clientBase.get(newClient);

        accountNumber.add(bankAccount.getAccountNumber());
        clientBase.put(newClient, accountNumber);
    }
}
