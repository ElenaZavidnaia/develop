package ru.my.bank.services;

public class MyExceptions extends Exception{
    private String message;

    public MyExceptions(String exMess) {
        this.message = exMess;
    }

    @Override
    public String toString() {
        return "Не верно введены данные " + this.message;
    }
}
