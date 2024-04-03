package com.company.project.lesson23.strategy;

public class RunFast implements IAction<Unit>{
    @Override
    public void execute(Unit unit) {
        System.out.println("unit RunFast");
    }
}
