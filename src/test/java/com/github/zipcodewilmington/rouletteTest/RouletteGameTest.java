package com.github.zipcodewilmington.rouletteTest;

import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RouletteGameTest {
    RouletteGame rouletteGame = new RouletteGame();
    @Test
    public void betWithColorRed(){
        int number = 1;
        int wager = 10;
        double expected = 2510;
        double actual = rouletteGame.betWithColorRed(number,wager);
        assertEquals(expected,actual,0.0);
    }

    @Test
    public void betWithColorBlack(){
        int number = 4;
        int wager = 10;
        double expected = 2510;
        double actual = rouletteGame.betWithColorBlack(number,wager);
        assertEquals(expected,actual,0.0);
    }


    @Test
    public void betWithEvenNumber(){
        int number = 20;
        int wager = 10;
        double expected = 2510;
        double actual = rouletteGame.betWithEvenNumber(number,wager);
        assertEquals(expected,actual,0.0);
    }

    @Test
    public void betWithOddNumber(){
        int number = 19;
        int wager = 10;
        double expected = 2510;
        double actual = rouletteGame.betWithOddNumber(number,wager);
        assertEquals(expected,actual,0.0);
    }

    @Test
    public void betWithLow(){
        int number = 5;
        int wager = 10;
        double expected = 2510;
        double actual = rouletteGame.betWithOddNumber(number,wager);
        assertEquals(expected,actual,0.0);
    }

    @Test
    public void betWithHigh(){
        int number = 25;
        int wager = 10;
        double expected = 2510;
        double actual = rouletteGame.betWithOddNumber(number,wager);
        assertEquals(expected,actual,0.0);
    }

    @Test
    public void betWithColumn1(){
        int number = 1;
        int wager = 10;
        double expected = 2520;
        double actual = rouletteGame.betWithColumn1(number,wager);
        assertEquals(expected,actual,0.0);
    }

    @Test
    public void betWithColumn2(){
        int number = 2;
        int wager = 10;
        double expected = 2520;
        double actual = rouletteGame.betWithColumn2(number,wager);
        assertEquals(expected,actual,0.0);
    }

    @Test
    public void betWithColumn3(){
        int number = 3;
        int wager = 10;
        double expected = 2520;
        double actual = rouletteGame.betWithColumn3(number,wager);
        assertEquals(expected,actual,0.0);
    }

    @Test
    public void betWithSingle(){
        int number = 3;
        int wager = 2;
        double expected = 2570;
        double actual = rouletteGame.betWithSingle(number,wager);
        assertEquals(expected,actual,0.0);
    }

    @Test
    public void betWithDozen1(){
        int number = 3;
        int wager = 10;
        double expected = 2520;
        double actual = rouletteGame.betWithColumn3(number,wager);
        assertEquals(expected,actual,0.0);
    }

    @Test
    public void betWithDozen2(){
        int number = 3;
        int wager = 10;
        double expected = 2520;
        double actual = rouletteGame.betWithColumn3(number,wager);
        assertEquals(expected,actual,0.0);
    }

    @Test
    public void betWithDozen3(){
        int number = 3;
        int wager = 10;
        double expected = 2520;
        double actual = rouletteGame.betWithColumn3(number,wager);
        assertEquals(expected,actual,0.0);
    }
}
