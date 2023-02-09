package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Коробка автомат. Поставить селектор в режим D.");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Вместимость " + passengers + " челоек.");
    }

    @Override
    public double refuel(int fuel) {
        return fuel * 14.3;
    }
}
