package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 * @author Nick
 * @version 1.0
 */
public class Account {
    /**
     * Поле реквизит счета
     */
    private String requisite;
    /**
     * Поле баланс
     */
    private double balance;

    /**
     * Конструктор создания нового банковского счета
     * инициализирует все поля
     * @param requisite рекизит
     * @param balance баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер возвращает реквизит счета
     * @return реквизит счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер назначает поле реквизит
     * @param requisite реквизит счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер возвращет баланс счета
     * @return баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер назначает баланс счета
     * @param balance баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Перепределенный метод equals
     * сравнивает банковские счета только по полю реквизит
     * @param o
     * @return true если счета одинаковы, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод hashCode
     * сравнивает банковские счета только по полю реквизит
     * @return true если счета одинаковы, иначе false
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}