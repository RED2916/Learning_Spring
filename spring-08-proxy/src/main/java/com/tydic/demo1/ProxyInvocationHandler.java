package com.tydic.demo1;

import java.lang.reflect.*;
public class ProxyInvocationHandler implements InvocationHandler{
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 动态创建proxy
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
//        Object result = method.invoke(proxy,args);//target被Proxy修改，target才是目前的Proxy
        Object result = method.invoke(target,args);
        return result;
    }
    private void log(String methodName){
        System.out.println("loggging:"+methodName);
    }
}
