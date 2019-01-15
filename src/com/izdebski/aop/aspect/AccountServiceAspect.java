package com.izdebski.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountServiceAspect {

    @Pointcut("execution(* com.izdebski.service.impl.AccountServiceImpl.*(..))")
    public void selectAll(){

    }

    @Before(value= "execution(* com.izdebski.service.impl.AccountServiceImpl.*(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("Before method:"+joinPoint.getSignature().getName()+",Class:"+joinPoint.getTarget().getClass().getSimpleName());
    }

    @After(value = "selectAll()")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("After method:"+joinPoint.getSignature().getName()+",Class:"+joinPoint.getTarget().getClass().getSimpleName());
    }
}