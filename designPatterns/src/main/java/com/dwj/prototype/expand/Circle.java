package com.dwj.prototype.expand;

import java.util.Scanner;

//圆
public class Circle implements Shape{

    public Object clone() {

        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("克隆圆形失败！");
            return null;
        }
    }

    //计算圆形面积
    public void calculation() {
        int i = 0;
        System.out.println("这是一个圆，请输入圆的半径，计算圆的面积");
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        System.out.println("该圆的面积为="+3.14*i*i);
    }
}
