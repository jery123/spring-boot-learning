package com.pop2c.aopdemo.aspect;

import com.pop2c.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class MyDemoLoggingAspect {

    // Add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.pop2c.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n============> Executing the @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n============> Result is: " + result);

        // let's post-process the data ... let'smodify it :-)

        // convert the account names to uppercase
        converAccountNamesToUpperCase(result);
        
        System.out.println("\n============> Result is: " + result);

    }

    private void converAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for (Account theAccount: result) {

            // get uppercase version of name
            String theUpperName = theAccount.getName().toUpperCase();

            // update the name on the account
            theAccount.setName(theUpperName);
        }
    }

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
