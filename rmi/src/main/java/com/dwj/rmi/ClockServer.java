package com.dwj.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClockServer {
    public static void main(String[] args) throws Exception{
        Clock clock = new ClockImpl();
        //连接的端口号不能过大，否则会连接不上啊
        Clock stub = (Clock) UnicastRemoteObject.exportObject(clock, 1099);
        LocateRegistry.createRegistry(1099);
        Registry registry = LocateRegistry.getRegistry();
        registry.bind("Clock",stub);
        System.out.println("Clock Server ready");
    }
}