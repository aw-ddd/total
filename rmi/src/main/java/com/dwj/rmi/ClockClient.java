package com.dwj.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

public class ClockClient {
    public static void main(String[] args) throws Exception{
        //如果host地址填null，则默认为本地
        Registry registry = LocateRegistry.getRegistry(null);
        Clock clock = (Clock) registry.lookup("Clock");
        LocalDateTime localDateTime = clock.currentTime();
        System.out.println("RMI获取到的时间为："+localDateTime);
    }
}