package com.company.project.lesson25;

import java.io.*;
import java.util.ArrayList;

public class Lesson25 {
    public static void main(String[] args) {
        Rate full = new Rate(1, Rate.RateType.FULL);

        Trader trader = new Trader(1, new ArrayList<>(), full,
                "qwerty", "12345", "email");

        Item item01 = new Item(1, "Стол", 12000, trader);
        Item item02 = new Item(2, "Диван", 78000, trader);
        Item item03 = new Item(3, "Стул", 4500, trader);
        Item item04 = new Item(4, "Люстра", 9300, trader);

        trader.addItem(item01);
        trader.addItem(item02);
        trader.addItem(item03);
        trader.addItem(item04);

        // write(trader);
        Trader traderFromFile = read();



    }

    public static <T> void write(T t) {
        try (FileOutputStream fileOutput =
                     new FileOutputStream("file.bin", true);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)){

            objectOutput.writeObject(t);

        } catch (FileNotFoundException e){
            System.out.println("Проблема с файлом");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Проблема сериализации или записи в файл");
            throw new RuntimeException(e);
        }
    }

    public static <T> T read(){
        try (FileInputStream fileInput = new FileInputStream("file.bin");
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)){

            return (T) objectInput.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

