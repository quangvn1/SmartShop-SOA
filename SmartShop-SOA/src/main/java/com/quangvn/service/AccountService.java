/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quangvn.service;

import com.quangvn.beans.Account;
import com.quangvn.dao.AccountDao;

/**
 *
 * @author quangvn
 */
public class AccountService {

    private AccountService() {
    }

    public static AccountService getInstance() {
        return AccountServiceHolder.INSTANCE;
    }

    private static class AccountServiceHolder {

        private static final AccountService INSTANCE = new AccountService();
    }

    public Account checkAccount(Account account) {
        return AccountDao.getInstance().checkAccount(account);
    }
}
