package com.company.project.lesson23.chain;

public class Unit { // использует цепочки обработчиков
    public void move(IAction action){ // реализованные через абстрактный класс
        action.execute();
    }
}