package ru.my.bank.services;

public class Tarif {
    private String purpose;
    private long limit;
    private byte period;
    private byte rate;

    public Tarif(String purpose, long limit, byte period, byte rate) {
        this.purpose = purpose;
        this.limit = limit;
        this.period = period;
        this.rate = rate;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public byte getPeriod() {
        return period;
    }

    public void setPeriod(byte period) {
        this.period = period;
    }

    public byte getRate() {
        return rate;
    }

    public void setRate(byte rate) {
        this.rate = rate;
    }
    
}
