package com.example.user.casino;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 15/12/2016.
 */
public class UnshuffledDeck implements Deckable {

    private ArrayList<Card> unshuffledDeck;

    public UnshuffledDeck() {

        this.unshuffledDeck = new ArrayList<Card>();
        fillDeck();
    }

    public Card dealCard(){
        Card card = unshuffledDeck.get(0);
        unshuffledDeck.remove(0);
        return card;
    }

    public void fillDeck(){
        int index = 0;
        for (SuitType suit : SuitType.values()) {
            for (ValueType value : ValueType.values()) {
                unshuffledDeck.add(index, new Card(suit, value));index++;
            }
        }
    }


}
