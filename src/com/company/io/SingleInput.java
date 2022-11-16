package com.company.io;

import java.util.Scanner;

public class SingleInput {
    private Scanner scanner;
    SingleInput() {
        scanner = new Scanner(System.in);
    }

    public String next() {
        return scanner.next();
    }

    public int nextInt() {
        return  scanner.nextInt();
    }
}
