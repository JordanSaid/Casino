package com.example.user.casino;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.*;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 20/12/2016.
 */
public class BlackjackGameplayActivity extends AppCompatActivity {

    ArrayList<Playerable> players = new ArrayList<Playerable>();
    Playerable player;
    Playerable dealer;
    BlackjackGame blackjackGame;
    String playerHandValueString;
    String dealerHandValueString;
//    String purse;
//    String bet;
//    int playerBetInt;

//    TextView gameBet;
//    TextView playerPurse;
    TextView playerHand;
    TextView dealerHand;
    TextView playerTotal;
    TextView dealerTotal;
    Button twist;
    Button stick;
    Button playAgain;
    boolean gameInProgress = false;
    TextView message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        android.util.Log.d("Blackjack", "BlackjackGameplayActivity.onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String playerName = extras.getString("playerNameText");
        String playerBetTemp = extras.getString("playerBetText");
//        bet = "Player bet: " + playerBetTemp;
//        playerBetInt = Integer.parseInt(playerBetTemp);

        player = new Player(playerName);

        playerHand = (TextView) findViewById(R.id.playerHand1);
        playerTotal = (TextView) findViewById(R.id.playerTotal);
//        gameBet = (TextView) findViewById(R.id.gameBet);
//        playerPurse = (TextView) findViewById(R.id.playerPurse);

        dealerHand = (TextView) findViewById(R.id.dealerHand1);
        dealerTotal = (TextView) findViewById(R.id.dealerTotal);
        message = (TextView) findViewById(R.id.message);

        players.add(player);
        blackjackGame = new BlackjackGame(players);
        dealer = blackjackGame.getDealer();
        blackjackGame.dealCards();

//        blackjackGame.setBet(player, playerBetInt);
//
//        gameBet.setText(bet);
//
//        purse = "Player purse: " + player.purseToString();
//        playerPurse.setText(purse);


        playerHandValueString = Integer.toString(player.getHandValue());
        dealerHandValueString = Integer.toString(player.getHandValue());


        final String playerHand1 = player.getName() + "'s hand:" + "\n" + player.cardToString(0) + "\n " + player.cardToString(1);

        playerHand.setText(playerHand1);
        playerTotal.setText(playerHandValueString);

        final String dealerHand1 = "Dealer's hand: "  + "\n" + dealer.cardToString(0);
        dealerHand.setText(dealerHand1);

        if (blackjackGame.earlyWinner(player) != null) {
            message.setText(blackjackGame.earlyWinner(player));
            twist.setEnabled(false);
//            purse = "Player purse: " + player.purseToString();
//            playerPurse.setText(purse);
        }


        twist = (Button) findViewById(R.id.twist_button);

        twist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.util.Log.d("BlackJack", "twist button clicked");

                blackjackGame.dealCard(player);
                playerHandValueString = Integer.toString(player.getHandValue());
                playerTotal.setText(playerHandValueString);



                if (player.handCardCount() == 5) {
                    String playerHand4 = playerHand1 + "\n" + player.cardToString(2) + "\n" + player.cardToString(3) + "\n" + player.cardToString(4);
                    playerHand.setText(playerHand4);
                } else if (player.handCardCount() == 4) {
                    String playerHand3 = playerHand1 + "\n" + player.cardToString(2) + "\n" + player.cardToString(3);
                    playerHand.setText(playerHand3);
                } else if (player.handCardCount() == 3) {
                    String playerHand2 = playerHand1 + "\n" + player.cardToString(2);
                    playerHand.setText(playerHand2);
                }

                if (blackjackGame.earlyWinner(player) != null) {
                    message.setText(blackjackGame.earlyWinner(player));
                    twist.setEnabled(false);
//                    purse = "Player purse: " + player.purseToString();
//                    playerPurse.setText(purse);
                }
            }
        });

        stick = (Button) findViewById(R.id.stick_button);

        stick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.util.Log.d("BlackJack", "stick button clicked");

                dealerTotal.setText(dealerHandValueString);

                blackjackGame.dealerWillTwist();
                blackjackGame.dealerWillTwist();
                blackjackGame.dealerWillTwist();
                blackjackGame.dealerWillTwist();
                dealerHandValueString = Integer.toString(dealer.getHandValue());
                dealerTotal.setText(dealerHandValueString);

                if (dealer.handCardCount() == 5) {
                    String dealerHand5 = dealerHand1 + "\n" + dealer.cardToString(1) + "\n" + dealer.cardToString(2) + "\n" + dealer.cardToString(3) + "\n" + dealer.cardToString(4);
                    dealerHand.setText(dealerHand5);
                } else if (dealer.handCardCount() == 4) {
                    String dealerHand4 = dealerHand1 + "\n" + dealer.cardToString(1) + "\n" + dealer.cardToString(2) + "\n" + dealer.cardToString(3);
                    dealerHand.setText(dealerHand4);
                } else if (dealer.handCardCount() == 3) {
                    String dealerHand3 = dealerHand1 + "\n" + dealer.cardToString(1) + "\n" + dealer.cardToString(2);
                    dealerHand.setText(dealerHand3);
                } else if (dealer.handCardCount() == 2) {
                    String dealerHand2 = dealerHand1 + "\n" + dealer.cardToString(1);
                    dealerHand.setText(dealerHand2);
                }


                if (blackjackGame.earlyWinner(player) != null) {
                    message.setText(blackjackGame.earlyWinner(player));
                    twist.setEnabled(false);
//                    purse = "Player purse: " + player.purseToString();
//                    playerPurse.setText(purse);
                }

                blackjackGame.checkWinner(player);
                message.setText(blackjackGame.endOfGameWin(player));
                twist.setEnabled(false);
//                purse = "Player purse: " + player.purseToString();
//                playerPurse.setText(purse);
            }

        });

        playAgain = (Button) findViewById(R.id.playAgain_button);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.util.Log.d("BlackJack", "play again button clicked");
                Intent intent = getIntent();
                finish();
                startActivity(intent);

            };
    });
}}

