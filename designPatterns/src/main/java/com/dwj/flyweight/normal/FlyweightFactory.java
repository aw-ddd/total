package com.dwj.flyweight.normal;

import java.util.HashMap;

//享元工厂角色
public class FlyweightFactory {

    private HashMap<String,Flyweight> hashMap = new HashMap<String, Flyweight>();

    //获取具体的享元角色
    public Flyweight getFlyweight(String key){
        Flyweight flyweight = hashMap.get(key);
        if (flyweight != null){
            System.out.println("具体享元角色"+key+"已经存在，被成功获取了！");
        }else {
            flyweight = new ConcreteFlyweight(key);
            hashMap.put(key,flyweight);
        }
        return flyweight;
    }
}
