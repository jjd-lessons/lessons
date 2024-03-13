package com.company.project.lesson14.properties;

import com.company.project.lesson14.properties.service.RepairShop;
import com.company.project.lesson14.properties.service.Service;
import com.company.project.lesson14.properties.vehicle.*;

import java.util.LinkedList;

public class GenericProperties {
    public static void main(String[] args) {
        User<String> stringUser = new User<>("34rr");
        stringUser.setId(stringUser.getId().toLowerCase());

        User<Number> integerUser = new User<>(1.5);
        integerUser.setId(integerUser.getId().intValue());

        // необработанный / сырой / raw тип
        User rawUser = new User("12");
        // User<Object> rawUser = new User<>("12");
        rawUser.setId(12);
        rawUser.setId(stringUser);
        System.out.println(rawUser.getId().toString());

        // 1. Объявить класс `PairContainer` со свойствами`key` и `value`.
        // `key` и `value` - разные generic типы

        // 2. Создать экземпляр `PairContainer`,
        // где key - строка,
        // value - тип User, у которого id - любые числа



        PairContainer<String, User<Number>> pairContainer =
                new PairContainer<>();



        // Типизированные свойства с ограничениями
        Train train01 = new Train("train01", 7, false);
        Car car01 = new Car(Repaintable.Color.ORANGE, "car01");
        Bus bus01 = new Bus("bus01");
        MiniCar mini01 = new MiniCar(Repaintable.Color.BLUE, "mini01");

        RepairShop<MiniCar> repairShop = new RepairShop<>(mini01);

        // 1. public class Service<T extends Vehicle & Repaintable> {}
        // 2. поэтому в <> можно указать тип, который является типом Vehicle и типом Repaintable,
        // плюс любых его подтипов. В данном случае только Car и MiniCar отвечают данным требованиям:
        // Car extends Vehicle implements Repaintable {}
        // MiniCar extends Car {}
        // 3. в качестве generic свойства можно передать тип указанный в <> и все его подтипы

        Service<Car> service01 = new Service<>(car01); // car01 или mini01
        Service<Car> service02 = new Service<>(mini01); // car01 или mini01
        Service<MiniCar> service03 = new Service<>(mini01); // только mini01
        Service<Vehicle> service04 = new Service<>();

        Car[] arr01 = new Car[12];
        Vehicle[] arr02 = new Car[12];

        // инвариантность
        // v00(service04);

        // контрвариантность
        // v01(service01);
        v01(service04);

        // ковариантность
        v01(arr01);
        v01(arr02);

        // полиморфизм
        v01(train01);
        v01(mini01);
    }
    public static void v00(Service<Car> vehicleService){}
    public static void v01(Service<Vehicle> vehicleService){}
    public static void v01(Vehicle[] vehicles){
        vehicles[0] = null;
        vehicles[1] = new Train("train01", 7, false);
    }

    public static void v01(Vehicle vehicle){}
}
