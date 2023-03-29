package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int rsl = o2.toString().substring(0, 2).compareTo(o1.toString().substring(0, 2));
        if (rsl == 0) {
           rsl = o1.toString().substring(2).compareTo(o2.toString().substring(2));
        }
        return rsl;
    }
}
