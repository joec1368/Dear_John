package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;

import java.util.HashMap;
import java.util.Map;

public abstract class Card {

    protected abstract int value();
    public abstract void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck);

    public int cardValue(){
        return value();
    }


}

