package com.company;

import com.company.card.Card;

import java.util.Map;

public class RemainDeck {
    private Map<Integer , Integer > remain = Map.of(
            1,5,
            2,2,
            3,2,
            4,2,
            5,2,
            6,1,
            7,1,
            8,1
    );
    void minus(int value){
        int temp = remain.get(value);
        remain.replace(value,temp-1);
    }

    void discard(Card card) {
        int remainCount = remain.get(card.cardValue());
        remain.replace(card.cardValue(), remainCount - 1);
    }
}
