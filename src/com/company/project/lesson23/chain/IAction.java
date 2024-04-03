package com.company.project.lesson23.chain;

public interface IAction { // вместо абстрактного класса
    void execute(); // вместо abstract void execute();
    default IAction next(IAction action){ // вместо Action nextAction(Action next) + void doAction()
        return () -> {
            execute();
            if (action != null) action.execute(); // возможны варианты, когда метод следующего в цепочке обработчика,
            // вызывается только при определенных условиях
        };
    }
}
