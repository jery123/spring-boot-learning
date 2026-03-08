package com.pop2c.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
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
    @Before("execution(public void com.pop2c.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    }
}
