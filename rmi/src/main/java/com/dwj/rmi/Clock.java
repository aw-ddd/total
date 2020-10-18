package com.dwj.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

/**
 * 获取时间
 */
public interface Clock extends Remote {

    LocalDateTime currentTime() throws RemoteException;

}
