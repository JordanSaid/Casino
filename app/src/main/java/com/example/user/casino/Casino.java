package com.example.user.casino;

import java.util.ArrayList;

/**
 * Created by user on 15/12/2016.
 */
public class Casino {
    private int earnings;
    private ArrayList<Playerable> customers;

    public Casino(){
        earnings = 0;
        customers = new ArrayList<Playerable>();
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }

    public void addPlayer(Playerable playerable) {
        customers.add(playerable);
    }

    public void updateEarnings(int money) {
        earnings += money;
    }

}
