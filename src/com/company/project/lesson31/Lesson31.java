package com.company.project.lesson31;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lesson31 {

    public static CompletableFuture<String> run(){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("Инструкции задачи");
            return UUID.randomUUID().toString();
        });
    }

    public static void main(String[] args) {
        // CompletableFuture<Void>
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            System.out.println("Инструкции задачи");
        });

        CompletableFuture<String> idGen01 = CompletableFuture.supplyAsync(()->{
            System.out.println("Инструкции задачи");
            return UUID.randomUUID().toString();
        });
        try {
            idGen01.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        run().thenApply((res) -> {
            return res + UUID.randomUUID();
        }).thenAccept(res -> {
            System.out.println(res);
        }).exceptionally(exception -> {
            System.out.println(exception.getMessage());
            throw new RuntimeException(exception);
        });


        BankAccountVolatile accountVolatile = new BankAccountVolatile();
        ArrayList<Thread> threadsVolatile = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threadsVolatile.add(new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    accountVolatile.putMoney(10);
                }
            }));
        }

        threadsVolatile.forEach(Thread::start);
        for (Thread thread : threadsVolatile) {
            try {
                thread.join();
            } catch (InterruptedException e) {

            }
        }
        System.out.println(accountVolatile.getBalance()); //

        BankAccountAtomic accountAtomic = new BankAccountAtomic();
        ArrayList<Thread> threadsAtomic = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            threadsAtomic.add(new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    accountAtomic.putMoney(10);
                }
            }));
        }

        threadsAtomic.forEach(Thread::start);
        for (Thread thread : threadsAtomic) {
            try {
                thread.join();
            } catch (InterruptedException e) {

            }
        }
        System.out.println(accountAtomic.getBalance());

    }
}
