package com.SpringBoot.Advice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAspect {

    @Before("execution(* add*())")
    public void addAccount() {
        System.out.println("===> Executing @Before aspect");
    }
}
