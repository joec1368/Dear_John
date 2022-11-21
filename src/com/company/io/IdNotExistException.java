package com.company.io;

public class IdNotExistException extends IllegalArgumentException {
    public IdNotExistException(int id) {
        super(String.format("Id %d doesn't exist", id));
    }
}
