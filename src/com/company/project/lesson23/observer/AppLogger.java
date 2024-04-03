package com.company.project.lesson23.observer;

public class AppLogger implements Listener{ // конкретная реализация наблюдателя
    @Override
    public void execute(Connection connection) {
        System.out.println("Запись информации в файл");
    }
}
