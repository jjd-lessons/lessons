package com.company.project.lesson30;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomPool extends ThreadPoolExecutor {
    public CustomPool(int corePoolSize, // минимальное количество потоков
                      int maximumPoolSize, // максимальное количество потоков
                      long keepAliveTime, // время бездействия потока
                      TimeUnit unit, // ед. измерения
                      BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
}
