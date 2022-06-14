package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;

public class Guard extends Card{


    @Override
    protected int value() {
        return 1;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck) {
        guess(clientPlayer , number);
    }
    private void guess(PlayerStatus player , int number){
        if(player.getCard().cardValue() == number){
            player.setStatus(PlayerStatus.Status.dead);
        }
    }
}
