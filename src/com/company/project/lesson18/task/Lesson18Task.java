package com.company.project.lesson18.task;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lesson18Task {

    /*public static void v1(List<Task> taskList){
        // выводить названия задач,
        // пока не встретится задача с названием,
        // начинающимся на "asd"
        Consumer<Task> taskConsumer = task -> {
            System.out.println(task.getTitle());
            if (task.getTitle().startsWith("asd")) return;
        };
        for (Task task : taskList) {
            taskConsumer.accept(task);
        }
        taskList.forEach(task -> {
            System.out.println(task.getTitle());
            if (task.getTitle().startsWith("asd")) return;
        });

        for (Task task : taskList) {
            System.out.println(task.getTitle());
            if (task.getTitle().startsWith("asd")) return;
        }
    }*/


    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();



        // Задание №1
        // удалить задачи методом removeIf,
        // если они были созданы более месяца назад
        // и закрыты (статус CLOSED)

        // Задание №2
        // Перебрать список методом forEach,
        // вывести в консоль только открытые задачи,
        // которые нужно было завершить к текущему моменту

        // Задание №3
        // Перебрать список методом forEach,
        // вывести в консоль только задачи,
        // которые попадают в заданный диапазон дат

        // Задание №4
        // Написать реализацию Function,
        // которая принимает на вход список задач,
        // и возвращает список с названиями
        // выполненных задач
        // в отсортированном по дате завершения виде



    }



}
