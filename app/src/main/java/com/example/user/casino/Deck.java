package com.example.user.casino;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 15/12/2016.
 */
public class Deck implements Deckable{

    private ArrayList<Card> deck;

    public Deck(){

        this.deck = new ArrayList<Card>();
        fillDeck();
        shuffle();

    }

    public void addCard(Card card){
        deck.add(card);

    }

    public Card dealCard(){
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

    public int cardCount(){
        return deck.size();
    }

    public void fillDeck(){
        int index = 0;
        for (SuitType suit : SuitType.values()) {
            for (ValueType value : ValueType.values()) {
                deck.add(index, new Card(suit, value));index++;
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

}
