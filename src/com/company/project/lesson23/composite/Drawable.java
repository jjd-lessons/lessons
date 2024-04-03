package com.company.project.lesson23.composite;

abstract public class Drawable { // общий тип для простых и сложных объектов
    protected String title;

    public Drawable(String title) {
        this.title = title;
    }

    abstract void draw();
}
