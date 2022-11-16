package com.company;

public class Output_static {
    public static void broadcast_number_of_people(){
        System.out.println("number of people");
    }

    public static void individual_opponent_card(PlayerStatus clientPlayer){
        System.out.println(clientPlayer.getCard().toString());
    }

    public static void broadcast_the_card_be_discard(PlayerStatus playerStatus){
        System.out.println();
        System.out.println(" it is the card which is discarded : " + playerStatus.getCard());
        System.out.println();
    }

}
