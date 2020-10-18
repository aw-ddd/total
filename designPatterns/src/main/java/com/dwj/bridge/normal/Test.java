package com.dwj.bridge.normal;

public class Test {
    public static void main(String[] args) {
        Implementor imp = new ImplementorImpl();
        Abstraction abstraction = new RefinedAbstraction(imp);
        abstraction.operation();
    }
}
