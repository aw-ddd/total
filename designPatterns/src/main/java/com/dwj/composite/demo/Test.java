package com.dwj.composite.demo;

public class Test {
    public static void main(String[] args) {
        Articles good1 = new Goods("苹果",10,15);
        Articles good2 = new Goods("香蕉",5,8);
        Articles good3 = new Goods("梨",3,20);

        Bags bag = new Bags();
        bag.add(good1);
        bag.add(good2);
        Bags bag2 = new Bags();
        bag2.add(good3);
        bag2.add(bag);
        bag2.show();

    }
}
