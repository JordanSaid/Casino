package com.example.user.casino;

/**
 * Created by user on 19/12/2016.
 */
public interface Deckable {
    Card dealCard();
    void fillDeck();
    int cardCount();
    void addCard(Card card);
    Card checkCard(int index);
}
