package com.dwj.flyweight.demo;

public class Test {
    public static void main(String[] args) {
        GoFactory factory = new GoFactory();
        //获取一个白色的棋子
        Go go = factory.getConcreteGo("白");
        go.getGo(new Position("上"));
        go.getGo(new Position("下"));
    }
}
