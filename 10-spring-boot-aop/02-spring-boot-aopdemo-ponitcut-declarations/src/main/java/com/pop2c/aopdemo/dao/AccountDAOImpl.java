package com.pop2c.aopdemo.dao;

import com.pop2c.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;


    @Override
    public List<Account> findAccounts() {
       return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // for academic purposes ... simulate an exception
        if(tripWire){
            throw new RuntimeException("Trip wire activated!!!");
        }
        List<Account> accounts = new ArrayList<>();

        // create a sample account
        Account ac1 = new Account("John", "VIP");
        Account ac2 = new Account("Henri", "PLATINUM");
        Account ac3 = new Account("Sarah", "GOLD");

        // add them to our account list
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);

        return accounts;
    }

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
