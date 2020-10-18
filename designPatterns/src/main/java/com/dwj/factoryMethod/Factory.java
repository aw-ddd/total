package com.dwj.factoryMethod;

//工厂接口(通过该工厂接口创建实例，如果增加了需要创建的产品类，只需要再实现一次这个接口即可，符合开闭原则)
public interface Factory {
    Product getProduct();
}
