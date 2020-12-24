package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Главный сервис Банка
 */
public class BankService {
    /**
     * поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод добавляет пользователя в систему
     * @param user пользователь, которого добавляют в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * метод добавляет новый счет пользователю
     * @see #findByPassport(String) вначале пользователя нужно найти по паспорту,
     * для этого используется этот метод
     * @param passport паспорт пользователя
     * @param account добавляемый новый счет пользователя
     */
    public void addAccount(String passport, Account account) {
        Optional<User> userToFind = findByPassport(passport);
        if (userToFind.isPresent()) {
            if (!users.get(userToFind.get()).contains(account)) {
                users.get(userToFind.get()).add(account);
            }
        }
    }

    /**
     * метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта
     * @return возвращает Optional с пользователем или пустой Optional
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * метод ищет счет пользователя по реквизитам
     * @see #findByPassport(String) ищет пользователя
     * @param passport паспорт пользователя
     * @param requisite реквизиты пользователя
     * @return возвращает Optional с пользователем или пустой Optional
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> userByReq = findByPassport(passport);
        if (userByReq.isPresent()) {
            rsl = users.get(userByReq.get()).stream()
                    .filter(x -> x.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
    }

    /**
     * метод для перечисления денег с одного счёта на другой счёт
     * @param srcPassport паспорт пользователя, со счета которого переводят
     * @param srcRequisite реквизиты счета пользователя, с которого переводят
     * @param destPassport паспорт пользователя, которому переводят
     * @param destRequisite реквизиты счета пользователя, которому переводят
     * @param amount сумма перевода
     * @return если счёт не найден или не хватает денег на счёте srcAccount,
     * то метод возвращает false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> accountSrcTransfer = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDestTransfer = findByRequisite(destPassport, destRequisite);
        if (accountSrcTransfer.isPresent()
                && accountSrcTransfer.get().getBalance()
                >= amount && accountDestTransfer.isPresent()) {
            accountSrcTransfer.get().setBalance(accountSrcTransfer.get().getBalance() - amount);
            accountDestTransfer.get().setBalance(accountDestTransfer.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}