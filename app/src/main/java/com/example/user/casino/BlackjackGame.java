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
            for (Playerable player: players) {
                Card card = dealer.dealCard();

                if (player instanceof Player) {
                    ((Player) player).addCard(card);
                } else dealer.addCard(card);
            }
        }
    }

    public void playerTwist(Playerable player) {
        Card card = dealer.dealCard();
        if (player instanceof Player) {
            ((Player) player).addCard(card);
        } else dealer.addCard(card);
    }

    public void aiTwist(Playerable player) {
        Random rand = new Random();
        int willBet = rand.nextInt(1);
        if (willBet == 1) {
            Card card = dealer.dealCard();
            ((Player) player).addCard(card);
        } else return;
    }


    public void findWinner() {

    }


}
