package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;

public class Priest extends Card{



    @Override
    protected int value() {
        return 2;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck) {
        System.out.print(clientPlayer.getCard().cardValue());
    }
}
