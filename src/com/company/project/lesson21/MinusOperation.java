package com.company.project.lesson21;

import com.company.project.lesson18.Operation;

public class MinusOperation implements Operation {
    @Override
    public double action(double a, double b) {
        return a - b;
    }
}
