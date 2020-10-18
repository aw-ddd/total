package com.dwj.bridge.demo;

//扩展抽象化的实现
public class Wallet extends Bag{

    protected Wallet(Color color) {
        super(color);
    }

    public void getBag() {
        color.getColor();
        System.out.println("这是一个钱包");
    }
}
