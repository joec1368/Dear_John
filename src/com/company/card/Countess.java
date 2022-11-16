package com.company.card;

import com.company.Deck;
import com.company.Output;
import com.company.PlayerStatus;
import com.company.RemainDeck;

public class Countess extends Card{

    @Override
    protected int value() {
        return 7;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck, Output output) {
        remainDeck.discard(this);
    }
}
