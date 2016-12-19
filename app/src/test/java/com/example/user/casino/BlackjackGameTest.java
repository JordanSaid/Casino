package com.example.user.casino;

import org.junit.Test;
import org.junit.Test.*;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.ArrayList;
import org.mockito.*;
import static org.mockito.Mockito.*;


/**
 * Created by user on 16/12/2016.
 */
public class BlackjackGameTest {
    Card card = new Card(SuitType.DIAMONDS, ValueType.TWO);
    Card card1 = new Card(SuitType.DIAMONDS, ValueType.ACE);
    Card card2 = new Card(SuitType.SPADES, ValueType.TEN);
    Card card3 = new Card(SuitType.SPADES, ValueType.SEVEN);
    Card card4 = new Card(SuitType.SPADES, ValueType.JACK);



    ArrayList<Playerable> players;
    Playerable player;
    Playerable AI;
    BlackjackGame game;
    Dealer dealer;
    Deckable spyDeck;

    @Before
    public void before(){
        player = new Player("Jay");
        AI = new Player("AI");
        players = new ArrayList<Playerable>();
        game = new BlackjackGame(players);
        dealer = game.getDealer();

        Deckable deck = dealer.getDeck();
        spyDeck = Mockito.spy(deck);
        dealer.setDeck(spyDeck);

        game.addPlayerToGame(player);
        game.addPlayerToGame(AI);

    }


    @Test
    public void testTakeTurnFailureStub() {


        Mockito.when(spyDeck.dealCard()).thenReturn(card);

        boolean result = game.nextTurn();
        assertEquals(false, result);
    }

    @Test
    public void gameHasPlayersTest() {
        assertEquals(3, players.size());
    }

    @Test
    public void canDealCardToPlayersTest1() {
        game.dealCards();
        Hand hand = ((Player)player).getHand();
        int count = hand.cardCount();
        assertEquals(2, count);
    }

    @Test
    public void canDealCardToPlayersTest2() {
        game.dealCards();
        Hand hand = ((Player)AI).getHand();
        int count = hand.cardCount();
        assertEquals(2, count);
    }

    @Test
    public void canDealCardToDealerTest() {
        game.dealCards();
        Hand hand = dealer.getHand();
        int count = hand.cardCount();
        assertEquals(2, count);
    }

    @Test
    public void playerCanTwistTest() {
        game.twist(player);
        Hand hand = ((Player)player).getHand();
        int count = hand.cardCount();
        assertEquals(1, count);
    }

    @Test
    public void dealerCanTwistTest() {
        game.twist(dealer);
        Hand hand = dealer.getHand();
        int count = hand.cardCount();
        assertEquals(1, count);
    }

    @Test
    public void aiCanTwistTest() {
        game.twist(AI);
        Hand hand = ((Player)AI).getHand();
        int count = hand.cardCount();
        assertEquals(1, count);

    }

    @Test
    public void playerCanWinTest() {
        game.dealCards();

    }

//    player 1, 4
//    ai 5, 8
//    dealer

}
