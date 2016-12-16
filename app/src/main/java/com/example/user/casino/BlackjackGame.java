package com.example.user.casino;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 15/12/2016.
 */
public class BlackjackGame {
    private ArrayList<Playerable> players;
    private Dealer dealer;

    public BlackjackGame(ArrayList<Playerable> players) {
        dealer = new Dealer();
        this.players = players;
        addPlayerToGame(dealer);
    }

    public Dealer getDealer(){
        return dealer;
    }

    public void addPlayerToGame(Playerable player) {
        players.add(player);
    }

    public void dealCardsToEachPlayer() {
        for (int i = 0; i < 2; i++) {
            for (Playerable player : players) {
                Card card = dealer.dealCard();
                player.addCard(card);
            }
        }
    }

    public void twist(Playerable player) {
        Card card = dealer.dealCard();
        player.addCard(card);
    }

    public void aiWillTwist(Playerable player) {
        int value = player.getHandValue();
        if (value < 12) {
            Card card = dealer.dealCard();
            player.addCard(card);

        } else if (value <= 15) {
            Random rand = new Random();
            int willBet = rand.nextInt(2) + 1;
            if (willBet == 1) {
                Card card = dealer.dealCard();
                player.addCard(card);
            }
        } else if(value <= 17) {
            Random rand = new Random();
            int willBet = rand.nextInt(4) + 1;
            if (willBet == 1) {
                Card card = dealer.dealCard();
                player.addCard(card);
            }
        }
    }

    public void dealerWillTwist() {
        Hand hand = dealer.getHand();
        int value = hand.getValue();
        if (value < 17) {
            Card card = dealer.dealCard();
            dealer.addCard(card);
        }
    }


    public Playerable checkWinner() {
        int count = 0;
        int[] scores = new int[players.size()];

        for (Playerable player: players) {
            scores[count] = player.getHandValue();
            count ++;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < scores.length; i++) {
            if(scores[i] > max) {
                max = scores[i];
                }
            }


        if (player instanceof Dealer) {

        }
    }


}
