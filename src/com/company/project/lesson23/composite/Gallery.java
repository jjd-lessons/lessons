package com.company.project.lesson23.composite;

import java.util.ArrayList;

public class Gallery extends Drawable{ // составные/сложные объекты - контейнеры
    private ArrayList<Drawable> drawables = new ArrayList<>();

    public Gallery(String title) {
        super(title);
    }

    public void add(Drawable drawable) {
        drawables.add(drawable);
    }

    @Override
    void draw() {
        System.out.println("Gallery: " + title.toUpperCase());
        for (Drawable drawable : drawables) {
            drawable.draw();
        }
        System.out.println("--------");
    }
}
