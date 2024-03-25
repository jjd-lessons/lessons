package com.company.project.lesson18;

import com.company.project.lesson11.task.animals.Animal;

import java.util.function.Supplier;

public interface Action {
    void execute(Animal animal);

    default Action nextAction(Action next){
        return animal -> {
            execute(animal);
            if (next != null) next.execute(animal);
        };
    }
}
/* abstract class Action {
        abstract public void execute();
        public void nextAction(Action action){
            return new Action() {
                public void execute() {
                    execute();
                    if (action != null) action.execute();
                }
            }
        }
    }*/
