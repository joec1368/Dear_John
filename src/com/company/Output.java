package com.company;

import com.company.card.Card;

public class Output {

    int playerNumber;
    Deck deck;
    PlayerStatus[] playerlist;
    RemainDeck remainDeck;
    Output(PlayerStatus[] playerlist ,Deck deck, RemainDeck remainDeck,int playerNumber){
        this.deck = deck;
        this.playerlist = playerlist;
        this.remainDeck = remainDeck;
        this.playerNumber = playerNumber;
    }

    public void broadcast_card(int playerNumber){

    }

    public void individual_card_set(PlayerStatus playerstatus, Card new_card){
        int count = 0;
        for (PlayerStatus player : playerlist) {
            if(player == playerstatus){
                System.out.println("You : " + count);
            }else{
                count++;
            }
        }
        System.out.println("id : " + new_card.cardValue() + "  card name :  " + new_card + " ||| " + " id : " +  playerstatus.getCard().cardValue() +"  card name :  " + playerstatus.getCard());
    }

    public void individual_left_right(){
        System.out.println("left , right");
    }

    public void broadcast_player_status(){
        System.out.println("show all player status");
        for(int i = 0 ; i < this.playerlist.length ; i++){
            System.out.println("player: " + i + " " + this.playerlist[i].getStatus() + " ");
        }
        System.out.println("left card" + remainDeck.remain);
        System.out.println();
    }

    public void individual_choose_target(){
        System.out.println("target : ");
    }

    public void broadcast_show_target(int j,int i){
        System.out.println();
        System.out.println(j + " use card on " + i);
        System.out.println();
    }

    public void individual_choose_target_number(){
        System.out.println("number : ");
    }

    public void broadcast_show_target_number(int j,int guessNumber){
        System.out.println();
        System.out.println(j + " guess the card of number is : " + guessNumber);
        System.out.println();
    }

    public void broadcast_winner(int winPlayerSecond,int winPlayer){
        if(winPlayerSecond == -1)
            System.out.print("winner : " + String.valueOf(winPlayer ));
        else
            System.out.print("winner : " + String.valueOf(winPlayer) + "," + String.valueOf(winPlayerSecond));

    }

    public void broadcast_show_use_card(int j,Card card){
        System.out.println();
        System.out.println(j + " use card : " + card);
        System.out.println();
    }
}
