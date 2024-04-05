package com.company.project.lesson23.dao;

import java.util.ArrayList;
import java.util.List;

public class BuildingInMemoryStorage implements IStorage<Building,String> {
    private ArrayList<Building> buildings = new ArrayList<>();

    @Override // наличие исключения в методе интерфейса
    // не обязывает реализации его выбрасывать
    public List<Building> getAll() {
        return null;
    }

    @Override
    public Building getById(String string) {
        return null;
    }

    @Override
    public void add(Building building) {

    }

    @Override
    public void remove(Building building) {

    }
}