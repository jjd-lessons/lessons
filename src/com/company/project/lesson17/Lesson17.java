package com.company.project.lesson17;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lesson17 {
    public static void main(String[] args) {

        // интерфейс Map<KeyType, ValueType>
        // предоставляет набор методов для работы с ассоциациями: ключ - значение
        // одному ключу всегда соответствует только одно значение
        // ключи не могут дублироваться
        // порядок хранения ключей и связанных с ними значений зависит от конкретных реализаций
        // есть возможность получения: set ключей, collection значений, set пар (ключ+значение)

        // Реализации:
        // 1. HashMap<KeyType, ValueType>
        // неупорядоченная по ключам ассоциация
        // позволяет использовать null в качестве ключа
        // реализована на основе hash таблицы

        // 2. LinkedHashMap<KeyType, ValueType>
        // упорядоченная по ключам ассоциация
        // позволяет использовать null в качестве ключа
        // реализована на основе hash таблицы

        // 3. EnumMap<KeyTypeEnum, ValueType>
        // использует только элементы перечислений в качестве ключей
        // хранит только массив значений
        // при создании экземпляра необходимо передавать ссылку на класс перечисления

        // 4. TreeMap<KeyType, ValueType>
        // хранит пары в отсортированном по ключам виде
        // для KeyType должен быть определен натуральный порядок сортировки или
        // в конструктор TreeMap необходимо передать экземпляр Comparator

        // 5. WeakHashMap<KeyType, ValueType>
        // неупорядоченная по ключам ассоциация
        // реализована на основе hash таблицы
        // очищается сборщиком, когда на ключи не остаётся сильных ссылок

        // Функциональные интерфейсы + lambda, Stream API, Collectors API

        HashMap<String, Integer> customers = new HashMap<>();
        customers.put("Москва", 790);
        customers.put("Ростов", 300);
        customers.put("Новгород", 210);
        System.out.println(customers.size()); // 3
        customers.put("Ростов", 290);
        System.out.println(customers.size()); // 3
        customers.put(null, 1000);
        customers.put("Самара", 530);
        customers.put("СПб", null);
        System.out.println(customers.size());

        // удаление
        customers.remove(null); // 1000
        customers.remove(null); // null
        customers.remove("СПб"); // null
        customers.remove("СПб"); // null

        customers.remove("Ростов", 300); // false
        customers.remove("СПб", null); // false

        // замена
        // если ключ существует, заменит значение,
        // вернет новое значение
        customers.put("Ростов", 290);
        // если ключ существует, заменит значение,
        // вернет старое значение или null, если ключ отсутствует в мапе
        customers.replace("Самара", 940); // вернет старое значение
        customers.replace("Самара", 940, 944); // true

        // получение (не удаление) значения по ключу
        System.out.println(customers.get("Москва")); // 790
        System.out.println(customers.get("СПб")); // null

        Integer spbValue = customers.getOrDefault("СПб", -1);
        if (spbValue == null || spbValue == -1)
            System.out.println("Информация о городе отсутствует");
        else System.out.println(spbValue);

        if (customers.containsKey("Ростов")) {
            System.out.println("Ключ присутствует в мапе");
            int newValue = customers.get("Ростов") * 2;
            customers.replace("Ростов", newValue);
        }

        if (customers.containsValue(1000)) {
            System.out.println("Количество покупателей 1000 содержится в мапе");
        }

        // коллекция значений
        Collection<Integer> values = customers.values();
        // множество ключей
        Set<String> keys = customers.keySet();
        // множество пар
        Set<Map.Entry<String, Integer>> pairs = customers.entrySet();

        for (Map.Entry<String, Integer> pair : pairs) {
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());

            if (pair.getValue() > 1000) {
                System.out.println("В городе " + pair.getKey() +
                        " более 1000 покупателей");
            }
        }
        // customers.forEach(); - итерация по entrySet()

        // Задача после перерыва:
        // Написать static метод, который принимает на вход
        // `HashMap<String, Integer> map` и `int max`,
        // и возвращает список городов,
        // где количество покупателей меньше `max`.


    }
}
