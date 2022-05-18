package ru.my.bank;

import java.util.*;

import ru.my.bank.bank.Bank;
import ru.my.bank.builders.Builder;
import ru.my.bank.people.Client;
import ru.my.bank.people.CreditExpert;
import ru.my.bank.services.BankAccount;
import ru.my.bank.services.Credit;
import ru.my.bank.services.DebitCard;
import ru.my.bank.services.WorkWithFile;


public class BankApp {

    public static void main(String[] args) {
        // write your code here

        int clientOption = 0, passportSeries;
        long passportNumber;
        DebitCard debitCard;
        Credit credit;
        CreditExpert creditExpert;
        BankAccount bankAccount = new BankAccount();

        Scanner scanner = new Scanner(System.in);

        Client newClient = Builder.buildClient(scanner);
        Bank officeBank = Builder.buildBank("СберБанк", "просп.имени 50 лет Октября, 58, Саратов, Россия", "Пётр", "Сергеев", "кредитный эксперт");

        creditExpert = officeBank.getBankEmployee().getCreditExpert();

        Map<Client, Set<Long>> clientBase = WorkWithFile.getClientBase();

        do {
            System.out.println(" ");
            System.out.println("1: Открыть банковский счёт");
            System.out.println("2: Оформить кредит");
            System.out.println("3: Оформить дебетовую карту");
            System.out.println("4: Выход");

            System.out.println("Выберите вариант");
            try {
                clientOption = Integer.parseInt(scanner.nextLine());
            } catch (NoSuchElementException nsee) {
                System.out.println(nsee.getMessage());
            }
            switch (clientOption) {
                case 1 -> {
                    System.out.println("1: Открыть банковский счёт");
                    Set<Long> accountNumber = new HashSet<>();
                    accountNumber = bankAccount.openBankAccount(newClient, clientBase, scanner);
                    /*for (Map.Entry<Client, Set<Long>> itr : clientBase.entrySet())
                    {
                        System.out.println(itr.getKey().toString());
                    }
                    */
                    System.out.println(newClient.getFirstName() + " " + newClient.getLastName());
                    Iterator<Long> itr = clientBase.get(newClient).iterator();
                    do {
                        System.out.println("Номер счёта :№" + itr.next().toString());
                    } while (itr.hasNext());

                    WorkWithFile.WritingToFile(clientBase);
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
}