package com.dwj.decorator.demo;

//具体装饰角色
public class Succubus extends Changer{

    public Succubus(Morrigan morrigan) {
        super(morrigan);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("变成女妖！！！");
    }
}
