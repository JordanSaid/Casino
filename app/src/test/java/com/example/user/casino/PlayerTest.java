package com.example.user.casino;


import org.junit.Before;
import org.junit.Test;
import org.junit.Test.*;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.ArrayList;
import org.mockito.*;
import static org.mockito.Mockito.*;

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
    Deckable deck;

    @Before
    public void before(){
        player = new Player("Jay");
        AI = new Player("AI");
        dealer = new Dealer();
        deck = dealer.getDeck();
        spyDeck = Mockito.spy(deck);
        dealer.setDeck(spyDeck);

    }

    @Test
    public void playerCanAddCardToHandTest() {
        player.addCard(card);
        assertEquals(1, player.handCardCount());
    }

    @Test
    public void getHandValueIsAccurateWithoutAceOrFaceCardsTest() {
        player.addCard(card);
        player.addCard(card2);
        assertEquals(12, player.getHandValue());
    }

    @Test
    public void getHandValueIsAccurateWithoutAceButWithFaceCardsTest() {
        player.addCard(card7);
        player.addCard(card6);
        assertEquals(20, player.getHandValue());
    }

    @Test
    public void getHandValueIsAccurateWithAceUnder11Test() {
        player.addCard(card);
        player.addCard(card1);
        assertEquals(13, player.getHandValue());
    }

    @Test
    public void getHandValueIsAccurateWithAceOver11Test() {
        player.addCard(card4);
        player.addCard(card1);
        assertEquals(21, player.getHandValue());
    }

    @Test
    public void getHandValueIsAccurateWith2AcesTest() {
        player.addCard(card5);
        player.addCard(card1);
        assertEquals(12, player.getHandValue());
    }


}