package com.company.project.lesson11.task.animals;

import java.util.Arrays;
import java.util.Objects;


public class Wolf extends WildAnimal{
    private final String[] likeToEat;
    private final String color;

    public Wolf(String[] likeToEat, String color) {
        this.likeToEat = likeToEat;
        this.color = color;
    }

}
