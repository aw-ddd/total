package com.dwj.abstractFactory;

//农场类的实现
public class USFarmFactory implements Farm{
    public Animal getAnimal() {
        System.out.println("在美国农场");
        return new Cows();
    }

    public Plant getPlant() {
        System.out.println("在美国农场");
        return new Fruit();
    }
}
