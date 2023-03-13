package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int l = o1.length() - o2.length();
        String s = l < 0 || l == 0 ? o1 : o2;
        int rsl = 0;
        for (int i = 0; i < s.length(); i++) {
            rsl = Character.compare(o1.charAt(i), o2.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0 && l != 0) {
            rsl = l < 0 ? -1 : 1;
        }
        return rsl;
    }
}
