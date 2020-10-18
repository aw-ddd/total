package com.dwj.builder;

//指挥者
public class Director {

    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    //组装产品
    public Product construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        builder.buildPartD();
        return builder.getResult();
    }
}
