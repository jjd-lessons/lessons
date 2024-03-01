package com.company.project.lesson10.lessontask.task03;

public class Editor {
    // должен иметь возможность отрисовки
    // отдельного изображения или целой галереи
    private Paintable paintable;

    public Editor(Paintable paintable) {
        this.paintable = paintable;
    }

    public void setPaintable(Paintable paintable) {
        this.paintable = paintable;
    }
    public void show(){
        paintable.draw();
    }
}
