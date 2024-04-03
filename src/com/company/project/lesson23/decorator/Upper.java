package com.company.project.lesson23.decorator;

public class Upper extends BaseDecorator { // дополнительный функционал (декоратор)

    public Upper(AppLogger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        // приведение к верхнему регистру, передача данных дальше (следующему декоратору или основному объекту)
        super.log(message.toUpperCase());
    }
}
