package com.company.project.lesson23;

abstract public class Command {
    private String code;

    public Command(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    abstract void execute(Storage storage);
}
