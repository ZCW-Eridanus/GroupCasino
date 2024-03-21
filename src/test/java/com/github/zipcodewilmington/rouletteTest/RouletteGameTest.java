package com.github.zipcodewilmington.rouletteTest;

import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RouletteGameTest {
    RouletteGame rouletteGame = new RouletteGame();
    @Test
    public void betWithColorRed(){
        String color = "red";
        int wager = 10;
        int expected = 510;
        int actual = rouletteGame.betWithColorRed(color,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithColorBlack(){
        String color = "black";
        int wager = 10;
        int expected = 510;
        int actual = rouletteGame.betWithColorBlack(color,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithColorRedAndBlack(){
        String black = "black";
        String red =  "red";
        int wager = 10;
        int expected = 510;
        int actual = rouletteGame.betWithColorRedAndBlack(red,black,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithEvenNumber(){
        int number = 20;
        int wager = 10;
        int expected = 510;
        int actual = rouletteGame.betWithEvenNumber(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithOddNumber(){
        int number = 19;
        int wager = 10;
        int expected = 510;
        int actual = rouletteGame.betWithOddNumber(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithColumn1(){
        int number = 1;
        int wager = 10;
        int expected = 520;
        int actual = rouletteGame.betWithColumn1(wager,number);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithColumn2(){
        int number = 2;
        int wager = 10;
        int expected = 520;
        int actual = rouletteGame.betWithColumn2(wager,number);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithColumn3(){
        int number = 3;
        int wager = 10;
        int expected = 520;
        int actual = rouletteGame.betWithColumn3(wager,number);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithSingle(){
        int number = 3;
        int wager = 2;
        int expected = 570;
        int actual = rouletteGame.betWithSingle(wager,number);
        assertEquals(expected,actual);
    }

}
