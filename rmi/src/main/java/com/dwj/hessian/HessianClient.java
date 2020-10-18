package com.dwj.hessian;

import com.caucho.hessian.client.HessianProxyFactory;

import java.net.MalformedURLException;

public class HessianClient {
    public static void main(String[] args) throws MalformedURLException {
        String url = "http://localhost:8080/rmi/helloworld";
        HessianProxyFactory factory = new HessianProxyFactory();
        //获取到RMI远程调用类，可以执行一些远程操作
        DemoApi demoApi = (DemoApi) factory.create(DemoApi.class, url);
        User user = demoApi.getUser();
        demoApi.setName("张三");
        String s = demoApi.sayHello();
        System.out.println(s);
        System.out.println(user);
    }
}