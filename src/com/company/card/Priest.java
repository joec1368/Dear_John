package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;
import com.company.RemainDeck;

public class Priest extends Card{



    @Override
    protected int value() {
        return 2;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck) {
        System.out.println(clientPlayer.getCard().toString());
        remainDeck.discard(this);
    }
}
