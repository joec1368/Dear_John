package com.company.card;

import com.company.Deck;
import com.company.Output;
import com.company.PlayerStatus;
import com.company.RemainDeck;

public abstract class Card {

    @Override
    public String toString() {
        return super.toString();
    }

    protected abstract int value();
    public abstract void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck, Output output);

    public int cardValue(){
        return value();
    }


}

