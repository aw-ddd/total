package com.dwj.singleton.easy;

//饿汉式单例模式
public class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return singleton;
    }
}
