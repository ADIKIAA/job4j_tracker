package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHbmTest {

    @AfterEach
    public void deleteAllItems() throws Exception {
        try (var tracker = new HbmTracker()) {
            var items = tracker.findAll();
            for (Item item : items) {
                tracker.delete(item.getId());
            }
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItemByName() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            List<Item> result = tracker.findByName(item.getName());
            assertThat(result).contains(item);
        }
    }

    @Test
    public void whenAddSomeItemThenDeleteOne() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            Item item2 = new Item();
            item.setName("test11");
            item2.setName("t229");
            tracker.add(item);
            tracker.add(item2);
            tracker.delete(item2.getId());
            Item result = tracker.findById(item2.getId());
            assertThat(result).isNull();
        }
    }

    @Test
    public void whenAddSomeItemsThenFindAll() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item();
            Item item2 = new Item();
            Item item3 = new Item();
            item1.setName("test1");
            item2.setName("test2");
            item3.setName("test3");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            List<Item> expected = List.of(item1, item2, item3);
            List<Item> result = tracker.findAll();
            assertThat(result).isEqualTo(expected);
        }
    }

    @Test
    public void whenAddSameThenFindHimByName() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item();
            Item item2 = new Item();
            item1.setName("test1");
            item2.setName("test2");
            tracker.add(item1);
            tracker.add(item2);
            List<Item> result = tracker.findByName("test2");
            assertThat(result).containsExactly(item2);
        }
    }

    @Test
    public void whenAddSameThenFindHimById() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item();
            Item item2 = new Item();
            item1.setName("test1");
            item2.setName("test2");
            tracker.add(item1);
            tracker.add(item2);
            Item result = tracker.findById(item1.getId());
            assertThat(result).isEqualTo(item1);
        }
    }

}