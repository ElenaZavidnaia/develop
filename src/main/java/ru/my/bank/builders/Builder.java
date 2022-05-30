package ru.my.bank.builders;

import ru.my.bank.bank.Bank;
import ru.my.bank.people.Client;
import ru.my.bank.services.MyExceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Builder {
    public static Client buildClient(Scanner scanner) throws MyExceptions, NumberFormatException, InputMismatchException {

        String firstName = "", lastName = "", creditworthiness = "";
        int passportSeries = 0;
        long passportNumber = 0, creditAgreementNumber = 0;

        System.out.println("");

        System.out.print("Введите имя\n");
        firstName = scanner.nextLine();
        if (firstName.equals("")) throw new MyExceptions(firstName);

        System.out.print("Введите фамилию\n");
        lastName = scanner.nextLine();
        if (lastName.equals("")) throw new MyExceptions(lastName);

        System.out.print("Введите серию паспорта\n");
        passportSeries = Integer.parseInt(scanner.nextLine());
        if ((passportSeries == 0) || (passportSeries < 0))
            throw new MyExceptions(Integer.toString(passportSeries));

        System.out.print("Введите номер паспорта\n");
        passportNumber = Long.parseLong(scanner.nextLine());
        if ((passportNumber == 0) || (passportNumber < 0))
            throw new MyExceptions(Long.toString(passportNumber));

        System.out.print("Введите кредитоспособность\n");
        creditworthiness = scanner.nextLine();
        if (creditworthiness.equals("")) throw new MyExceptions(creditworthiness);

        System.out.print("Введите номер кредитного договора\n");
        creditAgreementNumber = Long.parseLong(scanner.nextLine());
        if ((creditAgreementNumber == 0) || (creditAgreementNumber < 0))
            throw new MyExceptions(Long.toString(creditAgreementNumber));


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
