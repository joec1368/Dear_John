package com.company.io.singlemachine;

import com.company.io.OutputMethod;

class SingleOutput implements OutputMethod {

    @Override
    public void println() {
        System.out.println();
    }
    @Override
    public void println(String string) {
        System.out.println(string);
    }
    @Override
    public void print(String string) {
        System.out.print(string);
    }

    @Override
    public void println(int id) {
        println();
    }
    @Override
    public void println(String string, int id) {
        println(string);
    }
    @Override
    public void print(String string, int id) {
        print(string);
    }
}
