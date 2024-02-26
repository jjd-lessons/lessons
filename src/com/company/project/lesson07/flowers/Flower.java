package com.company.project.lesson07.flowers;

public class Flower {
    private int id;
    private String name;

    public Flower(int id, String name) {
        setId(id);
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("id - положительное число");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
