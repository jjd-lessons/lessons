package lesson02;

// однострочный комментарий - ctrl + /
/*
многострочный
комментарий
*/

/**
 * документирование
 * кода
 */
// переименовать пакет -
// ПКМ на пакете -> Refactor -> Rename
// переименовать класс + файл -
// ПКМ на файле -> Refactor -> Rename
public class DataTypes /* Lesson02DataTypes */ { // класс...

    public static void main(String[] args) {
        // Ctrl + Alt + L
        System.out.println("Вывод данных в консоль");

        // Объявление переменных
        // типДанных имяПеременной;
        int userAge;
        int width, height;

        // инициализация переменной
        // значение присваивается первый раз
        userAge = 79;
        width = 100;
        height = 187;

        // переопределили значение
        userAge = 80;

        // инициализация в момент объявления
        int numberOfColors = 3;
        int numberOfFruits = 10, numberOfVegetables = 11;

        // примитивные и ссылочные типы

        // Примитивные типы:
        // 1. целочисленные:
        // 1.1 byte (1байт -128 +127)
        // 1.2 short (2байта -32768 +32767)
        // 1.3 int (4байта)
        // 1.4 long (8байт)
        // 2. числа с плавающей точкой:
        // 2.1 float (4байта) BigDecimal для вычислений
        // 2.2 double (8байта) BigDecimal для вычислений
        // 3. логический boolean
        // принимает 2 значения true или false
        // 4. символьный тип char (2байта)
        // 0 65535 / 'о' / 'u0000'

        byte byteFromFile = 56;
        short numberOfLessons = 150;
        long millis = 334, age = 8_000_000_000L;
        float temp = 35.88F; // или 35.88f
        double maxTemp = 335.88;

        // объявление переменных через var (java 10)
        // только локальные переменные методов
        // необходимо инициализировать при объявлении
        // для определения типа данных по значению
        var classVersion = 10; // int
        var bigValue = 10L; // long
        var count = (short) 358; // short
        var readByte = (byte) 100; // byte
        var balance = 100.5; // double
        var numberOfHours = 15.6F; // float
        var isActive = true; // boolean

        isActive = false;
        System.out.println(isActive);

        // нельзя объявить несколько переменных
        // с одинаковым именем
        // в рамках одной область видимости (фигурные скобки)

        // арифметические операторы
        // +
        // "34" + "45" -> "3445"
        // 1 + 3 -> 4
        // -
        // 2 - 1 -> 1
        // -3
        // *
        // 4 * 0 -> 0
        // /
        // 50 / 0 -> ???
        // 50.0 / 0.0 -> ???
        // % --- ДЗ

        int int01 = 10;
        int zeroInt = 0;
        // целочисленное деление на 0 - исключение времени выполнения
        // java.lang.ArithmeticException
        // System.out.println(int01 / zeroInt);


        double double01 = -10.0;
        double zeroDouble = 0.0;
        // деление чисел с плавающей точкой на 0 - Infinity
        System.out.println(double01 / zeroDouble);

        // результат целочисленного деления -
        // целое число, остаток будет отброшен
        int num01 = 3;
        int num02 = 2;
        int result = num01 / num02;
        // при необходимости сохранения остатка,
        // один из операндов приводится в double или float
        double doubleResult = (double) num01 / num02;

        // результат арифметических операций с byte и short
        // всегда повышается до int
        // результат вычислений всегда повышается до наибольшего операнда
        // byte - short - int - long - float - double

        // приведение типов
        // автоматическое
        byte byteValue = 1;
        int intValue = byteValue;
        // явное (тип)
        short shortValue = (short) intValue;


















    }
}
// JavaDevelopmentKit (JDK):
// классы,
// JavaVirtualMachine (JVM): интерпретатор,
// компилятор, отладчик

// JavaRuntimeEdition (JRE):
// классы,
// JavaVirtualMachine (JVM): интерпретатор

// исходный код в файлах *.java ->
// компилятор ->
// байткод в файлах *.class ->
// интерпретатор ->
// выполнение инструкций

