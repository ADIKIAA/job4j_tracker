package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {

    @Test
    public void testItemAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("z"));
        items.add(new Item("a"));
        items.add(new Item("t"));
        items.add(new Item("c"));
        Collections.sort(items, new ItemAscByName());

        List<Item> expected = new ArrayList<>();
        expected.add(new Item("a"));
        expected.add(new Item("c"));
        expected.add(new Item("t"));
        expected.add(new Item("z"));
        assertEquals(items, expected);
    }

    @Test
    public void testItemDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("z"));
        items.add(new Item("a"));
        items.add(new Item("t"));
        items.add(new Item("c"));
        Collections.sort(items, new ItemDescByName());

        List<Item> expected = new ArrayList<>();
        expected.add(new Item("z"));
        expected.add(new Item("t"));
        expected.add(new Item("c"));
        expected.add(new Item("a"));
        assertEquals(items, expected);
    }
}
