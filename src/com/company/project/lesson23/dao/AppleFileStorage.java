package com.company.project.lesson23.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class AppleFileStorage implements IStorage<Apple,Long> {
    private String fileName;

    public AppleFileStorage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Apple> getAll() throws IOException {
        List<String> stringList = Files.readAllLines(Paths.get(fileName));

        /*List<Apple> apples = new ArrayList<>();
        for (String string : stringList) {
            String[] str = string.split(";");
            apples.add(
                    new Apple(Long.parseLong(str[0]),
                            str[1],
                            Double.parseDouble(str[2]))
            );
        }*/
        return Files.lines(Paths.get(fileName))
                .map(string -> {
                    String[] str = string.split(";");
                    return new Apple(Long.parseLong(str[0]),
                            str[1],
                            Double.parseDouble(str[2]));
                }).toList();
    }

    @Override
    public Apple getById(Long aLong) throws IOException {
        return null;
    }

    @Override
    public void add(Apple apple) {
        // id;цвет;вес
        String appleString = apple.id() + ";" +
                apple.color() + ";" +
                apple.weight();
    }

    @Override
    public void remove(Apple apple) {

    }
}
