package com.example.user.casino;

/**
 * Created by user on 15/12/2016.
 */
public class Card {

    private SuitType suit;
    private ValueType value;

    public Card(SuitType suit, ValueType value){
        this.suit = suit;
        this.value = value;
    }

    public SuitType getSuit(){
        return this.suit;
    }

    public int getValue(){
        return (this.value.ordinal() + 1);
    }

    public String toString(){
        return this.value + " of " + this.suit;
    }

}
