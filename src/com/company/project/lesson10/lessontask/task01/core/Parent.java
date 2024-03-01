package com.company.project.lesson10.lessontask.task01.core;

public class Parent {
    public int void1(){ // можно вызвать
        return 1;
    }

    private String void2(){
        return "";
    }

    public final boolean void3() { // можно вызвать
        return Math.random() < .5;
    }

    protected char void4(){ // можно вызвать
        return ' ';
    }

    int random(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }
}