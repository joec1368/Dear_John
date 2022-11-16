package com.company;

import com.company.card.Card;
import com.company.io.SingleIO;
import com.company.io.SingleInput;
import com.company.io.SingleOutput;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.start(args);
    }

    public void start(String[] args) {
        setup();
        int i = 0;
        while (true) {
            output.broadcast_player_status(playerlist, remainDeck);
            if (playerlist[i].getStatus() != PlayerStatus.Status.dead)
                if (running(playerlist[i],i)) break;
            i++;
            if (i == playerNumber) i = 0;
        }
    }

    int playerNumber;
    Deck deck;
    PlayerStatus[] playerlist;
    RemainDeck remainDeck;
    SingleIO io = new SingleIO();
    Output output = new Output(io.getOutput());
    Input input = new Input(io.getInput());

    void setup() {
        output.broadcast_number_of_people();
        playerNumber = input.player_Number();
        playerlist = new PlayerStatus[playerNumber];
        for (int i = 0; i < playerNumber; i++) playerlist[i] = new PlayerStatus(i);
        deck = new Deck();
        remainDeck = new RemainDeck();
        for (PlayerStatus player : playerlist) {
            player.setStatus(PlayerStatus.Status.alive);
            player.setupDraw(deck);
        }


    }

    boolean running(PlayerStatus player , int j) {
//        System.out.println("you : " + j);
//        information(player);
//        System.out.println();
        Card card = player.turn(deck, input, output);
        output.broadcast_show_use_card(j,card);
//        System.out.println("you : " + j);
        if (player.getStatus() == PlayerStatus.Status.infeasible) player.setStatus(PlayerStatus.Status.alive);
        int guessNumber = 0;// decide by input
        int clientPlayer = 0;//decide by input
        int count_dead = 0;
        if (card.cardValue() != 8 && card.cardValue() != 7 && card.cardValue() != 4) {
            int count = 0;
            int infeasible = 0;
            for (int i = 0; i < playerNumber; i++) {
                if (playerlist[i].getStatus() == PlayerStatus.Status.alive) count++;
                if(playerlist[i].getStatus() == PlayerStatus.Status.infeasible) infeasible++;

            }
            if (count > 1) {
                while (true) {
                    output.individual_choose_target();
                    clientPlayer = input.client_player();
                    if (playerlist[clientPlayer].getStatus() == PlayerStatus.Status.alive) break;
                }
                output.broadcast_show_target(j,clientPlayer);
            } else {
                remainDeck.discard(card);
                count_dead = 0;
                int  count_infeasible = 0;
                for (int i = 0; i < playerNumber; i++) {
                    if (playerlist[i].getStatus() == PlayerStatus.Status.dead) count_dead++;
                    if(playerlist[i].getStatus() == PlayerStatus.Status.infeasible) count_infeasible++;
                }
                if (deck.cards.size() == 0) {
                    ending();
                    return true;
                } else if (count_dead == playerNumber - 1) {
                    ending();
                    return true;
                }
                else if(count_dead + count_infeasible == playerNumber - 2) return false;
                return false;
            }
        }
        if (card.cardValue() == 1) {
            output.individual_choose_target_number();
            guessNumber = input.guess_Number();
            output.broadcast_show_target_number(j,guessNumber);
        }
        card.action(player, guessNumber, playerlist[clientPlayer], deck, remainDeck, output);
//        System.out.println();
//        System.out.println("player : " + j);
//        information(player);
//        System.out.println();

        count_dead = 0;
        for (int i = 0; i < playerNumber; i++) {
            if (playerlist[i].getStatus() == PlayerStatus.Status.dead) count_dead++;
        }
        if (deck.cards.size() == 0) {
            ending();
            return true;
        } else if (count_dead == playerNumber - 1) {
            ending();
            return true;
        }
        return false;
    }



    void ending() {
        int winPlayer = -1;
        int winPlayerSecond = -1;
        int winPoint = -1;
        for (int i = 0; i < playerNumber; i++) {
            if (playerlist[i].getStatus() == PlayerStatus.Status.alive) {
                if (playerlist[i].getCard().cardValue() > winPoint) {
                    winPoint = playerlist[i].getCard().cardValue();
                    winPlayer = i;
                    winPlayerSecond = -1;
                }
                else if(playerlist[i].getCard().cardValue() == winPoint) {
                    winPlayerSecond = i;
                }
            }
        }
//        if(winPlayerSecond == -1)
//            System.out.print("winener : " + String.valueOf(winPlayer ));
//        else
//            System.out.print("winener : " + String.valueOf(winPlayer) + "," + String.valueOf(winPlayerSecond));
        output.broadcast_winner(winPlayerSecond,winPlayer);
    }

    void information(PlayerStatus player){
        System.out.println("your card " + player.getCard());
        System.out.println("left card" + remainDeck.remain);
    }

    void view_all_information(int playerNumber){
        for(int i = 0 ; i < playerNumber ; i++){
            System.out.println("player : " + i + "  " + playerlist[i].getCard() + " ");
            System.out.println("player: " + i + " " + playerlist[i].getStatus() + " ");
            System.out.println();
        }
    }
}
