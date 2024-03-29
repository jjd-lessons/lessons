package com.company.project.lesson21.tasks.task01;

import java.time.LocalDateTime;
import java.util.Set;

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

    public enum Priority{
        URGENT, HIGH, MEDIUM, LOW
    }
}