package com.company.io.multimachine;

import java.rmi.RemoteException;

@FunctionalInterface
interface RemoteBlock<R> {
    R action() throws RemoteException;

    default R retryOnFail() {
        while (true) {
            try {
                return action();
            } catch (RemoteException e) {
                System.out.println("catch RemoteException. Retry...");
            }
        }
    }
}