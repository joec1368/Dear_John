package com.company.io.singlemachine;

import com.company.io.InputMethod;

import java.util.Scanner;

class SingleInput implements InputMethod {
    private Scanner scanner;
    SingleInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String next(int id) {
        return scanner.next();
    }
    @Override
    public int nextInt(int id) {
        return  scanner.nextInt();
    }
}
