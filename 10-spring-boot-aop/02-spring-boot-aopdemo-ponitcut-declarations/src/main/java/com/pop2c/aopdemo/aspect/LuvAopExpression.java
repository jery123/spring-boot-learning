package com.pop2c.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpression {

    // Creating the Poincut expression
    @Pointcut("execution(* com.pop2c.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    // create a poincut for getter methods
    @Pointcut("execution(* com.pop2c.aopdemo.dao.*.get*(..))")
    public void forDaoGetter() {}


    // create a poincut for setter methods
    @Pointcut("execution(* com.pop2c.aopdemo.dao.*.set*(..))")
    public void forDaoSetter() {}

    // create poincut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(forDaoGetter() || forDaoSetter())")
    public void forDaoPackageAndNotGetterOrSetter() {}


}
