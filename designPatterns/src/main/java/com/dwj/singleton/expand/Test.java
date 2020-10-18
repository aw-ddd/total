package com.dwj.singleton.expand;



public class Test {
    @org.junit.Test
    public void test(){
        Student instance = Student.getInstance();
        Student instance2 = Student.getInstance();

        System.out.println(instance);
        System.out.println(instance2);
    }
}
