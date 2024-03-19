package com.test.java.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        BaseImpl base = new BaseImpl();
        // Proxy 动态代理实现
        BaseInterface proxyInstance = (BaseInterface) Proxy.newProxyInstance(base.getClass().getClassLoader(),
                base.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("doSomething")) {
                            System.out.println("do start.");
                            method.invoke(base, args);
                            System.out.println("do end.");
                        }
                        return null;
                    }
                });

        proxyInstance.doSomething();
    }
}

// 定义相关接口
interface BaseInterface {
    void doSomething();
}

// 接口的相关实现类
class BaseImpl implements BaseInterface {
    @Override
    public void doSomething() {
        System.out.println("doSomething.");
    }
}
