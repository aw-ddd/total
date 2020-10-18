package com.dwj.decorator.demo;

public class Test {
    public static void main(String[] args) {
        Morrigan morrigan = new Original();
        Changer girl = new Girl(morrigan);
        girl.display();
    }
}
