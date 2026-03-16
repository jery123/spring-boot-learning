package com.pop2c.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    // New advice
    @Before("com.pop2c.aopdemo.aspect.LuvAopExpression.forDaoPackageAndNotGetterOrSetter()")
    public void logToCloudAsync() {
        System.out.println("\n=====>>> Logging to cloud async");
    }


}
