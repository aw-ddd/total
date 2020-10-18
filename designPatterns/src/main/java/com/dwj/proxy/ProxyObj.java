package com.dwj.proxy;


//代理对象
public class ProxyObj implements Subject {
    private RealObj realObj;

    public void show() {
        if (realObj == null) {
            realObj = new RealObj();
        }
        preShow();
        realObj.show();
        afterShow();
    }

     private void preShow() {
        System.out.println("在执行代理对象之前的操作");
    }

    private void afterShow() {
        System.out.println("在代理对象执行完之后的善后操作");
    }
}
