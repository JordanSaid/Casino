package com.example.user.casino;

/**
 * Created by user on 15/12/2016.
 */
public class Player {

    private String name;
    private Hand hand;
    private int purse;

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

}