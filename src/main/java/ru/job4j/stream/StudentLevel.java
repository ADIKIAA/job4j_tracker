package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {

    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(st ->  st != null)
                .sorted(Comparator.comparing(Student::getScore, (s1, s2) -> s2.compareTo(s1)))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
