package com.company.card;

import com.company.Deck;
import com.company.PlayerStatus;
import com.company.RemainDeck;

public class Prince extends Card{

    @Override
    protected int value() {
        return 5;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck) {
        if(hostPlayer.getCard().cardValue() == 7){
            Card card = new Princess();
            hostPlayer.setCard(card);
            remainDeck.discard(this);
        }
        else {
            System.out.print(clientPlayer.getCard());
            remainDeck.discard(clientPlayer.getCard());
            if(deck.cards.size() == 0 || clientPlayer.getCard().cardValue() == 8){
                clientPlayer.setStatus(PlayerStatus.Status.dead);
                remainDeck.discard(clientPlayer.getCard());
            }
            else {
                clientPlayer.setCard(deck.draw());
            }
            remainDeck.discard(this);
        }
    }
}
