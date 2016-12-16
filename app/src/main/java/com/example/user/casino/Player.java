package com.example.user.casino;

import java.util.Random;

/**
 * Created by user on 15/12/2016.
 */
abstract class Player implements Playerable{

    private String name;
    public Hand hand;
    private int purse;

    public Player(){
        this.name = "Player";
        this.hand = new Hand();
        int purse = 1000;
    }

    public Player(String name){
        this.name = name;
        this.hand = new Hand();
        int purse = 1000;
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
        int bet = rand.nextInt(50 - 10) + 10;
        return bet;
    }

    public int bet(int bet) {
        purse -= bet;
        return bet;
    }

    public void win(int pot) {
        purse += pot;
    }

    public void addCard(Card card) {
        hand.addCard(card);
    }

    public int getHandValue() {
        Hand hand = getHand();
        return hand.getValue();
    }




}