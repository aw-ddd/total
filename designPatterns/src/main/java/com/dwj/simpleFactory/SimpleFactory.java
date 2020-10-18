package com.dwj.simpleFactory;


public class SimpleFactory {

    public Product getProduct(int type) {
        switch (type) {
            case Const.PRODUCT_A:
                return new ProductInstance1();
            case Const.PRODUCT_B:
                return new ProductInstance2();
            default:
                return null;
        }
    }
}
