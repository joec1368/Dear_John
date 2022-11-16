package com.company.io.singlemachine;

import com.company.io.InputMethod;

import java.util.Scanner;

class SingleInput implements InputMethod {
    private Scanner scanner;
    SingleInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String next() {
        return scanner.next();
    }
    @Override
    public int nextInt() {
        return  scanner.nextInt();
    }
}
