package ru.my.bank.builders;

import ru.my.bank.bank.Bank;
import ru.my.bank.people.Client;

public class Builder {
    public static Client buildClient(String firstName, String lastName, /*long accountNumber,*/ int passportSeries, long passportNumber, String creditworthiness, long creditAgreementNumber) {
        return new Client(firstName, lastName, /*accountNumber,*/ passportSeries, passportNumber, creditworthiness, creditAgreementNumber);
    }

    public static Bank buildBank(String bankName, String bankAddress, String firstName, String lastName, String position) {
        return new Bank(bankName, bankAddress, firstName, lastName, position);
    }
}
