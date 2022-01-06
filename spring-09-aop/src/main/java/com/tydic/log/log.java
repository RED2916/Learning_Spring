package com.tydic.log;

import java.lang.reflect.Method;

public class log {
//    //难以使用
//    public void before(Method method, Object[] args, Object target) throws Throwable {
//        System.out.println(target.getClass().getName()+"的"+method.getName()+"被执行了");
//    }
    public void before(){
        System.out.println("========Before===========");
    }
    public void after(){
        System.out.println("========After===========");
    }
}
