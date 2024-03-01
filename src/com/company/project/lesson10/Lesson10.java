package com.company.project.lesson10;

import java.util.Arrays;

public class Lesson10 {
    public static void main(String[] args) {
        Box box01 = Box.init2Box(10); // new Box(12, 67, 20);
        Box box02 = Box.randomBox(); // new Box(30, 30, 30);
        Box box03 = Box.init2Box(100); // new Box(100, 110, 120);

        box02.grow(2, 6, 9);
        box03.grow(10, 10, 10);

        // box01.incNumberOfBoxes();
        // box01.incNumberOfBoxes();

        // System.out.println(box03.getNumberOfBoxes());
        Box.incNumberOfBoxes();
        Box.incNumberOfBoxes();
        Box.incNumberOfBoxes();

        System.out.println(Box.getNumberOfBoxes());

        Orange orange01 = Orange.getOrange(true, 300);
        Orange orange02 = Orange.getOrange(false, 100);
        System.out.println(orange01 == orange02); //
        System.out.println(orange02.getPrice()); // 300
    }
}
