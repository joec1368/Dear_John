package com.company;

import com.company.card.Card;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.start(args);
    }

    public void start(String[] args) {
        setup();
        int i = 0;
        while(true){
            running(playerlist[i++]);
            if(i == 4) i = 0;
        }
    }

    int playerNumber;
    Deck deck;
    PlayerStatus[] playerlist;
    RemainDeck remainDeck;

    void setup() {
        Scanner sca = new Scanner(System.in);
        playerNumber = sca.nextInt();
        playerlist = new PlayerStatus[playerNumber];
        deck = new Deck();
        remainDeck = new RemainDeck();
        for (PlayerStatus player : playerlist) {
            player.setupDraw(deck);
        }
    }

    void running(PlayerStatus player) {
        Card card = player.turn(deck);
        int guessNumber = 0;// decide by input
        int clientPlayer = 0;//decide by input
        card.action(player, guessNumber, playerlist[clientPlayer], deck);
        remainDeck.discard(card);
        if (deck.cards.size() == 0) {
            ending();
        }
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
        System.exit(0);
    }
    // TODO: 2022/6/14 deadpeople shoud discard card;
}
