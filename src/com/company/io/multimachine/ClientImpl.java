package com.company.io.multimachine;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientImpl implements Client {

    private final Scanner scanner = new Scanner(System.in);

    public String next() throws RemoteException {
        return scanner.next();
    }

    public int nextInt() throws RemoteException {
        return scanner.nextInt();
    }

    public void println() throws RemoteException {
        System.out.println();
    }

    public void println(String string) throws RemoteException {
        System.out.println(string);
    }

    public void print(String string) throws RemoteException {
        System.out.print(string);
    }
}

