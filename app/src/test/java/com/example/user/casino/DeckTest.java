package com.example.user.casino;

import org.junit.Test;
import org.junit.Test.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.mockito.Mockito;

/**
 * Created by user on 15/12/2016.
 */
public class DeckTest {
    Card card = new Card(SuitType.DIAMONDS, ValueType.TWO);
    Card card1 = new Card(SuitType.DIAMONDS, ValueType.ACE);
    Card card2 = new Card(SuitType.SPADES, ValueType.TEN);
    Card card3 = new Card(SuitType.SPADES, ValueType.SEVEN);
    Card card4 = new Card(SuitType.SPADES, ValueType.JACK);
    Card card5 = new Card(SuitType.HEARTS, ValueType.ACE);
    Card card6 = new Card(SuitType.CLUBS, ValueType.QUEEN);
    Card card7 = new Card(SuitType.CLUBS, ValueType.KING);

    Dealer dealer;
    Deckable deck;
    Deckable spyDeck;

    @Before
    public void before(){

        deck = dealer.getDeck();
        spyDeck = Mockito.spy(deck);
        dealer.setDeck(spyDeck);
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
        Mockito.when(spyDeck.dealCard()).thenReturn(card);
        assertEquals(spyDeck.dealCard(), card);
    }


}
