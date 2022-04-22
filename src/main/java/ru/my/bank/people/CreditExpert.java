package ru.my.bank.people;

public class CreditExpert extends Human{

    public CreditExpert(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public boolean creditOpen(String creditworthiness)
    {
        return creditworthiness.equalsIgnoreCase("высокая");
    }
}
