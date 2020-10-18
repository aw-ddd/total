package com.dwj.factoryMethod;

public class FactoryInstance1 implements Factory{
    public Product getProduct() {
        System.out.println("工厂1产生了产品1");
        return new ProductInstance1();
    }
}
