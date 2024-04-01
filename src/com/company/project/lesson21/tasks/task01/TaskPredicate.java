package com.company.project.lesson21.tasks.task01;

import java.util.function.Predicate;

@FunctionalInterface
public interface TaskPredicate
        extends Predicate<Task> {
}
