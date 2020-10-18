package com.dwj.builder;

//抽象建造者
public abstract class Builder {
    //创建产品对象
    protected static Product product = new Product();

    //构建模块
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();
    public abstract void buildPartD();

    //返回一个完整的产品
    public Product getResult(){
        return product;
    };
}
