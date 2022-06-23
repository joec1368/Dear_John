package com.company;

import com.company.card.*;

import java.util.*;

public class Deck {
    public List<Card> cards = new ArrayList<>(List.of(
            new Guard(),new Guard(),new Guard(),new Guard(),new Guard(),
            new Priest(),new Priest(),
            new Baron(),new Baron(),
            new HandMaid(),new HandMaid(),
            new Prince(),new Prince(),
            new King(),new Countess(),new Princess()
    ));

    Deck(){
        Collections.shuffle(cards);
    }
    public Card draw(){
        if(cards.size() == 0) return null;
        Card temp = cards.get(cards.size()-1);
        cards.remove(cards.size()-1);
        return temp;
    }


}
