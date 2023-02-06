package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] array = new Item[size];
        int i = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                array[i] = items[index];
                i++;
            }
        }
        return array;
    }

    public Item[] findByName(String key) {
        Item[] array = new Item[items.length];
        int i = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && items[index].getName().equals(key)) {
                array[i] = items[index];
                i++;
            }
        }
        array = Arrays.copyOf(array, i);
        return array;
     }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}