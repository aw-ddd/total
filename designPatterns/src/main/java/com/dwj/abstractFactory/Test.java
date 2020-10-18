package com.dwj.abstractFactory;

//测试
public class Test {

    public static void main(String[] args) {
        ChinaFarmFactory chinaFarmFactory = new ChinaFarmFactory();
        Animal animal = chinaFarmFactory.getAnimal();
        Plant plant = chinaFarmFactory.getPlant();
        animal.run();
        plant.grow();

        System.out.println("-------------------------");

        USFarmFactory usFarmFactory = new USFarmFactory();
        Animal animal1 = usFarmFactory.getAnimal();
        Plant plant1 = usFarmFactory.getPlant();
        animal1.run();
        plant1.grow();
    }
}
