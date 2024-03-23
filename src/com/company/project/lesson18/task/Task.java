package com.company.project.lesson18.task;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String title;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime closeTo;

    // геттеры, сеттеры и д.т

    public enum Status{
        NEW, IN_PROGRESS, CLOSED
    }
}
