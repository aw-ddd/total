package com.dwj.flyweight.normal;

//具体享元角色
public class ConcreteFlyweight implements Flyweight{

    private String key;

    public ConcreteFlyweight(String key){
        this.key = key;
        System.out.println("具体的享元角色"+key+"被创建！");
    }

    public void operation(UnsharedConcreteFlyweight unsharedConcreteFlyweight) {
        System.out.println("具体享元角色"+key+"被调用");
        System.out.println("非享元角色的信息是"+unsharedConcreteFlyweight.getInfo());
    }
}
