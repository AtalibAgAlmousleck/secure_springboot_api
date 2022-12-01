package com.almousleck.apiapplication.service;

import com.almousleck.apiapplication.model.Account;

import java.util.List;

public interface AccountService {
    // create account
    Account createAccount(Account account);
    // find account by username
    Account findByUsername(String username);
    // Accounts
    List<Account> getAccounts();
}
