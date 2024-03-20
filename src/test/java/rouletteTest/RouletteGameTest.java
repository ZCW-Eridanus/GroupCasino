package rouletteTest;

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
        int expected = 2510;
        int actual = rouletteGame.betWithColorRed(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithColorBlack(){
        int number = 4Grou;
        int wager = 10;
        int expected = 2510;
        int actual = rouletteGame.betWithColorBlack(number,wager);
        assertEquals(expected,actual);
    }


    @Test
    public void betWithEvenNumber(){
        int number = 20;
        int wager = 10;
        int expected = 2510;
        int actual = rouletteGame.betWithEvenNumber(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithOddNumber(){
        int number = 19;
        int wager = 10;
        int expected = 2510;
        int actual = rouletteGame.betWithOddNumber(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithLow(){
        int number = 5;
        int wager = 10;
        int expected = 2510;
        int actual = rouletteGame.betWithOddNumber(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithHigh(){
        int number = 25;
        int wager = 10;
        int expected = 2510;
        int actual = rouletteGame.betWithOddNumber(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithColumn1(){
        int number = 1;
        int wager = 10;
        int expected = 2520;
        int actual = rouletteGame.betWithColumn1(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithColumn2(){
        int number = 2;
        int wager = 10;
        int expected = 2520;
        int actual = rouletteGame.betWithColumn2(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithColumn3(){
        int number = 3;
        int wager = 10;
        int expected = 2520;
        int actual = rouletteGame.betWithColumn3(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithSingle(){
        int number = 3;
        int wager = 2;
        int expected = 2570;
        int actual = rouletteGame.betWithSingle(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithDozen1(){
        int number = 3;
        int wager = 10;
        int expected = 2520;
        int actual = rouletteGame.betWithColumn3(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithDozen2(){
        int number = 3;
        int wager = 10;
        int expected = 2520;
        int actual = rouletteGame.betWithColumn3(number,wager);
        assertEquals(expected,actual);
    }

    @Test
    public void betWithDozen3(){
        int number = 3;
        int wager = 10;
        int expected = 2520;
        int actual = rouletteGame.betWithColumn3(number,wager);
        assertEquals(expected,actual);
    }
}
