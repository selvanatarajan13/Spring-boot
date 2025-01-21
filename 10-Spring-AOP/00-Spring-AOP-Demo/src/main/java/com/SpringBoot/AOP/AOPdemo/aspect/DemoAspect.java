package com.SpringBoot.AOP.AOPdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

    @Before("execution(* add*())")
    public void demoAspect() {
        System.out.println("\n ===> Executing Before() advice on method");
    }
}
