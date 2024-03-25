package com.company.project.lesson1516.task;

// содержит информацию о фруктах,
// которые будут добавляться на склад

/*
public class FruitToStorageInfo {
    private final FruitType type;
    private double price; // за один фрукт
    private int count; // количество добавляемых фруктов

    // конструктор, принимающий значения всех свойств + проверки

    // доступные геттеры и сеттеры

    // equals + hashCode + toString
    public enum FruitType {
        APPLE, PEAR, BANANA, APRICOT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FruitToStorageInfo that = (FruitToStorageInfo) o;

        if (Double.compare(price, that.price) != 0) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type != null ? type.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

*/
