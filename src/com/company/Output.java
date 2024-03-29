package com.company;

import com.company.card.Card;
import com.company.io.OutputMethod;

public class Output {

    private final OutputMethod output;
    Output(OutputMethod output){
        this.output = output;
    }

    public void host_number_of_people(){
        output.println("number of people", 0);
    }

    public void individual_card_set(PlayerStatus playerstatus, Card new_card){
        output.println("You : " + playerstatus.getId(), playerstatus.getId());
        output.println(
            "id : " + new_card.cardValue() + "  card name :  " + new_card + " ||| " + " id : " +  playerstatus.getCard().cardValue() +"  card name :  " + playerstatus.getCard(),
            playerstatus.getId()
        );
    }

    public void individual_left_right(PlayerStatus playerStatus){
        output.println("left , right", playerStatus.getId());
    }

    public void broadcast_player_status(PlayerStatus[] playerlist, RemainDeck remainDeck){
        output.println("show all player status");
        for (PlayerStatus player: playerlist) {
            output.println("player: " + player.getId() + " " + player.getStatus() + " ");
        }
        output.println("left card" + remainDeck.remain);
        output.println();
    }

    public void individual_choose_target(PlayerStatus playerStatus){
        output.println("target : ", playerStatus.getId());
    }

    public void broadcast_show_target(int j,int i){
        output.println();
        output.println(j + " use card on " + i);
        output.println();
    }

    public void individual_choose_target_number(PlayerStatus playerStatus){
        output.println("number : ", playerStatus.getId());
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

    public void individual_opponent_card(PlayerStatus clientPlayer, PlayerStatus thisPlayer){
        output.println(clientPlayer.getCard().toString(), thisPlayer.getId());
    }

    public void broadcast_the_card_be_discard(PlayerStatus playerStatus){
        output.println();
        output.println(" it is the card which is discarded : " + playerStatus.getCard());
        output.println();
    }
}
