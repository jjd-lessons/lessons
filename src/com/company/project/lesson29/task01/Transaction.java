package com.company.project.lesson29.task01;

public class Transaction implements Runnable{
    private Account src; // аккаунт, с которого нужно перевести денежные средства
    private Account dst; // аккаунт, на который нужно перевести денежные средства
    private int money; // сколько нужно перевести

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    @Override
    public void run() {
        // TODO перевод денежных средств с src на dst в количестве money
    }
}