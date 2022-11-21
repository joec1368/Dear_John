package com.company.io;

public interface IO {
    void waitPlayersReady(int playerNumber);
    OutputMethod getOutput();
    InputMethod getInput();
}
