package com.company.project.lesson11.task.images;


public class Gallery implements Drawable {
    private String name;
    private Drawable[] drawables;

    public Gallery(String name, Drawable[] drawables) {
        this.drawables = drawables;
        this.name = name;
    }

    public Drawable[] getImages() {
        return drawables;
    }

    @Override
    public void draw() {
        System.out.println(name);
        for (Drawable drawable : drawables) {
            drawable.draw();
        }
    }

    @Override
    public Gallery clone() {
        Drawable[] drawablesNEW = new Drawable[drawables.length];
        Gallery gallery = new Gallery(this.name, drawablesNEW);
        for (int i = 0; i < drawablesNEW.length; i++) {
            // drawablesNEW[i] = drawables[i].clone();
            gallery.drawables[i] = drawables[i].clone();
        }
        return gallery;
    }
}
