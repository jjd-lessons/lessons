package com.company.project.lesson29.task01;

public class Transaction implements Runnable {
    private Account src; // аккаунт, с которого нужно перевести денежные средства
    private Account dst; // аккаунт, на который нужно перевести денежные средства
    private int money; // сколько нужно перевести

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    @Override
    public /*synchronized*/ void run() {
        // параллельные изменения связаны с аккаунтами, которые создаются вне транзакции
        // поэтому синхронизация на транзакции не поможет
        /*synchronized (this){

        }*/
        // TODO перевод денежных средств с src на dst в количестве money
        // вариант 1
        synchronized (src) {
            if (src.getBalance() >= money)
                src.setBalance(src.getBalance() - money);
        }
        synchronized (dst) {
            dst.setBalance(dst.getBalance() + money);
        }

        // вариант 2
        if (src.getId() > dst.getId()) {
            synchronized (src) {
                synchronized (dst) {
                    if (src.getBalance() >= money) {
                        src.setBalance(src.getBalance() - money);
                        dst.setBalance(dst.getBalance() + money);
                    }
                }
            }
        } else {
            synchronized (dst) {
                synchronized (src) {
                    if (src.getBalance() >= money) {
                        src.setBalance(src.getBalance() - money);
                        dst.setBalance(dst.getBalance() + money);
                    }
                }
            }
        }


    }
}