package com.company.project.lesson31;


public class BankAccountVolatile {
    private volatile int balance;

    public synchronized void putMoney(int value) {
        this.balance = this.balance + value;
    }

/*    public void putMoney(int value) {
        // атомарная операция + volatile
        this.balance = value;
    }*/

    public int getBalance() {
        return balance;
    }
}
