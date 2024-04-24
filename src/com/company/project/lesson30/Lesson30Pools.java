package com.company.project.lesson30;

import com.company.project.lesson31.FileFinder;

import java.io.File;
import java.util.Arrays;
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

        try {
            String id = result.get(); // join
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            // если выброшен Exception в методе call,
            // выполняющейся задачи
        }
        try {
            String id = result.get(10, TimeUnit.SECONDS); // join(time)
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            // если выброшен Exception в методе call,
            // выполняющейся задачи
        } catch (TimeoutException e) {
            // если через 10, TimeUnit.SECONDS
            // метод get не вернет результат выполнения задачи
        }
        try {
            List<Future<String>> futureList =
                    pool03.invokeAll(List.of(new IdGenerator(), new IdGenerator()));
            for (Future<String> stringFuture : futureList) {
                try {
                    // ожидание каждого контейнера
                    String id = stringFuture.get(10, TimeUnit.SECONDS);
                    System.out.println(id);
                } catch (ExecutionException e) {
                    // во время выполнения задачи произошла ошибка
                } catch (TimeoutException e) {
                    // результат в контейнере не появился
                    // за 10, TimeUnit.SECONDS
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        pool03.shutdown();

        CustomPool customPool = new CustomPool(3, // минимальное количество потоков
                10, // максимальное количество потоков
                10, TimeUnit.MINUTES, // время бездействия потока
                new ArrayBlockingQueue<>(1000)); // очередь для задач
        customPool.execute(()->{});
        customPool.shutdown();

        ScheduledExecutorService scPool01 = Executors.newScheduledThreadPool(3);
        scPool01.scheduleAtFixedRate(()->{
                    System.out.println("задача, которая должна " +
                            "запускаться на выполнение каждые 3 минуты");
                },
                0, 3, TimeUnit.MINUTES
        );
        scPool01.scheduleWithFixedDelay(()->{
                    System.out.println("задача, которая должна " +
                            "запускаться на выполнение " +
                            "каждые 3 минуты после завершения предыдущей");
                },
                0, 3, TimeUnit.MINUTES
        );
        scPool01.schedule(()->{
                    System.out.println("задача, " + "которая выполнится один раз через 3 минуты");
                },
                3, TimeUnit.MINUTES
        );

        FileFinder mainTask = new FileFinder(new File("file.txt"),
                new File("lesson20"));
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        forkJoinPool.execute(mainTask);
        File ffResult01 = mainTask.join();

        File ffResult02 = forkJoinPool.invoke(mainTask);

        ExecutorService stealingPool = Executors.newWorkStealingPool();
        // [ thread01 - t4 - очередь задач - [, t4]
        //   thread02 - t2 - очередь задач - [, t5]
        //   thread03 - t7 - очередь задач - [ ]
        // ]
        stealingPool.execute(()->{});
        stealingPool.shutdown();

        // виртуальные потоки java 21
        Thread virtual01 = Thread
                .ofVirtual()
                .start(()->{});

        Thread virtual02 = Thread
                .startVirtualThread(()->{});

        ExecutorService virtualPool = Executors.newVirtualThreadPerTaskExecutor();
        virtualPool.execute(()->{});











    }
}
