package ru.my.bank.services;

public class DebitCard {
    private long numberCard;
    private String periodCard;
    private int cvcCard;
    private String owner;

    public DebitCard() {
    }

    public long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(long numberCard) {
        this.numberCard = numberCard;
    }

    public String getPeriodCard() {
        return periodCard;
    }

    public void setPeriodCard(String periodCard) {
        this.periodCard = periodCard;
    }

    public int getCvcCard() {
        return cvcCard;
    }

    public void setCvcCard(int cvcCard) {
        this.cvcCard = cvcCard;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
