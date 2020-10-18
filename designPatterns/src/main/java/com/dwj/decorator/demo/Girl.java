package com.dwj.decorator.demo;

//具体装饰者角色
public class Girl extends Changer{

    public Girl(Morrigan morrigan) {
        super(morrigan);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("变成美少女！！！！！！！！！");
    }
}
