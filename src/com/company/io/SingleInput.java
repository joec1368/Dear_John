package com.company.io;

import java.util.Scanner;

public class SingleInput {
    private Scanner scanner;
    public SingleInput() {
        scanner = new Scanner(System.in);
    }

    public String next() {
        return scanner.next();
    }

    public int nextInt() {
        return  scanner.nextInt();
    }
}
