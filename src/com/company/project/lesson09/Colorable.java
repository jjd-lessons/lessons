package com.company.project.lesson09;

// можно использовать в качестве супертипа
// нельзя создать экземпляр
// не могут иметь не static свойств
// не могут иметь конструкторов
// могут наследоваться от других интерфейсов (множественное наследование разрешено)
public interface Colorable extends Runnable, Cloneable {

    // методы с реализацией могут быть default или static
    // должен быть реализован в классе,
    // если класс реализует несколько интерфейсов с одинаковыми default методами
    /* public по умолчанию */
    default String getColor() {
        return "red";
    }

    // абстрактные методы без реализации
    // должны быть реализованы в классе
    /* public abstract по умолчанию */
    void color(String color);

    /* public abstract по умолчанию */
    void setDefaultColor();
}
