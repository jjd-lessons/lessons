package com.company.project.lesson23.chain;

public class Eat extends Action{
    @Override
    protected void execute(Animal animal) {
        System.out.println("Eat");
    }
}