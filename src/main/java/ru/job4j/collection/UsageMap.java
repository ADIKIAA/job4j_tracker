package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("123@mail.ru", "Иванов Иван Иванович");
        hm.put("1234@mail.ru", "Новиков Олег Олегович");
        hm.put("1234@mail.ru", "Новиков Олег Олегович");
        hm.put("1234@mail.ru", "Новиков Олег Олегович");
        hm.put("12@mail.ru", "Илюхин Артем Андреевич");
        for (Map.Entry<String, String> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
