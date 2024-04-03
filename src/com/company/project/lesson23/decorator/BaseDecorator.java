package com.company.project.lesson23.decorator;

abstract public class BaseDecorator implements AppLogger{ // родительский класс декораторов
    private AppLogger logger; // ссылка на декоратор или основной функционал

    public BaseDecorator(AppLogger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        logger.log(message);
    }

}
