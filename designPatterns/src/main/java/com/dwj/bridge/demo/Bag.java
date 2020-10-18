package com.dwj.bridge.demo;

//抽象化
public abstract class Bag {
    protected Color color;

    protected Bag(Color color){
        this.color = color;
    }

    public abstract void getBag();
}
