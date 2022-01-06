package com.tydic.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component //失效
@Aspect
public class AnnotationLog {
    @Before("execution(* com.tydic.pojo.iF1Impl.*(..))")
    public void before(){
        System.out.println("========Before===========");
    }
    @After("execution(* com.tydic.pojo.iF1Impl.*(..))")
    public void after(){
        System.out.println("========After===========");
    }
}
