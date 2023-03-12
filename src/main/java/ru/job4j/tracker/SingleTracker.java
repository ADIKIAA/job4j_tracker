package ru.job4j.tracker;

import java.util.List;
public final class SingleTracker {

    private Tracker tracker = new Tracker();

    private static SingleTracker instance = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String name) {
        return tracker.findByName(name);
    }

    public boolean deleteItem(int id) {
        return tracker.delete(id);
    }

    public boolean editItem(int id, Item item) {
        return tracker.replace(id, item);
    }

    public List<Item> showAll() {
        return tracker.findAll();
    }
}
