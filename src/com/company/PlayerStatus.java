package com.company;


import com.company.card.Card;

import java.util.Scanner;

public class PlayerStatus {
    private Card card;
    private Status status;
    private Output output;

    public void setupDraw(Deck deck) {
        this.card = deck.draw();
    }

    public Card turn(Deck deck) {
        Card card = deck.draw();
        output.individual_card_set(this,card);
        output.individual_left_right();
        Scanner sca = new Scanner(System.in);
        boolean discardNew = true;
        String temp = Input.input_left_right();
        if(temp.equals("right")) discardNew = false;
        //decide by input
        if(discardNew){
            return card;
        }else{
            Card discard = this.card;
            this.card = card;
            return discard;
        }
    }

    public enum Status {
        alive, dead, infeasible
    }
    PlayerStatus(){
        status = Status.alive;
    }
    public Card getCard(){
        return card;
    }
    public void setCard(Card card){
        this.card = card;
    }
    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){this.status = status;}
    public void setOutput(Output output){this.output = output;}
}
