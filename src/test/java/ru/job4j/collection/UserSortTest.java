package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserSortTest {

    @Test
    public void testUserDescByName() {
        List<User> actual = new ArrayList<>();
        actual.add(new User("German", 45));
        actual.add(new User("Tom", 17));
        actual.add(new User("Roy", 26));
        actual.add(new User("Artem", 30));
        actual.sort(new UserDescByName());

        List<User> expected = new ArrayList<>();
        expected.add(new User("Artem", 30));
        expected.add(new User("German", 45));
        expected.add(new User("Roy", 26));
        expected.add(new User("Tom", 17));

        assertEquals(actual, expected);
    }

    @Test
    public void testUserDescByNameLn() {
        List<User> actual = new ArrayList<>();
        actual.add(new User("German", 45));
        actual.add(new User("Tom", 17));
        actual.add(new User("Roy", 26));
        actual.add(new User("Artem", 30));
        actual.sort(new UserDescByNameLn());

        List<User> expected = new ArrayList<>();
        expected.add(new User("Tom", 17));
        expected.add(new User("Roy", 26));
        expected.add(new User("German", 45));
        expected.add(new User("Artem", 30));

        assertEquals(actual, expected);
    }

    @Test
    public void testUserDescByPriority() {
        List<User> actual = new ArrayList<>();
        actual.add(new User("German", 45));
        actual.add(new User("Tom", 17));
        actual.add(new User("Roy", 26));
        actual.add(new User("Artem", 30));
        actual.sort(new UserDescByPriority());

        List<User> expected = new ArrayList<>();
        expected.add(new User("Tom", 17));
        expected.add(new User("Roy", 26));
        expected.add(new User("Artem", 30));
        expected.add(new User("German", 45));

        assertEquals(actual, expected);
    }

    @Test
    public void testUserDescByPriorityLn() {
        List<User> actual = new ArrayList<>();
        actual.add(new User("German", 45));
        actual.add(new User("Tom", 17));
        actual.add(new User("Roy", 26));
        actual.add(new User("Artem", 30));
        actual.sort(new UserDescByPriorityLn());

        List<User> expected = new ArrayList<>();
        expected.add(new User("German", 45));
        expected.add(new User("Artem", 30));
        expected.add(new User("Roy", 26));
        expected.add(new User("Tom", 17));

        assertEquals(actual, expected);
    }

    @Test
    public void testUserDescByNameThenUserDescByPriority() {
        List<User> actual = new ArrayList<>();
        actual.add(new User("Ivan", 45));
        actual.add(new User("Ivan", 17));
        actual.add(new User("Roy", 26));
        actual.add(new User("Artem", 30));
        actual.sort(new UserDescByName().thenComparing(new UserDescByPriority()));

        List<User> expected = new ArrayList<>();
        expected.add(new User("Artem", 30));
        expected.add(new User("Ivan", 17));
        expected.add(new User("Ivan", 45));
        expected.add(new User("Roy", 26));

        assertEquals(actual, expected);
    }

    @Test
    public void testUserDescByNameLnThenUserDescByPriorityLn() {
        List<User> actual = new ArrayList<>();
        actual.add(new User("Ivan", 45));
        actual.add(new User("Ivan", 17));
        actual.add(new User("Roy", 26));
        actual.add(new User("Artem", 30));
        actual.sort(new UserDescByNameLn().thenComparing(new UserDescByPriorityLn()));

        List<User> expected = new ArrayList<>();
        expected.add(new User("Roy", 26));
        expected.add(new User("Ivan", 45));
        expected.add(new User("Ivan", 17));
        expected.add(new User("Artem", 30));

        assertEquals(actual, expected);
    }
}
