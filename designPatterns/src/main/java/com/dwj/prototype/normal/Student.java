package com.dwj.prototype.normal;

import java.util.Date;

//具体原型类(实现clone接口)
public class Student implements Cloneable{

    private String name;
    private Integer age;
    private Date birthday;

    public Student() {
    }

    public Student(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        System.out.println("学生对象创建成功！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone()  {
        System.out.println("学生对象拷贝成功！");
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("拷贝失败");
            return null;
        }
    }
}
