package com.dwj.flyweight.normal;

public class Test {
    public static void main(String[] args) {
       FlyweightFactory factory = new FlyweightFactory();
        Flyweight a1 = factory.getFlyweight("a");
        Flyweight a2 = factory.getFlyweight("a");
        Flyweight a3 = factory.getFlyweight("a");
        Flyweight b1 = factory.getFlyweight("b");
        Flyweight b2 = factory.getFlyweight("b");

        a1.operation(new UnsharedConcreteFlyweight("第一次调用a"));
        a2.operation(new UnsharedConcreteFlyweight("第二次调用a"));
        a3.operation(new UnsharedConcreteFlyweight("第三次调用a"));
        b1.operation(new UnsharedConcreteFlyweight("第一次调用b"));
        b2.operation(new UnsharedConcreteFlyweight("第二次调用b"));

    }
}
