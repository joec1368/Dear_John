package com.company.io;

public interface OutputMethod {
    void println();
    void println(String string);
    void print(String string);

    void println(int id) throws IdNotExistException;
    void println(String string, int id) throws IdNotExistException;
    void print(String string, int id) throws IdNotExistException;
}
