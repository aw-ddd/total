package com.dwj.adapter.demo;

//电能发动机（使用类适配器模式）
public class Electric extends Car implements Motor{
    public void drive() {
        System.out.println("使用电能发动机！");
        run();
    }
}
