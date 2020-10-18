package com.dwj.prototype.normal;


import java.util.Date;

public class Test {

    //测试原型类的深克隆
    @org.junit.Test
    public void test1() throws CloneNotSupportedException {
        Student student = new Student("张三",19,new Date());
        //深克隆对象
        Student cloneStudent = (Student) student.clone();
        //因为Student类中未重写equals方法，所以在此处比较的是地址值，深克隆的产生的对象地址值会发生改变
        System.out.println(cloneStudent.equals(student));
    }


}
