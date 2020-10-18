package com.dwj.adapter.demo;

//光能发动机（使用对象适配器模式）
public class Optical implements Motor{

    private Car car;

    public Optical(Car car){
        this.car = car;
    }

    public void drive() {
        System.out.println("使用光能发动机！！！");
        car.run();
    }
}
