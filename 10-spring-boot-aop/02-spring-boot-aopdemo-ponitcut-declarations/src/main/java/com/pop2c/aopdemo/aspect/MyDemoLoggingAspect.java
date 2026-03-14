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

    // create a poincut for getter methods
    @Pointcut("execution(* com.pop2c.aopdemo.dao.*.get*(..))")
    private void forDaoGetter() {}


    // create a poincut for setter methods
    @Pointcut("execution(* com.pop2c.aopdemo.dao.*.set*(..))")
    private void forDaoSetter() {}

    // create poincut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(forDaoGetter() || forDaoSetter())")
    private void forDaoPackageAndNotGetterOrSetter() {}

    // Match on method within the specified package
    @Before("forDaoPackageAndNotGetterOrSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    }

    // New advice
    @Before("forDaoPackageAndNotGetterOrSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
}
