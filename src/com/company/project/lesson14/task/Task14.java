package com.company.project.lesson14.task;

import com.company.project.lesson14.properties.PairContainer;
import com.company.project.lesson14.properties.vehicle.*;

public class Task14 {

    public static <T extends Vehicle, K extends T> K[] task01(T first, K second, Car car){
        // какие методы можно вызвать у second?
        // какие из аргументов можно добавить в массив, а какие нет и почему
        K[] arr = {};
        return arr;
    }

    public static void main(String[] args) {
        // Задание 1
        // какие типы можно указать в угловых скобках вместо ??? и
        // экземпляры каких классов передать?

        Task14.<Vehicle, ???>task01();
        Task14.<???, MiniCar >task01();
        Task14.<Train, ???>task01();

        // Задание 2
        // Написать метод, который принимает на вход массив чисел (использовать дженерик)
        // и возвращает PairContainer, где ключи - сумма четных элементов
        // значения - сумма нечетных элементов
    }
     public <T> PairContainer<Integer, T[]> bb(T[] elem){
        return new PairContainer<>()
     }
}
