package com.company.project.lesson18;

import com.company.project.lesson10.lessontask.task03.Gallery;
import com.company.project.lesson10.lessontask.task03.Image;
import com.company.project.lesson14.properties.vehicle.Car;
import com.company.project.lesson14.properties.vehicle.Repaintable;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lesson18 {
    private int version;
    private Image image;

    public void v1(int number, Car car){
        int a = 90;
        Gallery gallery = new Gallery();

        Operation operation = (a1, b1) -> {
            // Доступ из lambda:
            // 1. Из lambda доступны для чтения: свойства, объявленные в классе
            // и локальные переменные метода (в т.ч. аргументы метода).
            System.out.println(version);
            System.out.println(image);
            System.out.println(number);
            System.out.println(car.getColor());

            // 2. Для записи доступны только свойства, объявленные в классе.
            version += 1;
            image = new Image();
            // локальные переменные для lambda - effective final (как final не объявлены,
            // но менять их значения нельзя)
            // number = 90;
            // car = new Car(Repaintable.Color.GOLD, "01");
            // можно обратиться по ссылке и изменить объект
            car.changeColor(Repaintable.Color.RED);

            // 3. Затенять можно только свойства, объявленные в классе.
            // int number = 90;
            Image image = new Image(); // затенение свойств

            return a1 + b1;
        };
    }


    public static void main(String[] args) {
         /*
         Лямбда синтаксис позволяет
         создать класс, реализующий функциональный интерфейс и
         его экземпляр в несколько строчек кода.
         */

        /*
         Функциональный интерфейс - интерфейс, который содержит один абстрактный и
         любое количество default и static методов.
         Принято добавлять аннотацию @FunctionalInterface.
         @FunctionalInterface - аннотация времени компиляции, компилятор сообщит об ошибке,
         если в интерфейсе будет объявлено больше одного абстрактного метода.
         */

        /*
        @FunctionalInterface
        public interface InterfaceName<T> {
            T abstractMethod(T firstArg, T secondArg);
        }

         Лямбда синтаксис:
         1. создаёт анонимный класс, имплементирующий InterfaceName
         2. реализация абстрактного метода: (str01, str02) -> (str01 + str02).toUpperCase()
         3. создаёт экземпляр данного класса
         InterfaceName<String> object = (str01, str02) -> (str01 + " " + str02).toUpperCase();

         Далее можно обратиться к object, как к обычному объекту,
         вызвать доступные методы (всегда определены интерфейсом)
         String str = object.abstractMethod("lambda", "java 8");

        Можно объявить любое количество реализаций
        InterfaceName<String> object01 = (str01, str02) -> str01.toUpperCase() + ": " + str02.toLowerCase();
        InterfaceName<Integer> object02 = (int01, int02) -> {
            if (int01 > 0) return int01 + int02;
            return int01 - int02;
        };
        */

        /*
        Лямбда выражение состоит из:
        1. стрелка -> - лямбда
        2. слева от -> - аргументы, которые принимает абстрактный метод интерфейса
        3. справа от -> - тело метода
        */

        /*
        Аргументы:
        1. если метод не принимает на вход аргументы или принимает 2 и более аргументов,
        они ДОЛЖНЫ указываться в () скобках;
        2. если метод принимает на вход 1 аргумент, () скобки МОЖНО опустить;
        3. типы данных аргументов компилятор берет из контекста (абстрактного метода функционального интерфейса)
        */

        /*
        Тело метода и возвращаемое значение:
        1. если тело метода состоит из одной инструкции, его МОЖНО не оборачивать в {} скобки;
        2. если тело метода состоит из нескольких инструкции, оно ДОЛЖНО оборачиваться в {} скобки;
        3. если тело метода не оборачивается в {} скобки, то метод неявно возвращает результат (return не пишем);
        4. если тело метода оборачивается в {} скобки, то для возврата результата необходимо явно указать return
        5. тип возвращаемого значения или void компилятор берет из контекста (абстрактного метода функционального интерфейса)
         */

        /*
        Функциональные интерфейсы, объявленные в java, находятся в пакете java.util.function:
        java.util.function.Consumer;
        java.util.function.Supplier;
        java.util.function.Function;
        java.util.function.UnaryOperator;
        java.util.function.BiFunction;
        java.util.function.BinaryOperator;
        java.util.function.Predicate;
        java.util.function.BiPredicate;

        java.util.function.Predicate;
        java.util.function.Consumer;
        java.util.function.Supplier;
        java.util.function.Function;

         и 43 50 227
         */

        Operation plus01 = (first, second) -> first + second;
        System.out.println(plus01.action(34, 89.9));

        Operation plus02 = (first, second) -> {
            System.out.println(first + second);
            return first + second;
        };
        System.out.println(plus02.action(456.9, 90));

        // java.util.function
        int price = 80; // "80 руб."
        // написать реализацию Function, которая принимает
        // на вход целое число
        // и возвращает строку: переданное число руб.

        Function<Integer, String> intToStr =
                integer -> integer + " руб.";

        System.out.println(intToStr);
        System.out.println(intToStr.apply(price));

        price = 100;
        // написать реализацию Predicate, которая принимает
        // на вход целое число
        // и возвращает true, если число положительное,
        // в остальных случаях - false

        Predicate<Integer> isPositive = x -> x > 0;
        Predicate<Integer> isNegative = x -> x < 0;
        Predicate<Integer> isZero = x -> x == 0;
        Predicate<Integer> predicate = isNegative.or(isZero);
        Predicate<Integer> predicate02 = isNegative.and(isZero);

        if (predicate.test(10)){}
        if (isNegative.test(10) || isZero.test(10)){}


        // IPay pay01 = (amount) -> ...; boolean makePayment
        // IPay pay02 = (amount) -> ...; boolean makePayment
        // IPay pay03 = (amount) -> ...; boolean makePayment
        // IPay pay = pay01
        //          .additionalPay(pay02)
        //          .additionalPay(pay03);
        /*
        if (pay.makePayment(100)) {
            System.out.println("Оплата прошла успешно");
        } else {
            System.out.println("Оплата не была завершена");
        }
        */
        // Predicate<String> cond02 = str -> ...;
        // Predicate<String> cond03 = str -> ...;
        // Notification notif01 = (message) -> ...;
        // Notification notif02 = (message) -> ...;
        // Notification notif03 = (message) -> ...;
        // Notification notification = notif01.add(notif02, cond02)
        //                     .add(notif03, cond03);
        // notification.send("Сообщение");
        // метод abstract send - отправка сообщения
        // метод default add - создает Notification,
        // которым будет отправляться сообщение,
        // если оно прошло проверку переданным условием


        // Написать NullSafeContainer<T>
        // для хранения значения T типа
        //
        // реализовать следующие методы:
        // 1. getValueOr(Supplier<T> supplier) -
        // возвращает хранимое в контейнере значение
        // или результат, возвращаемый supplier,
        // если в контейнере null ссылка

        // 2. ifExists(Consumer<T> consumer, Runnable runnable) -
        // выполняет действие consumer над значением,
        // хранимым в контейнере
        // или действие runnable, если в контейнере null ссылка


    }



}
