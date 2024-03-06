package com.company.project.lesson12.exceptions;

import java.time.LocalDateTime;
// наследование от Exception - исключение времени компиляции
public class Lesson12Exception extends Exception {
    // message - описание причины генерации исключения
    public Lesson12Exception(String message) {
        super(message);
    }
    // message - описание причины генерации исключения
    // cause - исключение, которое стало причиной генерации Lesson12Exception
    public Lesson12Exception(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        // логика родительского getMessage + собственная
        return super.getMessage() + LocalDateTime.now();
    }
}
