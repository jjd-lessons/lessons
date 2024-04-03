package com.company.project.lesson23.chain;

public class Drink extends Action{
    @Override
    protected void execute(Animal animal) {
        System.out.println("Drink");
    }
}
