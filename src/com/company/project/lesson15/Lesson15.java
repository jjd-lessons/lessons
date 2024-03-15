package com.company.project.lesson15;

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

        for (String string : arrayList) {
            System.out.println(string);
        }








    }

    public static void v1(List<String> list){}
    public static void v2(ArrayList<String> list){}
}
