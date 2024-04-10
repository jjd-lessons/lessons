package com.company.project.lesson24.ioapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson24 {
    public static ArrayList<String> readWithFilesToStream(String filename)
            throws IOException {
        // ресурс закрывается, когда закрывается Stream
        try (Stream<String> lines = Files.lines(Path.of(filename))) {
            return lines.collect(Collectors.toCollection(ArrayList::new));
        }
    }

    public static void writeWithFiles(String filename, String data)
            throws IOException {
        // запись строки
        Files.writeString(Paths.get(filename), data,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }
    public static void main(String[] args) {
        String string = "Слово";
        String string2 = "Опять";
        Set<String> strings = Set.of(string, string2);
        List<String> listString;
        try (Stream<String> lines = Files.lines(Path.of("C:/Java_Education/ITMO/Lessons/src/com/smirnov/project/lesson25/FileTask1"))) {
            listString = new ArrayList<>(lines.collect(Collectors.toList()));
        }
        System.out.println(listString);
        System.out.println(calculate(strings, listString));

        for (String s : listString) {
            Files.writeString(Paths.get("Result"), s,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        }
    }

    public static Map<String, Integer> calculate(Set<String> strings, List<String> liststring) {
        Map<String, Integer> stingAndNum = new HashMap<>();
        Set<String> strings1=new HashSet<>();
        for (String string : strings) {
            strings1.add(string.toLowerCase());
        }
        for (String string : liststring) {
            String[] arrString = string.toLowerCase().split(" ");
            Arrays.stream(arrString)
                    .filter(sLocal -> strings1.contains(sLocal.toLowerCase()))
                    .forEach(sLocal -> stingAndNum.put(sLocal, stingAndNum.getOrDefault(sLocal, 0)+1));
        }
        return stingAndNum;
    }




}
