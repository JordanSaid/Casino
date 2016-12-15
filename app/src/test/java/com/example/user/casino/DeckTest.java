package com.example.user.casino;

import org.junit.Test;
import org.junit.Test.*;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Created by user on 15/12/2016.
 */
public class DeckTest {

    Deck deck;
    Card card;
    UnshuffledDeck unshuffledDeck;

    @Before
    public void before(){
        deck = new Deck();
        card = new Card(SuitType.DIAMONDS, ValueType.TWO);
        unshuffledDeck = new UnshuffledDeck();
    }

    @Test
    public void deckHas52CardsTest(){
        assertEquals(52, deck.cardCount());
    }

    @Test
    public void canAddCard(){
        deck.addCard(card);
        assertEquals(53, deck.cardCount());
    }

    @Test
    public void canDealCard(){
        Card returnedCard = unshuffledDeck.dealCard();

        assertEquals("ACE of DIAMONDS", returnedCard.toString());
        assertEquals(51, unshuffledDeck.cardCount());
    }


}
