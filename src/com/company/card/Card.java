package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;
import com.company.RemainDeck;

import java.util.HashMap;
import java.util.Map;

public abstract class Card {

    @Override
    public String toString() {
        return super.toString();
    }

    protected abstract int value();
    public abstract void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck);

    public int cardValue(){
        return value();
    }


}

