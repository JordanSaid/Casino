package com.example.user.casino;

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
    int playerHandValue;
    int dealerHandValue;
    String playerHandValueString;
    String dealerHandValueString;

    TextView playerHand;
    TextView dealerHand;
    TextView playerTotal;
    TextView dealerTotal;
    Button twist;
    Button stick;
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
        player = new Player(playerName);

        playerHand = (TextView) findViewById(R.id.playerHand);
        playerTotal = (TextView) findViewById(R.id.playerTotal);
        dealerHand = (TextView) findViewById(R.id.dealerHand);
        dealerTotal = (TextView) findViewById(R.id.dealerTotal);
        message = (TextView) findViewById(R.id.message);

        players.add(player);
        blackjackGame = new BlackjackGame(players);
        dealer = blackjackGame.getDealer();

        blackjackGame.dealCards();

        playerHandValue = player.getHandValue();
        playerHandValueString = Integer.toString(playerHandValue);

        dealerHandValue = player.getHandValue();
        dealerHandValueString = Integer.toString(dealerHandValue);


        final String playerHand1 = player.getName() + "'s hand: " + player.cardToString(0) + " " + player.cardToString(1);

        playerHand.setText(playerHand1);
        playerTotal.setText(playerHandValueString);

        String dealerHand1 = "Dealer's hand: " + dealer.cardToString(0);
        dealerHand.setText(dealerHand1);

        if (blackjackGame.earlyWinner(player) != null) {
            message.setText(blackjackGame.earlyWinner(player));
        }


        twist = (Button) findViewById(R.id.twist_button);

        twist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.util.Log.d("BlackJack", "twist button clicked");

                blackjackGame.dealCard(player);
                playerHandValue = player.getHandValue();
                playerHandValueString = Integer.toString(playerHandValue);
                playerTotal.setText(playerHandValueString);

                String playerHand2 = playerHand1 + " " + player.cardToString(2);
                playerHand.setText(playerHand2);

                if (blackjackGame.earlyWinner(player) != null) {
                    message.setText(blackjackGame.earlyWinner(player));
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
                dealerHandValue = dealer.getHandValue();
                dealerHandValueString = Integer.toString(dealerHandValue);
                dealerTotal.setText(dealerHandValueString);

//                String dealerHand2 = dealerHand1 + " " + dealer.cardToString(1) + " " + dealer.cardToString(2);
//                dealerHand.setText(dealerHand2);

                if (blackjackGame.earlyWinner(player) != null) {
                    message.setText(blackjackGame.earlyWinner(player));
                }

                blackjackGame.checkWinner(player);
                message.setText(blackjackGame.endOfGameWin(player));
            }
        });
    }
}

