package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;
import com.company.RemainDeck;

public class Princess extends Card{

    @Override
    protected int value() {
        return 8;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck) {
        remainDeck.discard(this);
        hostPlayer.setStatus(PlayerStatus.Status.dead);
        remainDeck.discard(hostPlayer.getCard());
    }
}
