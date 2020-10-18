package com.dwj.bridge.demo;

public class Test {
    public static void main(String[] args) {

        //获取一个黄色的挎包
        Color yellow = new Yellow();
        Bag handBag = new HandBag(yellow);
        handBag.getBag();

        System.out.println("------------------");
        //获取红色的钱包
        Color red = new Red();
        Bag wallet = new Wallet(red);
        wallet.getBag();

        System.out.println("------------------");
        //获取一个黄色的钱包
        Bag wallet1 = new Wallet(yellow);
        wallet1.getBag();
    }
}
