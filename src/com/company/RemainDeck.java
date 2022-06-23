package com.company;

import com.company.card.Card;

import java.util.HashMap;
import java.util.Map;

public class RemainDeck {
    public Map<Integer , Integer > remain = new HashMap<>(){
        {
                    put(1, 5);
                    put(2, 2);
                    put(3, 2);
                    put(4, 2);
                    put(5, 2);
                    put(6, 1);
                    put(7, 1);
                    put(8, 1);
        }};
    void minus(int value){
        int temp = remain.get(value);
        remain.replace(value,temp-1);
    }

    public void discard(Card card) {
        int remainCount = remain.get(card.cardValue());
        remain.replace(card.cardValue(), remainCount - 1);
    }
}
