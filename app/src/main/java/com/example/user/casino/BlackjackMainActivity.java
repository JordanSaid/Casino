package com.example.user.casino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.*;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by user on 19/12/2016.
 */
public class BlackjackMainActivity extends AppCompatActivity{
    EditText playerName;
//    EditText playerBet;
    Button startGame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        android.util.Log.d("Blackjack", "onCreateCalled");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityblackjackhome);

        startGame = (Button) findViewById(R.id.startGame_button);

        playerName = (EditText) findViewById(R.id.playerName);
//        playerBet = (EditText) findViewById(R.id.playerBet);



        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.util.Log.d("BlackJack", "Push button clicked");
                String playerNameText = playerName.getText().toString();
//                String playerBetText = playerBet.getText().toString();

                Log.d("Blackjack", "PlayerName: " + playerNameText);

                Intent intent = new Intent(BlackjackMainActivity.this, BlackjackGameplayActivity.class);
                intent.putExtra("playerNameText", playerNameText);
//                intent.putExtra("playerBetText", playerBetText);


                startActivity(intent);
            }
        });
    }
}
