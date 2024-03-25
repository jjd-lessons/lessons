package com.company.project.lesson1920;

import com.company.project.lesson09.Car;

import java.util.Optional;

public class Lesson19Optional {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable("data");

        String fromOptional = optional.orElse(null);

        if (fromOptional != null) System.out.println(fromOptional.toUpperCase());
        else System.out.println("Данные отсутствуют");

        if (optional.isPresent()) {
            String string = optional.get();
            System.out.println(string.toUpperCase());
        } else {
            System.out.println("Данные отсутствуют");
        }

        optional.ifPresentOrElse(
                data -> System.out.println(data.toUpperCase()),
                () -> System.out.println("Данные отсутствуют")
        );


        Optional<Car> vehicle = Optional.ofNullable(new Car("white", 180));
        Car car01 = vehicle.orElse(new Car("black", 230));
        Car car02 = vehicle.orElseGet(()->new Car("black", 230));





    }
}
