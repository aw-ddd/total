package com.dwj.flyweight.demo;

import java.util.HashMap;

//围棋工厂（享元工厂角色）
public class GoFactory {
    private HashMap<String,Go> hashMap = new HashMap<String, Go>();

     public Go getConcreteGo(String color){
         Go go = hashMap.get(color);
         if (go != null){
             System.out.println("对象已经被创建，可以直接使用了");
         }else {
             go = new ConcreteGo(color);
             hashMap.put(color,go);
             System.out.println("创建一个对象");
         }
         return go;
     }
}
