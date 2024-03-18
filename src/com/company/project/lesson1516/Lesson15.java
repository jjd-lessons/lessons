package com.company.project.lesson1516;

import com.company.project.lesson14.properties.vehicle.Car;
import com.company.project.lesson14.properties.vehicle.Repaintable;
import com.company.project.lesson14.properties.vehicle.Train;
import com.company.project.lesson14.properties.vehicle.Vehicle;

import java.util.*;

public class Lesson15 {
    public static void main(String[] args) {
        // List
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(arrayList.size()); // 0

        String[] cities = {"Саратов", "Тверь"};

        List<String> strings = Arrays.asList(cities);

        LinkedList<String> linkedList = new LinkedList<>(strings);
        System.out.println(linkedList.size()); // 2

        linkedList.add("Москва");
        linkedList.add("Тверь");

        HashSet<String> hashSet = new HashSet<>(linkedList);
        System.out.println(hashSet.size()); // 3

        // Саратов Тверь Москва
        arrayList.addAll(hashSet);
        arrayList.add("СПб");
        arrayList.add(null);
        arrayList.add("Самара");
        arrayList.add("Самара");

        arrayList.remove("Самара"); // boolean
        arrayList.remove(2); // E

        System.out.println(arrayList.get(4));

        arrayList.removeIf(element->"Самара".equals(element));

        // Перебор коллекций
        // 1. foreach - любая коллекция
        for (String string : arrayList) {
            System.out.println(string);
        }
        // 2. fori + while - только List
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        // 3. итератор
        Iterator<String> stringIterator = arrayList.iterator();
        while (stringIterator.hasNext()){
            String element = stringIterator.next();
            if (element == null) continue;
            System.out.println(element.toUpperCase());
            if ("Самара".equals(element)) stringIterator.remove();
        }

        // вызов метода remove в циклах (кроме итератора)
        // для однопоточных коллекций приведет
        // к ConcurrentModificationException
        // arrayList.removeIf(element->"Самара".equals(element));

        // arrayList
        TreeSet<String> citiesTreeSet = new TreeSet<>();
// добавить в citiesTreeSet не null ссылки из arrayList с городами
        for (String string : arrayList) {
            if (string != null) citiesTreeSet.add(string);
        }
        System.out.println(citiesTreeSet);

        TreeSet<User> userTreeSet = new TreeSet<>(); // User implements Comparable
        userTreeSet.add(new User(1, "Москва", 23));
        userTreeSet.add(new User(2, "СПб", 33));
        System.out.println(userTreeSet);

        Comparator<Vehicle> numberComparator =
                new VehicleComparators.NumberComparator();

        Comparator<Vehicle> levelOfWareComparator =
                new VehicleComparators.LevelOfWareComparator();

        Comparator<Vehicle> levelOfWareComparatorReversed =
                levelOfWareComparator.reversed();

        Comparator<Vehicle> levelOfWareAndNumberComparator =
                levelOfWareComparator.thenComparing(numberComparator);

        // Comparator<Vehicle> vehicleComparator = Comparator.comparing(()->{});

        TreeSet<Vehicle> vehicleTreeSet01 = new TreeSet<>(numberComparator);
        TreeSet<Vehicle> vehicleTreeSet02 = new TreeSet<>(levelOfWareComparatorReversed);

        TreeSet<Vehicle> vehicleTreeSet = new TreeSet<>(levelOfWareAndNumberComparator); // Comparator
        vehicleTreeSet.add(new Car(Repaintable.Color.BLACK, "01"));
        System.out.println(vehicleTreeSet);

        // Collections
        // UnmodifiableCollection ImmutableCollections
        List<Vehicle> vehiclesList = List.of(
                new Car(Repaintable.Color.GOLD, "02"),
                new Car(Repaintable.Color.GOLD, "03"),
                new Car(Repaintable.Color.GOLD, "04")
        );
        for (Vehicle vehicle : vehiclesList) {
            vehicle.repair();
        }

        ArrayList<Vehicle> vehicles = null;
        List<Car> cars  = null;
        HashSet<Train> trains = null;
        v3(vehicles);
        v3(cars);
        v3(trains);

    }

    public static void v3(Collection<? extends Vehicle> vehicleCollection){
        if (vehicleCollection == null) return;
        vehicleCollection.add(null /*new Car(Repaintable.Color.GOLD, "")*/);
        for (Vehicle vehicle : vehicleCollection) {
            if (vehicle.getLevelOfWare() > 10) vehicle.repair();
        }
    }
    public static void v1(List<String> list){}
    public static void v2(ArrayList<String> list){}
}
