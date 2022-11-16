package com.company;

import java.util.Scanner;

public class Input {

    public static String input_left_right(){
        Scanner sca = new Scanner(System.in);
        return sca.next();
    }

    public static int player_Number(){
        Scanner sca = new Scanner(System.in);
        return sca.nextInt();
    }

    public static int client_player(){
        Scanner sca = new Scanner(System.in);
        return sca.nextInt();
    }

    public static int guess_Number(){
        Scanner sca = new Scanner(System.in);
        return sca.nextInt();
    }
}
