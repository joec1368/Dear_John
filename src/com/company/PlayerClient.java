package com.company;

import com.company.io.multimachine.Client;
import com.company.io.multimachine.ClientImpl;
import com.company.io.multimachine.HostIO;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class PlayerClient {
    private final int DEFAULT_PORT = 1099;

    public static void main(String[] args) throws RemoteException, NotBoundException {
        PlayerClient client = new PlayerClient();
        client.start();
    }

    public void start() throws RemoteException, NotBoundException {
        Client client = new ClientImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Room host ip: ");
        String hostIp = scanner.next();
        System.out.print("room number: ");
        int roomNumber = scanner.nextInt();


        Registry registry = LocateRegistry.getRegistry(hostIp, roomNumber);
        Remote r = registry.lookup("room_host");
        HostIO host = (HostIO) r;

        int id = host.getId();

        registry.rebind(String.format("%d-%d", roomNumber, id), UnicastRemoteObject.exportObject(client, 0));

        host.enter(id);
    }
}
