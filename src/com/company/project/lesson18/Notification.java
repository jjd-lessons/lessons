package com.company.project.lesson18;

import java.util.function.Predicate;

public interface Notification {
    void send(String message);

    default Notification add(Notification second,
                             Predicate<String> condForMessage){
        return message -> {
            send(message);
            if (condForMessage.test(message)) second.send(message);
        };

    }
}
