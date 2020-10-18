package com.dwj.decorator.normal;

//具体构建角色
public class ConcreteComponent implements  Component{

    public ConcreteComponent(){
        System.out.println("具体构建角色的类创建了一个对象！！！");
    }


    public void operation() {
        System.out.println("调用了具体构建角色的类中的操作方法！！！");
    }
}
