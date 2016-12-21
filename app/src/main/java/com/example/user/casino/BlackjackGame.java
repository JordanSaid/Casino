package com.example.user.casino;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 15/12/2016.
 */
public class BlackjackGame {
    private ArrayList<Playerable> players;
    private Playerable dealer;
    private int bet;

    public BlackjackGame(ArrayList<Playerable> players) {
        dealer = new Dealer();
        this.players = players;
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

    public void setBetAI(Playerable player) {
        int bet = ((Player)player).bet();
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
        return ((Dealer)dealer);
    }

    public void addPlayerToGame(Playerable player) {
        players.add(player);
    }

    public void dealCard(Playerable player) {
        Card card = ((Dealer)dealer).dealCard();
        player.addCard(card);
    }

    public String cardToString(int index) {
        Deckable deck = ((Dealer)dealer).getDeck();
        Card card = deck.checkCard(index);
        return card.toString();
    }

    public void dealCards() {
        for (int i = 0; i < 2; i++) {
            Card card = ((Dealer)dealer).dealCard();
            dealer.addCard(card);
            for (Playerable player : players) {
                Card card1 = ((Dealer)dealer).dealCard();
                player.addCard(card1);
            }
        }
    }

    public void twist(Playerable player) {
        Card card = ((Dealer)dealer).dealCard();
        player.addCard(card);
    }

    public void aiWillTwist(Playerable player) {
        int value = player.getHandValue();
        if (value < 12) {
            Card card = ((Dealer)dealer).dealCard();
            player.addCard(card);

        } else if (value <= 15) {
            Random rand = new Random();
            int willTwist = rand.nextInt(2) + 1;
            if (willTwist == 1) {
                Card card = ((Dealer)dealer).dealCard();
                player.addCard(card);
            }
        } else if(value <= 17) {
            Random rand = new Random();
            int willTwist = rand.nextInt(4) + 1;
            if (willTwist == 1) {
                Card card = ((Dealer)dealer).dealCard();
                player.addCard(card);
            }
        }
    }

    public void dealerWillTwist() {
        Hand hand = dealer.getHand();
        int value = hand.getValue();
        if (value < 17) {
            Card card = ((Dealer)dealer).dealCard();
            dealer.addCard(card);
        }
    }

    public Playerable checkWinner(Playerable player) {
        if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() < 22) {
            int purse = player.getPurse();
            purse += bet;
            player.setPurse(purse);
            return player;
        } else if (player.getHandValue() < dealer.getHandValue() && dealer.getHandValue() < 22) {
            int purse = dealer.getPurse();
            purse += bet;
            dealer.setPurse(purse);
            return dealer;
        } else if (player.getHandValue() < dealer.getHandValue() && dealer.getHandValue() > 22) {
            int purse = player.getPurse();
            purse += bet;
            player.setPurse(purse);
            return player;
        } return dealer;
    }

    public String endOfGameWin(Playerable player) {
        if (checkWinner(player) == player ) {
            return player.getName() + "wins with: " + player.getHandValue();
        } else if (checkWinner(player) == dealer) {
            return "Dealer wins with: " + dealer.getHandValue();
        } return null;
    }

    public boolean earlyWin(Playerable player) {
        if (player.getHandValue() > 21 || dealer.getHandValue() > 21) {
            return true;
        } else if (player.cardCount() > 4 || dealer.cardCount() > 4) {
            return true;
        } return false;
    }

    public String earlyWinningMethod(Playerable player) {
        if (earlyWin(player) && checkWinner(player) == dealer) {
            if (dealer.getHandValue() == 21) {
                return "Dealer wins with 21";
            } else if (dealer.cardCount() > 4) {
                return "Dealer wins with 5 card trick";
            } else return player.getName() + " went bust, Dealer wins";
        } else if (earlyWin(player) && checkWinner(player) == player) {
            if (player.getHandValue() == 21) {
                return player.getName() + " wins with 21";
            } else if (player.cardCount() > 4) {
                return player.getName() + " wins with 5 card trick";
            } else return "Dealer went bust, " + player.getName() + " wins";
        }return null;
    }

    public String earlyWinner(Playerable player) {
        if (earlyWin(player)) {
            Playerable gameWinner = checkWinner(player);
            return earlyWinningMethod(player);
        } return null;
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

