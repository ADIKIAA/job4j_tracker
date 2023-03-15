package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель банковской системы, в которой можно производить следующие действия
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя могут быть несколько банковский счетов
 * 4. Переводить деньги с одного банковского счета на другой счет.
 * @author Nick
 * @version 1.0
 */
public class BankService {
    /**
     * Хранения пользователей и их счетов осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляющий пользователя в систему, если его еще нет в системе.
     * Добавляет к этому пользователю пустой список ArrayList<Account>,
     * в который будут помещаться банковские счета пользователя.
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод позволяет удалить пользователя из системы.
     * @param passport номер и серия пасспорта
     * @return
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод позволяет добавить новый счет пользователю.
     * Новый счет будет добавлен если  такой пользователь есть в системе и
     * этот счет уже не был создан.
     * @param passport серия и номер пасспорта
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод позволяет найти пользователя в системе по серии и номеру пасспорта.
     * Если пользователя нет в системе будет возвращен null.
     * @param passport серия и номер пасспорта
     * @return пользователь
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                rsl = u;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод позволяет найти банковский счет пользователя по его пасспорту и реквизиту счета.
     * Если не найден пользователь или его счет будет возвращен null.
     * @param passport серия и номер пасспорта
     * @param requisite реквизит счета
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account rsl = null;
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                }

            }
        }
        return rsl;
    }

    /**
     * Метод предназначет для перечисления денег с одного счета на другой счет.
     * Если счет не найден или на счете, с которого переводят, недостаточно денег,
     * то метод вернет false
     * @param srcPassport серия и номер пасспорта пользователя который переводит
     * @param srcRequisite реквизиты счета с которого переводят
     * @param destPassport серия и номер пасспорта пользователя которому переводят
     * @param destRequisite ревизиты счета на который переводят
     * @param amount сумма перевода
     * @return
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() - amount >= 0) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает список всех счетов пользователя, в виде коллекции ArrayList<Account>
     * @param user пользователь
     * @return список всех счетов пользщователя, в виде коллекции ArrayList<Account>
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
