package bxc.jdkproxy;

import bxc.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MeiPo implements InvocationHandler {

    //JDK动态代理所有对象
    private Object target;

    public Object getInstance(Object target)
    {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();
        Object object = method.invoke(this.target, args);
        after();
        return object;
    }

    private void before()
    {
        System.out.println("JDK动态代理，前置操作");
    }

    private void after()
    {
        System.out.println("JDK动态代理，后置操作");
    }
}
