package com.dwj.adapter.demo;

public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        Motor electric = new Electric();
        Motor optical = new Optical(car);

        electric.drive();
        System.out.println("-------------------------");
        optical.drive();
    }
}
