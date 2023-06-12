package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveTwoItemsAndDeleteFirst() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("first");
        Item second = new Item("second");
        tracker.add(first);
        tracker.add(second);
        tracker.delete(tracker.findByName("first").get(0).getId());
        assertThat(tracker.findAll()).doesNotContain(first).contains(second);
    }

    @Test
    public void whenSaveTwoAndReplaceSecond() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        tracker.add(first);
        tracker.add(second);
        tracker.replace(tracker.findByName("second").get(0).getId(), third);
        assertThat(tracker.findAll()).doesNotContain(second).contains(third);
    }

    @Test
    public void whenSaveTwoReplaceFirstDeleteAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        tracker.add(first);
        tracker.add(second);
        tracker.replace(tracker.findByName("first").get(0).getId(), third);
        assertThat(tracker.findAll()).containsExactly(third, second);
        tracker.delete(tracker.findByName("third").get(0).getId());
        tracker.delete(tracker.findByName("second").get(0).getId());
        assertThat(tracker.findAll()).hasSize(0);

    }

}