package com.company.project.lesson30;

import java.util.UUID;
import java.util.concurrent.Callable;

public class IdGenerator implements Callable<String> {
    @Override
    public String call() /*throws Exception*/ {
        return UUID.randomUUID().toString();
    }
}
