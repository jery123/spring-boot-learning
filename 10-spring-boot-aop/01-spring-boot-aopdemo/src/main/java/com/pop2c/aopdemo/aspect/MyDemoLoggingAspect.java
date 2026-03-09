package com.pop2c.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.stereotype.Component;

@Aspect
@Component
@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice



    /*@Before("execution(public void updateAccount())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n======> Executing @Before advice on method <======");

    }*/

    // Apply the @Before on any addAccount method
    /*@Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    }*/


    // Apply the @Before on addAccount method in AccountDAO class only
    /*@Before("execution(public void com.pop2c.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    }*/


    // Apply the @Before on any method starting with add
   /* @Before("execution(public void add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    }*/


    // Apply the @Before on any method starting with add and with a return type of void
    /*@Before("execution(void add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    }*/


    // Apply the @Before on any method starting with add and with any return type
    /*@Before("execution(* add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    }*/

    // Apply the @Before on any method starting with add and with any return type, having param of Account
    /*@Before("execution(* add*(com.pop2c.aopdemo.Account))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    }*/

    // Match method with `Account` parameter follow by more param types
    /*@Before("execution(* add*(com.pop2c.aopdemo.Account, ..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    }*/

    // Match on method with any parameter
    @Before("execution(* add*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    }
}
