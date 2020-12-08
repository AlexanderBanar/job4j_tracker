package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> userToFind = findByPassport(passport);
        if (userToFind.isPresent()) {
            if (!users.get(userToFind.get()).contains(account)) {
                users.get(userToFind.get()).add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst();
    }

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

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> accountSrcTransfer = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDestTransfer = findByRequisite(destPassport, destRequisite);
        if (accountSrcTransfer.isPresent()
                && accountSrcTransfer.get().getBalance() >= amount && accountDestTransfer.isPresent()) {
            accountSrcTransfer.get().setBalance(accountSrcTransfer.get().getBalance() - amount);
            accountDestTransfer.get().setBalance(accountDestTransfer.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}