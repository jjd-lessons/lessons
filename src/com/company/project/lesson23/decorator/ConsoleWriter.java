package com.company.project.lesson23.decorator;

public class ConsoleWriter implements AppLogger{ // основной функционал
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
