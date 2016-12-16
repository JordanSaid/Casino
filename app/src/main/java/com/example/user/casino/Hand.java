package com.example.user.casino;

import java.util.ArrayList;

/**
 * Created by user on 15/12/2016.
 */

public class Hand {

    private ArrayList<Card> hand;

    public Hand(){

        this.hand = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void clearHand() {
        hand.clear();
    }

    public Card showCard(int index){
        return (Card)hand.get(index);
    }

    public int cardCount() {
        return hand.size();
    }

    public int getValue() {
        int count = 0;
        for (Card card: hand) {
            count += card.getValue();
        } return count;
    }

}