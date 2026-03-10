package com.pop2c.aopdemo.dao;

import com.pop2c.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

}
