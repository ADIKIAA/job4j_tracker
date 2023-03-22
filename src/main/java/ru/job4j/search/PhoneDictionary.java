package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> person = new ArrayList<>();

    public void add(Person person) {
        this.person.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
         Predicate<Person> byName = p -> p.getName().contains(key);
         Predicate<Person> bySurname = p -> p.getSurname().contains(key);
         Predicate<Person> byPhone = p -> p.getPhone().contains(key);
         Predicate<Person> byAddress = p -> p.getAddress().contains(key);
         Predicate<Person> combine = byName.or(bySurname).or(byPhone).or(byAddress);
        for (Person p : person) {
            if (combine.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}
