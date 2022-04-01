package ru.my.bank.services;

public class Credit extends Tarif {
    private String purpose;
    private long limit;
    private byte period;
    private byte rate;

   public Credit(String purpose, long limit, byte period, byte rate) {
        super(purpose, limit, period, rate );
   }

}