package com.dwj.decorator.demo;

//抽象装饰者角色
public class Changer implements Morrigan{
    private Morrigan morrigan;

    public Changer(Morrigan morrigan){
        this.morrigan = morrigan;
    }

    public void display() {
        morrigan.display();
    }
}
