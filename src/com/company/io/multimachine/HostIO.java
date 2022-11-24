package com.company.io.multimachine;

import com.company.io.IO;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface HostIO extends Remote {

    int getId() throws RemoteException;
    void enter(String ip, int id) throws RemoteException, NotBoundException;
}
