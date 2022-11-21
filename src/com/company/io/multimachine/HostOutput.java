package com.company.io.multimachine;

import com.company.io.IdNotExistException;
import com.company.io.OutputMethod;

import java.util.List;
import java.util.function.Consumer;

public class HostOutput implements OutputMethod {

    private final List<Client> clients;
    HostOutput(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void println() {
        broadcast(client -> {
            RemoteBlock<Void> r = () -> {
                client.println();
                return null;
            };
            r.retryOnFail();
        });
    }

    @Override
    public void println(String string) {
        broadcast(client -> {
            RemoteBlock<Void> r = () -> {
                client.println(string);
                return null;
            };
            r.retryOnFail();
        });
    }

    @Override
    public void print(String string) {
        broadcast(client -> {
            RemoteBlock<Void> r = () -> {
                client.print(string);
                return null;
            };
            r.retryOnFail();
        });
    }

    private void broadcast(Consumer<Client> sender) {
        for (Client client: clients) {
            sender.accept(client);
        }
    }

    @Override
    public void println(int id) {
        if (id >= clients.size()) {
            throw new IdNotExistException(id);
        }
        RemoteBlock<Void> r = () -> {
            clients.get(id).println();
            return null;
        };
        r.retryOnFail();
    }

    @Override
    public void println(String string, int id) {
        if (id >= clients.size()) {
            throw new IdNotExistException(id);
        }
        RemoteBlock<Void> r = () -> {
            clients.get(id).println(string);
            return null;
        };
        r.retryOnFail();
    }

    @Override
    public void print(String string, int id) {
        if (id >= clients.size()) {
            throw new IdNotExistException(id);
        }
        RemoteBlock<Void> r = () -> {
            clients.get(id).print(string);
            return null;
        };
        r.retryOnFail();
    }
}
