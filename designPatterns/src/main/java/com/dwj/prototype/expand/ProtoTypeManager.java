package com.dwj.prototype.expand;

import java.util.HashMap;

//圆形和正方形的原型管理器
public class ProtoTypeManager {
    private HashMap<String,Shape> hashMap = new HashMap<String, Shape>();

    public ProtoTypeManager(){
        hashMap.put("circle",new Circle());
        hashMap.put("square",new Square());
    }

    //后续如果还需要向管理器中添加原型，可以直接使用该方法添加，而不需要修改类
    public void addShape(String key,Shape shape){
        hashMap.put(key,shape);
    }

    //获取原型(通过克隆的方式获取原型)
    public Shape getShape(String key){
        return (Shape) hashMap.get(key).clone();
    }

}
