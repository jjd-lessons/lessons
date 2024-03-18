package com.company.project.lesson1516;

import com.company.project.lesson14.properties.vehicle.Vehicle;

import java.util.Comparator;

public class VehicleComparators {
    public static class LevelOfWareComparator // levelOfWare - int
            implements Comparator<Vehicle> {

        // < 0 - о1 меньше о2
        // > 0 - о1 больше о2
        // == 0 - о1 равен о2
        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            // чем больше уровень износа, тем меньше объект
            return o2.getLevelOfWare() - o1.getLevelOfWare();
        }
    }

    public static class NumberComparator
            implements Comparator<Vehicle> { // number - String
        @Override // по алфавиту с учетом регистра
        public int compare(Vehicle o1, Vehicle o2) {
            return o1.getNumber().compareTo(o2.getNumber());
        }
    }
}

// VehicleComparators.LevelOfWareComparator ageComp =
//      new VehicleComparators.NumberComparator();

