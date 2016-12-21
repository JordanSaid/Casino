package com.example.user.casino;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 15/12/2016.
 */
public class Player implements Playerable{

    private String name;
    public Hand hand;
    private int purse;

    public Player(){
        this.name = "Player";
        this.hand = new Hand();
        this.purse = 1000;
    }

    public Player(String name){
        this.name = name;
        this.hand = new Hand();
        this.purse = 1000;
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

    public int getPurse() {
        return this.purse;
    }

    public void setPurse(int purse) {
        this.purse = purse;
    }

    public int bet() {
        Random rand = new Random();
        int bet = rand.nextInt(100 - 5) + 5;
        return bet;
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