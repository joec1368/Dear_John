package com.company.io.multimachine;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

public interface Client extends Remote {
    String next() throws RemoteException;
    int nextInt() throws RemoteException;
    void println() throws RemoteException;
    void println(String string) throws RemoteException;
    void print(String string) throws RemoteException;
}
