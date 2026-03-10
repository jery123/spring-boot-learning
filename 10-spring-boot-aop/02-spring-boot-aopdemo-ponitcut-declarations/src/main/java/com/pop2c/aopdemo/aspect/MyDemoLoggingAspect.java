package com.pop2c.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.stereotype.Component;

@Aspect
@Component
@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class MyDemoLoggingAspect {

    // Creating the Poincut expression
    @Pointcut("execution(* com.pop2c.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    // Match on method within the specified package
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    }

    // New advice
    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
}
