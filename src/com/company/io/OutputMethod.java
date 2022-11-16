package com.company.io;

public interface OutputMethod {
    void println();
    void println(String string);
    void print(String string);

    void println(int id);
    void println(String string, int id);
    void print(String string, int id);
}
