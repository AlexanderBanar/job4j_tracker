package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User userToFind = findByPassport(passport);
        if (userToFind != null && !users.get(userToFind).contains(account)) {
            users.get(userToFind).add(account);
        }
    }

    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(x -> x.getPassport().equals(passport))
                .findFirst().orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User userByReq = findByPassport(passport);
        if (userByReq != null) {
            rsl = users.get(userByReq).stream()
                    .filter(x -> x.getRequisite().equals(requisite))
                    .findFirst().orElse(null);
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrcTransfer = findByRequisite(srcPassport, srcRequisite);
        Account accountDestTransfer = findByRequisite(destPassport, destRequisite);
        if (accountSrcTransfer != null
                && accountSrcTransfer.getBalance() >= amount && accountDestTransfer != null) {
            accountSrcTransfer.setBalance(accountSrcTransfer.getBalance() - amount);
            accountDestTransfer.setBalance(accountDestTransfer.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}