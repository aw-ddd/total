package com.dwj.decorator.normal;

//具体装饰者角色
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        this.addMethod();
    }

    public void addMethod(){
        System.out.println("这是作为装饰者模式添加的功能！！！");
    }
}
