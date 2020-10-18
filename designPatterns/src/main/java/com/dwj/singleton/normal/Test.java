package com.dwj.singleton.normal;


public class Test {

    @org.junit.Test
    public void test(){
        President instance = President.getInstance();
        instance.setName("张三");

        President instance2 = President.getInstance();
        instance2.setName("李四");

        if (instance.getName().equals(instance2.getName())){
            System.out.println("总统只能有一个无法被多次创建！");
        }

        System.out.println(instance.getName());
        System.out.println(instance2.getName());
    }
}
