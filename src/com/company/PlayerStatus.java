package com.company;


import com.company.card.Card;

import java.util.Scanner;

public class PlayerStatus {
    private Card card;
    private Status status;
    private int id;

    public void setupDraw(Deck deck) {
        this.card = deck.draw();
    }

    public Card turn(Deck deck, Input input, Output output) {
        Card card = deck.draw();
        output.individual_card_set(this,card);
        output.individual_left_right(this);
        boolean discardNew = true;
        String temp = input.input_left_right(this);
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
    PlayerStatus(int id){
        status = Status.alive;
        this.id = id;
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

    public int getId() {
        return id;
    }
}
