package com.company.project.lesson15.task;

import java.util.List;
import java.util.Objects;

// склад содержит информацию о добавленных фруктах+
public class FruitStorage {
    // максимальное количество фруктов
    // заполняемость зависит не от количества переданных FruitToStorageInfo,
    // а от значения свойства count
    private int numberOfSlots;

    // коллекция fruits, для хранения экземпляров FruitToStorageInfo
    // TODO: КОЛЛЕКЦИЮ ВЫБРАТЬ САМОСТОЯТЕЛЬНО

    public FruitStorage(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    // TODO: НАПИСАТЬ РЕАЛИЗАЦИЮ СЛЕДУЮЩИХ МЕТОДОВ
    public boolean addToStorage(FruitToStorageInfo toStorageInfo){

        // Информация о фруктах добавляется в хранилище по следующим правилам:
        // 1. fruit не может быть null;
        // 2. fruit не может быть ссылкой на существующий элемент коллекции
        // 3. если в коллекции fruits уже есть фрукт с типом и ценой, как у toStorageInfo,
        //   увеличивать значение свойства count фрукта коллекции на значение свойства count toStorageInfo.
        //   В противном случае добавлять toStorageInfo в коллекцию fruits.
        //   numberOfSlots уменьшается на значение count добавляемого фрукта.
        // 4. в хранилище нельзя добавить больше numberOfSlots фруктов
        return false;
    }

    // вернуть количество фруктов определённого типа
    public int getNumberOfFruitsByType(FruitToStorageInfo.FruitType fruitType) {
        return 0;
    }

    // вернуть количество свободных мест в хранилище
    public int getNumberOfEmptySlots(){
        return 0;
    }

    public void increasePrice(int value){
        // value может быть в диапазоне [10; 30)
        // увеличить цену всех фруктов на value процентов
    }

    public List<FruitToStorageInfo> getFruitsByTypeAndPrice(FruitToStorageInfo.FruitType fruitType, int maxPrice) {
        // maxPrice должна быть положительной, fruitType не null
        // возвращает список, в который войдут фрукты из коллекции fruits
        // с типом fruitType и ценой не выше maxPrice
        return null;
    }

    public double getMinPriceByType(FruitToStorageInfo.FruitType fruitType){
        // вернуть минимальную цену фрукта с типом fruitType
        return 0;

    }


}
