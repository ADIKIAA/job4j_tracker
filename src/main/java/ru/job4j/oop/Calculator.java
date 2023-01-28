package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperation(int d) {
        return (this.sum(d) + this.multiply(d) + this.divide(d));
    }

    public int multiply(int a) {
        return x * a;
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        System.out.println(minus(7));
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide(20));
        System.out.println(calculator.sumAllOperation(5));
    }
}
