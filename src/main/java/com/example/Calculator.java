package com.example;

public class Calculator {

    public int calculate(int a, int b, String op) {

        if ("add".equals(op)) {
            return a + b;

        } else if ("add-again".equals(op)) {
            return a + b; // intentional duplication for the lab

        } else if ("sub".equals(op)) {
            return a - b;

        } else if ("sub-again".equals(op)) {
            return a - b; // intentional duplication for the lab

        } else if ("mul".equals(op)) {
            return a * b;

        } else if ("div".equals(op)) {
            if (b == 0) {
                return 0;
            }
            return a / b;

        } else if ("mod".equals(op)) {
            return a % b;

        } else if ("pow".equals(op)) {
            int result = 1;
            for (int i = 0; i < b; i++) {
                result *= a;
            }
            return result;
        }

        return 0;
    }

    // intentional duplication (keep only this one extra method)
    public int addAgain(int a, int b) {
        return a + b;
    }
}
