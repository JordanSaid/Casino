package com.example.user.casino;

import org.junit.Test;
import org.junit.Test.*;


import static org.junit.Assert.*;

import org.junit.Before;

import java.util.ArrayList;

/**
 * Created by user on 16/12/2016.
 */
public class BlackjackGameTest {
    ArrayList<Playerable> players;
    Playerable player;
    Playerable AI;
    BlackjackGame game;
    Dealer dealer;

    @Before
    public void before(){
        player = new Player("Jay");
        AI = new Player("AI");
        players = new ArrayList<Playerable>();
        game = new BlackjackGame(players);
        dealer = game.getDealer();
        game.addPlayerToGame(player);
        game.addPlayerToGame(AI);
    }

    @Test
    public void gameHasPlayersTest() {
        assertEquals(3, players.size());
    }

    @Test
    public void canDealCardToPlayersTest1() {
        game.dealCardsToEachPlayer();
        Hand hand = ((Player)player).getHand();
        int count = hand.cardCount();
        assertEquals(2, count);
    }

    @Test
    public void canDealCardToPlayersTest2() {
        game.dealCardsToEachPlayer();
        Hand hand = ((Player)AI).getHand();
        int count = hand.cardCount();
        assertEquals(2, count);
    }

    @Test
    public void canDealCardToDealerTest() {
        game.dealCardsToEachPlayer();
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

}
