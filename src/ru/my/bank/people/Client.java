package ru.my.bank.people;

import ru.my.bank.services.Account;

import java.util.*;

public class Client extends Human {
    //   private String firstName;
    //   private String lastName;
    //private long accountNumber;
    private int passportSeries;
    private long passportNumber;
    private String creditworthiness;
    private long creditAgreementNumber;
//    private HashSet<Client> client;
   // private List<Account> account;

    //Client clientt;

    public Client(String firstName, String lastName, int passportSeries, long passportNumber, String creditworthiness, long creditAgreementNumber) {

        super(firstName, lastName);
//        this.accountNumber = accountNumber;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.creditworthiness = creditworthiness;
        this.creditAgreementNumber = creditAgreementNumber;
    }

    /*
        public long getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(long accountNumber) {
            this.accountNumber = accountNumber;
        }
    */
    public int getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(short passportSeries) {
        this.passportSeries = passportSeries;
    }

    public long getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(long passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getCreditworthiness() {
        return creditworthiness;
    }

    public void setCreditworthiness(String creditworthiness) {
        this.creditworthiness = creditworthiness;
    }

    public long getCreditAgreementNumber() {
        return creditAgreementNumber;
    }

    public void setCreditAgreementNumber(long creditAgreementNumber) {
        this.creditAgreementNumber = creditAgreementNumber;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", Сeрия паспорта :" + passportSeries +
                ", Номер паспорта :" + passportNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client1 = (Client) o;
        return passportSeries == client1.passportSeries &&
                passportNumber == client1.passportNumber &&
                //creditAgreementNumber == client1.creditAgreementNumber &&
                getFirstName().equals(client1.getFirstName()) &&
                getLastName().equals(client1.getLastName())/* &&
                creditworthiness.equals(client1.creditworthiness)*/;

    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), passportSeries, passportNumber);
    }

}