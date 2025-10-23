package com.InterviewCompleteJavaSpring.AOP_For_Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop_For_Logger_Class {
    private static final Logger LOGGER = LoggerFactory.getLogger(Aop_For_Logger_Class.class);

    @Before("execution(* com.facebooked.demofacebooked.SpringSecurity..*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        LOGGER.info("Before executing: " + joinPoint.getSignature().toShortString());
    }

    @After("anySpringSecurityMethod()")
    public void logAfterMethodExecution(JoinPoint joinPoint) {
        LOGGER.info("After executing: " + joinPoint.getSignature().toShortString());
    }
    //"execution(* com.facebooked.demofacebooked.SpringSecurity*.*(..))" with out subpackage under package springSecuity only
    @Pointcut("execution(* com.facebooked.demofacebooked.SpringSecurity..*(..))")// for any subpackage and all classes and method with any parameters
    private void anySpringSecurityMethod() {}



/*    @Around("execution(* com.facebooked.demofacebooked..*(..))")
    public Object logAroundMethodExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("Before executing (around): " + proceedingJoinPoint.getSignature().toShortString());
        Object result = proceedingJoinPoint.proceed();
        LOGGER.info("After executing (around): " + proceedingJoinPoint.getSignature().toShortString());
        return result;
    }*/
}

