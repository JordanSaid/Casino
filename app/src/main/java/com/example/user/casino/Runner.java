package com.example.user.casino;

/**
 * Created by user on 19/12/2016.
 */
import java.util.ArrayList;

public class Runner  {
    private ArrayList<Playerable> players;
    private Playerable player;
    private Playerable AI;
    private BlackjackGame game;
    private Dealer dealer;
    private Deckable deck;
    private Log log;

    public Runner (Log log) {
        player = new Player("Player");
        AI = new Player("AI");
        players = new ArrayList<Playerable>();
        game = new BlackjackGame(players);
        dealer = game.getDealer();
        this.log = log;

    }

    private void dealCards() {
        Hand hand;
        game.dealCards();
        setBet(player, log.addBet(game.getBet()));

        for (Playerable player : players) {
            log.add(player.getName());

            hand = player.getHand();
            ArrayList<Card> cards = hand.getHand();
            for (Card card: cards) {
                log.add(card.toString());
            }


            String total = "Total: " + player.getHandValue();
            log.add(total);
            log.add("");
        }
    }

    private void findWinner() {
        int indexOfWinner = players[0].getHandValue() > players[1].getHandValue() ? 0 : 1;
        String result = players[indexOfWinner].getName() + " wins!";
        log.add(result);
    }

    public void play() {
        deck.shuffle();
        dealCards();
        findWinner();
        log.print();
    }
}
