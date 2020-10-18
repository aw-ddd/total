package com.dwj.builder;

//具体的建造者
public class SpecificBuilder extends Builder {

    public void buildPartA() {
        Builder.product.setPartA("这是A部分的赋值！");
        System.out.println("创建Product的PartA部分");
    }

    public void buildPartB() {
        Builder.product.setPartB("这是B部分的赋值！");
        System.out.println("创建Product的PartB部分");
    }

    public void buildPartC() {
        Builder.product.setPartC("这是C部分的赋值！");
        System.out.println("创建Product的PartC部分");
    }

    public void buildPartD() {
        Builder.product.setPartD("这是D部分的赋值！");
        System.out.println("创建Product的PartD部分");
    }

}
