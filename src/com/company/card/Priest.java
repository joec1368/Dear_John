package com.company.card;

import com.company.Deck;
import com.company.Output_static;
import com.company.PlayerStatus;
import com.company.RemainDeck;

public class Priest extends Card{



    @Override
    protected int value() {
        return 2;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck) {
        Output_static.individual_opponent_card(clientPlayer);
        remainDeck.discard(this);
    }
}
