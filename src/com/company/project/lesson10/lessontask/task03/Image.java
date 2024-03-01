package com.company.project.lesson10.lessontask.task03;

public class Image implements Paintable{
    private String name;
    private String path;
    private String contentType;
    private int size;

    @Override
    public void draw() {
        System.out.println(name);
    }
    // хранит данные об изображении, в т.ч ссылку на файл
    // функционал - метод отрисовки изображения (sout(название изображения))
}
