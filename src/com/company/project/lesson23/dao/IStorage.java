package com.company.project.lesson23.dao;

import java.io.IOException;
import java.util.List;

// единый интерфейс хранения данных
// T - тип хранимого объекта
// ID - тип уникального идентификатора хранимого объекта
public interface IStorage<T, ID> {
    List<T> getAll() throws Exception; // получить все объекты
    T getById(ID id) throws Exception; // получить объект по уникальному идентификатору
    void add(T t) throws Exception; // сохранить объект
    void remove(T t) throws Exception; // удалить объект
}
