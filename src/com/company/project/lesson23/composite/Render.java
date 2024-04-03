package com.company.project.lesson23.composite;

public class Render {
    private Drawable drawable;

    public Render(Drawable drawable) {
        this.drawable = drawable;
    }
    public void show(){ // работает с древовидной структурой
        drawable.draw(); // как с единым объектом
    }
}
