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
    Card card5 = new Card(SuitType.HEARTS, ValueType.ACE);
    Card card6 = new Card(SuitType.CLUBS, ValueType.QUEEN);
    Card card7 = new Card(SuitType.CLUBS, ValueType.KING);


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
    public void spyDeckWorksTest() {
        Mockito.when(spyDeck.dealCard()).thenReturn(card);
        assertEquals(spyDeck.dealCard(), card);
    }

    @Test
    public void gameHasPlayersTest() {
        assertEquals(2, players.size());
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
    public void canWinTest() {
        player.addCard(card);
        dealer.addCard(card1);
        AI.addCard(card4);
        player.addCard(card2);
        dealer.addCard(card3);
        AI.addCard(card5);
        assertEquals(game.checkWinner(player), dealer);
        assertEquals(game.checkWinner(AI), AI);
    }

    @Test
    public void canBetTest() {
        game.setBet(player, 50);
        assertEquals(950, player.getPurse());
    }

    @Test
    public void canWinBetTest() {
        player.addCard(card);
        dealer.addCard(card1);
        AI.addCard(card4);
        player.addCard(card2);
        dealer.addCard(card3);
        AI.addCard(card5);
        game.setBet(player, 10);
        game.checkWinner(player);
        assertEquals(10, dealer.getPurse());
    }


}
