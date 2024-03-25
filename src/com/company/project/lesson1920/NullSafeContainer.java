package com.company.project.lesson1920;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

// NullSafeContainer<String> s01 = new NullSafeContainer("231");
// NullSafeContainer<Integer> s02 = s01.map();
public class NullSafeContainer<T> {
    private T value;

    public NullSafeContainer(T value) {
        this.value = value;
    }

    public <U> NullSafeContainer<U> map(Function<? super T, ? extends U> mapper)
    {
        Objects.requireNonNull(mapper);
        if (value == null) {
            return new NullSafeContainer<>(null);
        } else {
            return new NullSafeContainer<>(mapper.apply(value));
        }
    }

    public T getValueOr(Supplier<T> supplier){
        if (value != null) return value;
        return supplier.get();
    }

    public void ifExists(Consumer<T> consumer, Runnable runnable){
        if (value != null) consumer.accept(value);
        else runnable.run();
    }
}
