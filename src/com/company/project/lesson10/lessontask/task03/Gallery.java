package com.company.project.lesson10.lessontask.task03;

public class Gallery extends Image{
    private String title;
    private Paintable[] paintables;

    @Override
    public void draw() {
        System.out.println(title);
        for (Paintable paintable : paintables) {
            paintable.draw();
        }
    } // галерея изображений
    // Хранит массивом отдельные изображения, галереи, галереи и отдельные изображения
    // Функционал - метод отрисовки элементов галереи
    // (sout(название галереи))
    // (sout(название изображений))
}
