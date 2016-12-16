package com.example.user.casino;

import java.util.Random;

/**
 * Created by user on 15/12/2016.
 */
public class Dealer implements Playerable{

    private String name;
    private Hand hand;
    private Deck deck;

    public Dealer(){
        this.name = "Dealer";
        this.hand = new Hand();
        this.deck = new Deck();
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

    public Deck getDeck() {
        return this.deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Card dealCard(){
        return deck.dealCard();
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int bet() {
        Random rand = new Random();
        int bet = rand.nextInt(50 - 10) + 10;
        return bet;
    }


}
