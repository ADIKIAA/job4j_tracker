package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-7, 2, 3, -3, 19, 0, -34, 5, 6, -5);
        List<Integer> positive = numbers.stream().filter(x -> x > 0).collect(toList());
        positive.forEach(System.out::println);
    }
}
