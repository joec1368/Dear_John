package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;

public class Prince extends Card{

    @Override
    protected int value() {
        return 5;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck) {
        
    }
}
