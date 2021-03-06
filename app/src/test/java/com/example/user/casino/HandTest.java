package com.example.user.casino;

import org.junit.Test;
import org.junit.Test.*;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Created by user on 15/12/2016.
 */
public class HandTest {

    Deck deck;
    Card card;
    Card card2;
    Hand hand;

    @Before
    public void before(){
        deck = new Deck();
        card = new Card(SuitType.DIAMONDS, ValueType.TWO);
        card2 = new Card(SuitType.DIAMONDS, ValueType.FIVE);
        hand = new Hand();
    }

    @Test
    public void handStartsEmpty() {
        assertEquals(0, hand.cardCount());
    }

    @Test
    public void canAddCard() {
        hand.addCard(card);
        assertEquals(1, hand.cardCount());
    }

    @Test
    public void canClearHand() {
        hand.addCard(card);
        hand.clearHand();
        assertEquals(0, hand.cardCount());
    }

    @Test
    public void canPlayFirstCard() {
        hand.addCard(card);
        Card shownCard = hand.showCard(0);
        assertEquals("TWO of DIAMONDS", shownCard.toString());
    }

    @Test
    public void canPlaySecondCard() {
        hand.addCard(card);
        hand.addCard(card2);
        Card shownCard = hand.showCard(1);
        assertEquals("FIVE of DIAMONDS", shownCard.toString());
    }

    @Test
    public void canCheckCard() {
        hand.addCard(card);
        hand.addCard(card2);
        Card checkedCard = hand.showCard(1);
        assertEquals("FIVE of DIAMONDS", checkedCard.toString());
    }



}
