package com.company.project.lesson23.observer;

import java.util.ArrayList;

public class Connection {
    private ArrayList<Listener> listeners = new ArrayList<>();
    private Status status = Status.CLOSE;

    public void addListener(Listener listener){
        listeners.add(listener);
    }

    public void changeStatus(Status status) {
        this.status = status;
        listeners.forEach(listener -> {
            // if (listener.test(status)) {
                listener.execute(this);
            // }
        });
    }

    public Status getStatus() {
        return status;
    }

    public enum Status {
        ACTIVE, CLOSE, CONNECTED, WAITING
    }

}
