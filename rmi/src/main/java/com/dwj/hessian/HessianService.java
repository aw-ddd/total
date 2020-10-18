package com.dwj.hessian;

public class HessianService implements DemoApi {

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String sayHello() {
        return "hello:"+this.name;
    }

    @Override
    public User getUser() {
        return new User();
    }
}
