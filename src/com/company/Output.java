package com.company;

import com.company.card.Card;
import com.company.io.SingleOutput;

public class Output {

    PlayerStatus[] playerlist;
    RemainDeck remainDeck;
    private SingleOutput output;
    Output(PlayerStatus[] playerlist, RemainDeck remainDeck, SingleOutput output){
        this.playerlist = playerlist;
        this.remainDeck = remainDeck;
        this.output = output;
    }

    public void individual_card_set(PlayerStatus playerstatus, Card new_card){
        int count = 0;
        for (PlayerStatus player : playerlist) {
            if(player == playerstatus){
                output.println("You : " + count);
            }else{
                count++;
            }
        }
        output.println("id : " + new_card.cardValue() + "  card name :  " + new_card + " ||| " + " id : " +  playerstatus.getCard().cardValue() +"  card name :  " + playerstatus.getCard());
    }

    public void individual_left_right(){
        output.println("left , right");
    }

    public void broadcast_player_status(){
        output.println("show all player status");
        for(int i = 0 ; i < this.playerlist.length ; i++){
            output.println("player: " + i + " " + this.playerlist[i].getStatus() + " ");
        }
        output.println("left card" + remainDeck.remain);
        output.println();
    }

    public void individual_choose_target(){
        output.println("target : ");
    }

    public void broadcast_show_target(int j,int i){
        output.println();
        output.println(j + " use card on " + i);
        output.println();
    }

    public void individual_choose_target_number(){
        output.println("number : ");
    }

    public void broadcast_show_target_number(int j,int guessNumber){
        output.println();
        output.println(j + " guess the card of number is : " + guessNumber);
        output.println();
    }

    public void broadcast_winner(int winPlayerSecond,int winPlayer){
        if(winPlayerSecond == -1)
            output.print("winner : " + String.valueOf(winPlayer ));
        else
            output.print("winner : " + String.valueOf(winPlayer) + "," + String.valueOf(winPlayerSecond));
    }

    public void broadcast_show_use_card(int j,Card card){
        output.println();
        output.println(j + " use card : " + card);
        output.println();
    }
}
