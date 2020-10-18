package com.dwj.decorator.normal;

//抽象装饰者角色
public class Decorator implements Component{

    private Component component;

    public Decorator(Component component){
        this.component = component;
    }

    //调用具体构建角色的操作方法
    public void operation() {
        component.operation();
    }
}
