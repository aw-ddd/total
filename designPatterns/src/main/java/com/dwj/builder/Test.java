package com.dwj.builder;

public class Test {
    public static void main(String[] args) {
        Builder builder = new SpecificBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        System.out.println(product);
    }
}
