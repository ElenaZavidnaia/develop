package ru.my.bank.bank;

import ru.my.bank.people.BankEmployee;

public class Bank {
    private String bankName;
    private String bankAddress;
    private BankEmployee bankEmployee;

    public Bank(String bankName, String bankAddress, String firstName, String lastName, String position) {
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.bankEmployee = new BankEmployee(firstName, lastName, position);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public BankEmployee getBankEmployee() {
        return bankEmployee;
    }

    public void setBankEmployee(BankEmployee bankEmployee) {
        this.bankEmployee = bankEmployee;
    }
}
