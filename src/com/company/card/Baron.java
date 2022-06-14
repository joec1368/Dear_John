package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;

public class Baron extends Card{

    @Override
    protected int value() {
        return 3;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck) {
        if(hostPlayer.getCard().cardValue() < clientPlayer.getCard().cardValue()){
            hostPlayer.setStatus(PlayerStatus.Status.dead);
        }else if(hostPlayer.getCard().cardValue() > clientPlayer.getCard().cardValue()){
            clientPlayer.setStatus(PlayerStatus.Status.dead);
        }
    }
}
