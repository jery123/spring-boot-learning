package com.pop2c.aopdemo.aspect;

import com.pop2c.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
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
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n======> Executing @Before advice on addAccount() <======");
    
        // display the method signature
        MethodSignature methodsmethodsignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodsmethodsignature);

        // display the method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // lopp through args
        for (Object arg : args) {
            System.out.println("Arg: " + arg);

            if(arg instanceof Account){

                // downcast and print Account specific stuff
                Account theAccount = (Account) arg;
                System.out.println("Account Name: " + theAccount.getName());
                System.out.println("Account Level: " + theAccount.getLevel());
            }
        }

    }

}
