package com.example.user.casino;

/**
 * Created by user on 19/12/2016.
 */
import java.util.ArrayList;

public class Log {
    private ArrayList<String> messages;

    public Log() {
        this.messages = new ArrayList<String>();
    }

    public void add(String string) {
        messages.add(string);
    }

    public void addBet(int bet) {
        String betString = Integer.toString(bet);
        messages.add(betString);
    }

    public void print() {
        for (String message : messages) {
            System.out.println(message);
        }
    }
}
