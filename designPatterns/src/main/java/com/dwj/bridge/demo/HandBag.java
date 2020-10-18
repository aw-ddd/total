package com.dwj.bridge.demo;

//扩展抽象化实现
public class HandBag extends Bag{

    protected HandBag(Color color) {
        super(color);
    }

    public void getBag() {
        color.getColor();
        System.out.println("这是个挎包");
    }
}
