package com.dwj.rmi;

import java.rmi.RemoteException;
import java.time.LocalDateTime;

public class ClockImpl  implements Clock{


    public LocalDateTime currentTime() throws RemoteException {
        return LocalDateTime.now();
    }
}
