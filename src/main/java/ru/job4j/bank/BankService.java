package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User userToFind = findByPassport(passport);
        if (userToFind != null && !users.get(userToFind).contains(account)) {
            users.get(userToFind).add(account);
        }
    }

    public User findByPassport(String passport) {
        User userByPassport = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                userByPassport = user;
                break;
            }
        }
        return userByPassport;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account accountByReq = null;
        User userByReq = findByPassport(passport);
        if (userByReq != null) {
            for (Account account : users.get(userByReq)) {
                if (account.getRequisite().equals(requisite)) {
                    accountByReq = account;
                }
            }
        }
        return accountByReq;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accountSrcTransfer = findByRequisite(srcPassport, srcRequisite);
        if (accountSrcTransfer != null && accountSrcTransfer.getBalance() > 0) {
            List<Account> accounts = new ArrayList<>();
            accounts.add(new Account(destRequisite, 0.00));
            users.putIfAbsent(new User(destPassport, "username"), accounts);
            accountSrcTransfer.setBalance(accountSrcTransfer.getBalance() - amount);
            findByRequisite(destPassport, destRequisite).setBalance(findByRequisite(destPassport, destRequisite).getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}















