package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка
 * @author Nick
 * @version 1.0
 */
public class User {
    /**
     * Поле серия и номер паспорта
     */
    private String passport;
    /**
     * Поле ФИО пользователя
     */
    private String username;

    /**
     * Конструктор создания пользователя
     * инициализирует все поля
     * @param passport серия и номер пасспорта пользователя
     * @param username ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер возвращает серию и номер пасспорта пользователя
     * @return серия и номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер назначает серию и номер паспорта
     * @param passport серия и номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер возвращает ФИО пользователя
     * @return ФИО пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер назначает ФИО пользователя
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод equals
     * сравнивает двух пользователей только по серии и номеру пасспорта
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод hashCode
     * сравнивает двух пользователей только по серии и номеру пасспорта
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
