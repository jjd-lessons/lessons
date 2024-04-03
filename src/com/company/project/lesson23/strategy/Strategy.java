package com.company.project.lesson23.strategy;

public class Strategy {
    public static void main(String[] args) {
        // Стратегия инкапсулирует схожие действия в отдельные объекты
        // и позволяет взаимозаменять их во время выполнения программы
        // 1. у всех действий должен быть общий тип данных (абстрактный класс или интерфейс) - IAction
        // 2. абстрактном классе или интерфейсе предполагается наличие абстрактного метода
        // (или нескольких абстрактных методов) - void execute(T t);
        // 3. конкретные реализации (классы, описывающие действия) интерфейса или
        // наследники абстрактного класса должны реализовать абстрактные методы
        // в соответствии с логикой приложения - юнит бежит, идет, стоит
        // 4. Объект, который использует выбранную стратегию должен иметь:
        // 4.1 ссылку на ее экземпляр - private IAction<Unit> currentAction; в классе Unit
        // 4.2 возможность выбрать другую стратегию - void changeAction(IAction<Unit> currentAction) в классе Unit
        // 4.3 метод, который использует выбранную стратегию - void move() в классе Unit
        // 4.4 можно обойтись без хранения ссылки на определенную стратегию, тогда метод,
        // использующий стратегию должен принимать ссылку на нее - void move(IAction<Unit> currentAction) в классе Unit

        IAction<Unit> run = new Run();
        IAction<Unit> runFast = new RunFast();
        IAction<Unit> walk = new Walk();

        Unit tiger = new Unit(run);
        tiger.move();

        tiger.changeAction(walk);
        tiger.move();
        tiger.move();
        tiger.move();

        tiger.changeAction(runFast);
        tiger.move();

        tiger.changeAction(unit -> System.out.println("unit Eat"));

    }
}