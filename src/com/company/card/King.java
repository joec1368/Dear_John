package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;

public class King extends Card{

    @Override
    protected int value() {
        return 6;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck) {

    }
}
