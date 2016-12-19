package com.example.user.casino;

import org.junit.Test;
import org.junit.Test.*;


import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Created by user on 15/12/2016.
 */
public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card(SuitType.DIAMONDS, ValueType.TWO);
    }

    @Test
    public void hasSuit(){
        assertEquals(SuitType.DIAMONDS, card.getSuit());
    }

    @Test
    public void hasValue(){
        assertEquals(2, card.getValue());
    }

    @Test
    public void convertsToString(){

        assertEquals("TWO of DIAMONDS", card.toString());
    }
}