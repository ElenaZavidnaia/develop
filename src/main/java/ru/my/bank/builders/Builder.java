package ru.my.bank.builders;

import ru.my.bank.bank.Bank;
import ru.my.bank.people.Client;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Builder {
    public static Client buildClient(Scanner scanner) {

        String firstName="", lastName="", creditworthiness="";
        int passportSeries=0;
        long passportNumber=0, creditAgreementNumber=0;

        System.out.println("");
        try {
            System.out.print("Введите имя\n");
            firstName = scanner.nextLine();

            System.out.print("Введите фамилию\n");
            lastName = scanner.nextLine();

            System.out.print("Введите серию паспорта\n");
            passportSeries = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите номер паспорта\n");
            passportNumber = Long.parseLong(scanner.nextLine());

            System.out.print("Введите кредитоспособность\n");
            creditworthiness = scanner.nextLine();

            System.out.print("Введите номер кредитного договора\n");
            creditAgreementNumber = Long.parseLong(scanner.nextLine());

        }catch (InputMismatchException ime) {
            System.out.println(ime.getMessage());
        }

        /*firstName= "Дмитрий";
        lastName = "Вольский";
        passportSeries = 5001;
        passportNumber = 111111111;
        creditworthiness = "высокая";
        creditAgreementNumber = 0;*/

        return new Client(firstName, lastName, passportSeries, passportNumber, creditworthiness, creditAgreementNumber);
    }

    public static Bank buildBank(String bankName, String bankAddress, String firstName, String lastName, String position) {
        return new Bank(bankName, bankAddress, firstName, lastName, position);
    }
}
