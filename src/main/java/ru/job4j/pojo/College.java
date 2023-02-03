package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Nikolai");
        student.setGroup("CTM-14");
        student.setCreated(new Date());
        System.out.println(student.getName());
        System.out.println(student.getGroup());
        System.out.println(student.getCreated());
    }
}
