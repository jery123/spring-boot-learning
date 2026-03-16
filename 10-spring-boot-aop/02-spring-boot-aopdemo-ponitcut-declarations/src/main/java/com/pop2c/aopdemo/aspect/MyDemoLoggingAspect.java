package com.pop2c.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class MyDemoLoggingAspect {

    // Match on method within the specified package
    @Before("com.pop2c.aopdemo.aspect.LuvAopExpression.forDaoPackageAndNotGetterOrSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    }

}
