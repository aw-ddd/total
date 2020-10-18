package com.dwj.proxy;

//真实对象
public class RealObj implements Subject{

    public void show() {
        System.out.println("这是一个真实对象！！！");
    }

}
