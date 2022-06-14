package com.company;


import com.company.card.Card;

public class PlayerStatus {
    private Card card;
    private Status status;

    public void setupDraw(Deck deck) {
        card = deck.draw();
    }

    public Card turn(Deck deck) {
        Card card = deck.draw();
        boolean discardNew = true;//decide by input
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
}
