package com.dwj.factoryMethod;


public class Test {
    public static void main(String[] args) {
        Factory factory1 = new FactoryInstance1();
        factory1.getProduct().show();

        Factory factory2 = new FactoryInstance2();
        factory2.getProduct().show();
    }
}
