package ru.my.bank.people;

public class BankEmployee extends Human {
    private String firstName;
    private String lastName;
    private String position;
    private CreditExpert creditExpert;

    public BankEmployee(String firstName, String lastName, String position) {
        super(firstName, lastName);
        this.position = position;
        this.creditExpert = new CreditExpert(firstName, lastName);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public CreditExpert getCreditExpert() {
        return creditExpert;
    }

    public void setCreditExpert(CreditExpert creditExpert) {
        this.creditExpert = creditExpert;
    }
}
