package com.dwj.prototype.expand;


public class Test {

    public static void main(String[] args) {
        //当一个对象需要被频繁创建时，可以原型模式快速创建该对象
        ProtoTypeManager manager = new ProtoTypeManager();
        Shape circle = manager.getShape("circle");
        circle.calculation();
    }
}
