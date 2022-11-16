package com.company.card;

import com.company.*;

public class Prince extends Card{

    @Override
    protected int value() {
        return 5;
    }

    @Override
    public void action(PlayerStatus hostPlayer, int number, PlayerStatus clientPlayer, Deck deck, RemainDeck remainDeck, Output output) {
        if(hostPlayer.getCard().cardValue() == 7){
            Card card = new Countess();
            hostPlayer.setCard(card);
            remainDeck.discard(this);
        }
        else {
            output.broadcast_the_card_be_discard(clientPlayer);
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
