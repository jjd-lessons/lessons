package com.company.project.lesson11.task;


import com.company.project.lesson11.task.images.Drawable;
import com.company.project.lesson11.task.images.Editor;
import com.company.project.lesson11.task.images.Gallery;
import com.company.project.lesson11.task.images.Image;

public class Task11 {
    public static void main(String[] args) {
        Image treeImage = new Image("tree.png");
        Image grassImage = new Image("grass.png");
        Image lakeImage = new Image("lake.png");

        Image foxImage = new Image("fox.png");

        Gallery forestGallery = new Gallery("Forest", new Drawable[]{treeImage, grassImage, lakeImage});
        Gallery forestAndAnimalGallery = new Gallery("Forest and Animal", new Drawable[]{forestGallery, foxImage});

        Editor editor = new Editor(forestAndAnimalGallery);


    }
}
