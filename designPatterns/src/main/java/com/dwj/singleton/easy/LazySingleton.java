package com.dwj.singleton.easy;

//懒汉式单例模式(该懒汉模式可以保证线程安全)
public class LazySingleton {

    private static volatile LazySingleton instance = null;

    private LazySingleton(){} //避免类在外部被new出来

    public static synchronized LazySingleton getInstance(){
        if (instance == null){
           instance = new LazySingleton();
        }
        return instance;
    }



}
