package com.company.project.lesson29.task01;

public class Lesson29 {
    public static void main(String[] args) {
        Account account01 = new Account(1, 2000);
        Account account02 = new Account(2, 4400);

        Transaction transaction01 =
                new Transaction(account01, account02, 300);
        Thread thread01 = new Thread(transaction01);
        thread01.start();

        Transaction transaction02 =
                new Transaction(account02, account01, 200);
        Thread thread02 = new Thread(transaction02);
        thread02.start();
    }
}
