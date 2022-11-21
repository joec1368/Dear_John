package com.company.io.multimachine;

import com.company.io.InputMethod;

import java.rmi.RemoteException;
import java.util.List;

public class HostInput implements InputMethod {
    private final List<Client> clients;
    HostInput(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String next(int id) {
        return new RemoteBlock<String>() {
            @Override
            public String action() throws RemoteException {
                return clients.get(id).next();
            }
        }.retryOnFail();
    }

    @Override
    public int nextInt(int id) {
        return new RemoteBlock<Integer>() {
            @Override
            public Integer action() throws RemoteException {
                return clients.get(id).nextInt();
            }
        }.retryOnFail();
    }
}
