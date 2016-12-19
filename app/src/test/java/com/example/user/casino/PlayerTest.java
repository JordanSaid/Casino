package com.example.user.casino;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 15/12/2016.
 */
public class PlayerTest {
    Card card = new Card(SuitType.DIAMONDS, ValueType.TWO);
    Card card1 = new Card(SuitType.DIAMONDS, ValueType.ACE);
    Card card2 = new Card(SuitType.SPADES, ValueType.TEN);
    Card card3 = new Card(SuitType.SPADES, ValueType.SEVEN);
    Card card4 = new Card(SuitType.SPADES, ValueType.JACK);
    Card card5 = new Card(SuitType.HEARTS, ValueType.ACE);
    Card card6 = new Card(SuitType.CLUBS, ValueType.QUEEN);
    Card card7 = new Card(SuitType.CLUBS, ValueType.KING);

    Playerable player;
    Playerable AI;
    Dealer dealer;
    Deckable spyDeck;

    @Before
    public void before(){
        player = new Player("Jay");
        AI = new Player("AI");

        Deckable deck = dealer.getDeck();
        spyDeck = Mockito.spy(deck);
        dealer.setDeck(spyDeck);

    }

    @Test
    public void playerCanAddCardToHandTest() {
        player.addCard(card);
        assertEquals(1, player.cardCount());
    }
}
