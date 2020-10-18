package com.dwj.singleton.normal;

//总统类
public class President {

    private String name;

    private static volatile President president = null;

    private President(){}

    public static synchronized President getInstance(){
        if (president == null){
            president = new President();
        }
        return president;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
