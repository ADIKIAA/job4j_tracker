package ru.job4j.oop;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println("Движется по рельсам.");
    }

    @Override
    public void passengers() {
        System.out.println("Вместимость 150 пассажиров.");
    }
}
