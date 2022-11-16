package com.company.io;

public class SingleOutput {
    SingleOutput() {
        //only to make constructor package-private
    }
    public void println() {
        System.out.println();
    }
    public void println(String string) {
        System.out.println(string);
    }
    public void print(String string) {
        System.out.print(string);
    }
}
