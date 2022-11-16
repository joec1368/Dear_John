package com.company.card;

import com.company.*;

public class Priest extends Card{



    @Override
    protected int value() {
        return 2;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck, Output output) {
        output.individual_opponent_card(clientPlayer, hostPlayer);
        remainDeck.discard(this);
    }
}
