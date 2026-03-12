package com.pop2c.aopdemo.dao;

import com.pop2c.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;


    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
        return true;
    }

    public String getName() {
        System.out.println("getName() called");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName() called");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("getServiceCode() called");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("setServiceCode() called");
        this.serviceCode = serviceCode;
    }
}
