package com.company.io.multimachine;

import com.company.io.IO;
import com.company.io.InputMethod;
import com.company.io.OutputMethod;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class HostIOImpl implements HostIO, IO {

    private int totalPlayerNumber = -1;
    private int currentPlayerNumber;
    private boolean playersReady = false;
    private int nextId;
    Registry registry;

    HostOutput output;
    HostInput input;
    private ArrayList<Client> clients;
    private int roomNumber;

    public HostIOImpl() throws RemoteException, UnknownHostException {
        clients = new ArrayList<>() {{
            add(new ClientImpl()); //host client
        }};
        currentPlayerNumber = 1;
        nextId = 1;
        output = new HostOutput(clients);
        input = new HostInput(clients);

        output.print("room number: ", 0);
        this.roomNumber = input.nextInt(0);
        output.print("Your IP is: ", 0);
        String ip = input.next(0);

        System.setProperty("java.rmi.server.hostname", ip);
        registry = LocateRegistry.createRegistry(roomNumber);
        registry.rebind("room_host", UnicastRemoteObject.exportObject(this, 0));
    }

    public synchronized int getId() throws RemoteException {
        return nextId++;
    }

    public synchronized void enter(String ip, int id) throws RemoteException, NotBoundException {
        if (totalPlayerNumber == -1) {
            //if playerNumber hasn't set, do nothing
            return;
        }

        Registry registry = LocateRegistry.getRegistry(ip);
        clients.add((Client) registry.lookup(String.format("%d-%d", roomNumber, id)));
        currentPlayerNumber++;
        if (currentPlayerNumber == totalPlayerNumber) {
            UnicastRemoteObject.unexportObject(this.registry, true);
            playersReady = true;
        }
    }

    @Override
    public void waitPlayersReady(int playerNumber) {
        totalPlayerNumber = playerNumber;
        while (!playersReady) {
            //loop forever, playersReady will be set in enter
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                //just ignore it
            }
        }
    }

    @Override
    public OutputMethod getOutput() {
        return output;
    }

    @Override
    public InputMethod getInput() {
        return input;
    }
}
