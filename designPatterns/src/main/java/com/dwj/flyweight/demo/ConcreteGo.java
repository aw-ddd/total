package com.dwj.flyweight.demo;

//具体围棋实现（具体享元角色）
public class ConcreteGo implements Go {

    private  String color;

    public ConcreteGo(String color){
        this.color = color;
    }

    public void getGo(Position position) {
        System.out.println("这是一个"+color+"的围棋");
        System.out.println("它的位置是在"+position);
    }
}
