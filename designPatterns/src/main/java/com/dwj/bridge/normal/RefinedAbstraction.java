package com.dwj.bridge.normal;

//扩展抽象化角色
public class RefinedAbstraction extends Abstraction{

    protected RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    public void operation() {
        System.out.println("扩展的抽象化角色被访问！！！");
        implementor.operationImpl();
    }
}
