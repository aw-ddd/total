package com.dwj.composite.demo;

//商品（树叶构件）
public class Goods implements Articles{

    //商品名
    private String name;
    //数量
    private int quantity;
    //单价
    private float unitPrice;

    public Goods(String name,int quantity,float unitPrice){
        this.name=name;
        this.quantity=quantity;
        this.unitPrice=unitPrice;
    }


    public float calculation() {
        return quantity * unitPrice;
    }

    public void show() {
        System.out.println("买了"+name+"数量是"+quantity+"单价是"+unitPrice);
    }
}
