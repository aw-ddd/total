package com.dwj.adapter.classAdapter;

//测试类适配者
public class Test {
    public static void main(String[] args) {
        //虽然ClassAdapter类实现了request接口，但是实际上并未进行request中需要进行的操作，实际上进行的还是Adapter类中进行的操作
        Target target = new ClassAdapter();
        target.request();
    }
}
