package com.company.io.singlemachine;

import com.company.io.IO;
import com.company.io.InputMethod;
import com.company.io.OutputMethod;

public class SingleIO implements IO {
    private final SingleOutput output = new SingleOutput();
    private final SingleInput input = new SingleInput();

    @Override
    public void waitPlayersReady(int playerNumber) {
        //do nothing, SingleIO doesn't have to wait, they're all using terminal
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
