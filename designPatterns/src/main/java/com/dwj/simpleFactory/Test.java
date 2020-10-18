package com.dwj.simpleFactory;


public class Test {
    @org.junit.Test
    public void test(){
        SimpleFactory factory = new SimpleFactory();
        Product product = factory.getProduct(1);
        product.show();
    }
}
