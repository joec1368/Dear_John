package com.company.card;

import com.company.Deck;
import com.company.Output;
import com.company.PlayerStatus;
import com.company.RemainDeck;

public class Baron extends Card{

    @Override
    protected int value() {
        return 3;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck, Output output) {
        if(hostPlayer.getCard().cardValue() < clientPlayer.getCard().cardValue()){
            hostPlayer.setStatus(PlayerStatus.Status.dead);
            remainDeck.discard(hostPlayer.getCard());

        }else if(hostPlayer.getCard().cardValue() > clientPlayer.getCard().cardValue()){
            clientPlayer.setStatus(PlayerStatus.Status.dead);
            remainDeck.discard(clientPlayer.getCard());
        }
        remainDeck.discard(this);
    }
}
