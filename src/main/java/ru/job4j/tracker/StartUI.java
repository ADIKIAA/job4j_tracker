package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item timeAndDate = new Item();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String formatDateAndTime = timeAndDate.getCreated().format(format);
        System.out.println(formatDateAndTime);
    }
}
