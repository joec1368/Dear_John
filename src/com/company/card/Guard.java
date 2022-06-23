package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;
import com.company.RemainDeck;

public class Guard extends Card{


    @Override
    protected int value() {
        return 1;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck) {
        guess(clientPlayer , number,remainDeck);
        remainDeck.discard(this);
    }
    private void guess(PlayerStatus player , int number, RemainDeck remainDeck){
        if(player.getCard().cardValue() == number){
            player.setStatus(PlayerStatus.Status.dead);
            remainDeck.discard(player.getCard());
        }
    }
}
