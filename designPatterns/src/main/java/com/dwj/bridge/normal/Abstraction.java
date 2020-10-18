package com.dwj.bridge.normal;

//抽象化角色
public abstract class Abstraction {

    protected Implementor implementor;

    protected Abstraction(Implementor implementor){
        this.implementor = implementor;
    }
    public abstract void operation();
}
