package com.example.user.casino;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 15/12/2016.
 */
public class Dealer implements Playerable{

    private String name;
    private Hand hand;
    private Deckable deck;
    private int purse;

    public Dealer(){
        this.name = "Dealer";
        this.hand = new Hand();
        this.deck = new Deck();
        this.purse = 0;
    }

    public int getPurse() {
        return this.purse;
    }

    public void setPurse(int purse) {
        this.purse = purse;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return this.hand;
    }

    public Deckable getDeck() {
        return this.deck;
    }

    public void setDeck(Deckable deck) {
        this.deck = deck;
    }

    public Card dealCard(){
        return deck.dealCard();
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getHandValue() {
        Hand hand = getHand();
        return hand.getValue();
    }

    public int handCardCount() {
        Hand hand = getHand();
        return hand.cardCount();
    }

    public String cardToString(int index) {
        Hand hand = getHand();
        Card card = hand.showCard(index);
        return card.toString();
    }

    public int cardCount() {
        Hand hand = getHand();
        ArrayList<Card> cards = hand.getHand();
        return cards.size();
    }


}
