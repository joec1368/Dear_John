package com.company;

import com.company.io.SingleInput;


public class Input {
    private SingleInput input;
    public Input(SingleInput input) {
        this.input = input;
    }

    public String input_left_right(){
        return input.next();
    }

    public int player_Number(){
        return input.nextInt();
    }

    public int client_player(){
        return input.nextInt();
    }

    public int guess_Number(){
        return input.nextInt();
    }
}
