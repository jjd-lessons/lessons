package com.company.project.lesson30;

import java.util.List;
import java.util.concurrent.*;

public class Lesson30Pools {
    public static void main(String[] args) {
        // [thread01, thread02, thread03]
        // BlockingQueue [task01, task02] задачи для потоков пула

        /*class Th extends Thread {
            BlockingQueue<Runnable> tasks;

            public Th(BlockingQueue<Runnable> tasks) {
                this.tasks = tasks;
            }
            public void run(){
                while (!Thread.currentThread().isInterrupted()) {
                    Runnable task = tasks.take();
                    task.run();
                }
            }
        }*/

        // Executor
        // ExecutorService
        // ThreadPoolExecutor | ForkJoinPool
        // Executors

        // [thread01, thread02, thread03]
        // Пул фиксированного размера (ThreadPoolExecutor)
        ExecutorService pool01 = Executors.newFixedThreadPool(3);
        pool01.execute(()->{
            System.out.println("First Task");
        });
        pool01.execute(()->{
            System.out.println("Second Task");
        });
        pool01.shutdown(); // []
        // List<Runnable> runnables = pool01.shutdownNow(); // [task10, task11]

        // Пул фиксированного размера на 1 поток (ThreadPoolExecutor)
        ExecutorService pool02 = Executors.newSingleThreadExecutor();
        pool02.shutdown();

        // (ThreadPoolExecutor)
        ExecutorService pool03 = Executors.newCachedThreadPool();
        Future<String> result = pool03.submit(new IdGenerator());
        // String id = result.get(); // join
        // String id = result.get(10, TimeUnit.SECONDS); // join(time)
        pool03.shutdown();

        CustomPool customPool = new CustomPool(3, // минимальное количество потоков
                10, // максимальное количество потоков
                10, TimeUnit.MINUTES, // время бездействия потока
                new ArrayBlockingQueue<>(1000)); // очередь для задач
        customPool.execute(()->{});
        customPool.shutdown();






    }
}
