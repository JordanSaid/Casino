package com.example.user.casino;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 15/12/2016.
 */
public class BlackjackGame {
    private ArrayList<Playerable> players;
    private Dealer dealer;
    private int bet;

    public BlackjackGame(ArrayList<Playerable> players) {
        dealer = new Dealer();
        this.players = players;
        addPlayerToGame(dealer);
        this.bet = 0;
    }

    public void setBet(Playerable player, int bet) {
        int purse = player.getPurse();
        purse -= bet;
        player.setPurse(purse);
        if (bet > 5 && bet < 100) {
            this.bet = bet;
        }
    }

    public int getBet() {
        return this.bet;
    }

    public Dealer getDealer(){
        return dealer;
    }

    public void addPlayerToGame(Playerable player) {
        players.add(player);
    }

    public void dealCards() {
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
            int willTwist = rand.nextInt(2) + 1;
            if (willTwist == 1) {
                Card card = dealer.dealCard();
                player.addCard(card);
            }
        } else if(value <= 17) {
            Random rand = new Random();
            int willTwist = rand.nextInt(4) + 1;
            if (willTwist == 1) {
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

    public Playerable checkWinner(Playerable player) {
            if (player.getHandValue() > dealer.getHandValue()) {
                int purse = player.getPurse();
                purse += bet;
                player.setPurse(purse);
                return player;
            }   int purse = dealer.getPurse();
                purse += bet;
                dealer.setPurse(purse);
                return dealer;
    }







}














//    public Playerable checkWinner() {
//        int count = 0;
//        int[] scores = new int[players.size()];
//        ArrayList<Playerable> potWinners = new ArrayList<Playerable>();
//
//        for (Playerable player : players) {
//            scores[count] = player.getHandValue();
//            count++;
//        }
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < scores.length; i++) {
//            if (scores[i] > max) {
//                max = scores[i];
//            }
//        }
//
//        for (Playerable player : players) {
//            if (max == player.getHandValue()) {
//                potWinners.add(player);
//            }
//        }
//
//        for (Playerable player : potWinners) {
//            if (player instanceof Dealer) {
//                return player;
//            } else return potWinners.get(1);
//        }
//
//    }

