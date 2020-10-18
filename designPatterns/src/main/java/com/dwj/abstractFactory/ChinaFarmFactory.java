package com.dwj.abstractFactory;

//农场的实现类
public class ChinaFarmFactory implements Farm{

    public Animal getAnimal() {
        System.out.println("在中国农场");
        return new Horse();
    }

    public Plant getPlant() {
        System.out.println("在中国农场");
        return new Vegetables();
    }
}
