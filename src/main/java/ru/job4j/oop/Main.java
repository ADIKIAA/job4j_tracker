package ru.job4j.oop;

public class Main {

    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle plane = new Plane();
        Vehicle[] array = new Vehicle[] {bus, train, plane};
        for (Vehicle a : array) {
            a.move();
            a.passengers();
        }
    }
}
