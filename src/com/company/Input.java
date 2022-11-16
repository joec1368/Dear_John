package com.company;

import com.company.io.InputMethod;

import java.util.Scanner;


public class Input {
    private InputMethod input;
    public Input(InputMethod input) {
        this.input = input;
    }

    public String input_left_right(PlayerStatus player){
        return input.next(player.getId());
    }

    public int host_player_Number(){
        return input.nextInt(0);
    }

    public int client_player(PlayerStatus player){
        return input.nextInt(player.getId());
    }

    public int guess_Number(PlayerStatus player){
        return input.nextInt(player.getId());
    }
}
