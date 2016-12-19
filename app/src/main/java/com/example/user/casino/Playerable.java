package com.example.user.casino;

/**
 * Created by user on 15/12/2016.
 */
public interface Playerable {
    int getHandValue();
    Hand getHand();
    void addCard(Card card);
    int getPurse();
    void setPurse(int purse);
    int cardCount();
}
