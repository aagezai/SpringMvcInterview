package com.InterviewCompleteJavaSpring.AOP_For_Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop_For_Logger_Class {
    private static final Logger LOGGER = LoggerFactory.getLogger(Aop_For_Logger_Class.class);

    @Before("execution(* com.facebooked.demofacebooked.SpringSecurity*.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        LOGGER.info("Before executing: " + joinPoint.getSignature().toShortString());
    }

    @After("execution(* com.facebooked.demofacebooked.SpringSecurity*.*(..))")
    public void logAfterMethodExecution(JoinPoint joinPoint) {
        LOGGER.info("After executing: " + joinPoint.getSignature().toShortString());
    }


/*    @Around("execution(* com.facebooked.demofacebooked..*(..))")
    public Object logAroundMethodExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("Before executing (around): " + proceedingJoinPoint.getSignature().toShortString());
        Object result = proceedingJoinPoint.proceed();
        LOGGER.info("After executing (around): " + proceedingJoinPoint.getSignature().toShortString());
        return result;
    }*/
}

