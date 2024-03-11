package com.company.project.lesson11.task.images;


public class Image implements Drawable {
    private final String path;

    public Image(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public void draw() {
        System.out.println(path);
    }

    @Override
    public Image clone() {
        return new Image(this.path);
    }
}
