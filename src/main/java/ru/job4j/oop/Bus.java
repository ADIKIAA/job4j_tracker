package ru.job4j.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Движется по дороге.");
    }

    @Override
    public void passengers() {
        System.out.println("Вместимость 25 пассажиров.");
    }
}
