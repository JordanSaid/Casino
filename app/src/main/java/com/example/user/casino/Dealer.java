package com.example.user.casino;

/**
 * Created by user on 15/12/2016.
 */
public class Dealer {

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

    public void setPurse(Deck deck) {
        this.deck = deck;
    }

}
