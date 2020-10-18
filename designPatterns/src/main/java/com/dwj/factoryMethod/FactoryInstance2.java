package com.dwj.factoryMethod;

public class FactoryInstance2 implements Factory{
    public Product getProduct() {
        System.out.println("工厂2产生了产品2");
        return new ProductInstance2();
    }
}
