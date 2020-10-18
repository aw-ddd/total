package com.dwj.singleton.easy;



public class Test {

    //测试懒汉式单例模式创建对象
    @org.junit.Test
    public void testLazy(){
        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance1 = LazySingleton.getInstance();

        System.out.println(instance);
        System.out.println(instance1);
    }

    //测试饿汉式单例模式创建对象
    @org.junit.Test
    public void testHungry(){
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1 = HungrySingleton.getInstance();

        System.out.println(instance);
        System.out.println(instance1);

    }
}
