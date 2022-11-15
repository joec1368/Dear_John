package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;
import com.company.RemainDeck;

public class King extends Card{

    @Override
    protected int value() {
        return 6;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck) {
        if(hostPlayer.getCard().cardValue() == 7){
            Card card = new Countess();
            hostPlayer.setCard(card);
            remainDeck.discard(this);
        }
        else{
            Card temp;
            temp = hostPlayer.getCard();
            hostPlayer.setCard(clientPlayer.getCard());
            clientPlayer.setCard(temp);
            remainDeck.discard(this);
        }
    }
}
