package ru.job4j.oop;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println("Движется по воздуху.");
    }

    @Override
    public void passengers() {
        System.out.println("Вместимость 110 пассажиров.");
    }
}
