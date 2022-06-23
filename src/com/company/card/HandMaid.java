package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;
import com.company.RemainDeck;

public class HandMaid extends Card{


    @Override
    protected int value() {
        return 4;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck) {
        hostPlayer.setStatus(PlayerStatus.Status.infeasible);
        remainDeck.discard(this);
    }
}
