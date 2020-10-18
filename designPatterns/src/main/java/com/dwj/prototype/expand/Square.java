package com.dwj.prototype.expand;

import java.util.Scanner;

//正方形
public class Square implements Shape{

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("克隆正方形失败！");
            return null;
        }
    }

    //计算正方形的面积
    public void calculation() {
        System.out.println("请输入正方形的边长，计算正方形的面积");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println("正方形的面积为="+i*i);
    }
}
