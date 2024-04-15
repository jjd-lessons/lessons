package com.company.project.lesson27;

import java.util.ArrayList;
import java.util.List;

public class Lesson27 {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        ThreadTask threadTask01 = new ThreadTask(stringList); // NEW
        System.out.println(threadTask01.getState());
        threadTask01.setName("ThreadTask 01");
        ThreadTask threadTask02 = new ThreadTask(stringList);
        threadTask02.setName("ThreadTask 02");

        threadTask01.start();
        threadTask02.start();

        System.out.println(Thread.currentThread().getName());

        RunnableTask runnableTask = new RunnableTask("task");
        Thread threadWithRunnable = new Thread(runnableTask);
        System.out.println(threadWithRunnable.getState());
        threadWithRunnable.start();
        // void run();

        Thread threadWithLambda = new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        });
        // фоновый поток
        threadWithLambda.setName("daemon");
        threadWithLambda.setDaemon(true);
        threadWithLambda.start();
        // Thread.currentThread().setDaemon(true);

        List<Double> doubles = new ArrayList<>();

        Thread addToDoubles = new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            doubles.add(Math.random()); // 0.654
        });
        // main
        addToDoubles.setName("addToDoubles");
        addToDoubles.start(); // main | addToDoubles
        // System.out.println(doubles);|  Thread.sleep(3000);
        System.out.println(doubles); // []

        try {
            // addToDoubles.join(); // main
            addToDoubles.join(4000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(doubles);

        System.out.println("main");


        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()) {
                // инструкции потока
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {  // interrupted=false
                    Thread.currentThread().interrupt(); // interrupted=true
                }
            }
        });
        // thread.interrupted - false
        thread.start();
        thread.interrupt();
    }
}












