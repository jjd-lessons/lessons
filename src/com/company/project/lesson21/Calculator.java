package com.company.project.lesson21;

import com.company.project.lesson18.Operation;

public class Calculator {
    private Operation operation = Double::sum;

    public Calculator(){}

    public Calculator(Operation operation) {
        this.operation = operation;
    }
    public void calculate(double a, double b){
        System.out.println(operation.action(a, b));
    }
}