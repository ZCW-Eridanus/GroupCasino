package com.github.zipcodewilmington.bigWheelTest;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.BigWheel.BigWheelGame;
import org.junit.Test;

import static org.junit.Assert.*;

public class BigWheelGameTest {
    BigWheelGame bigWheelGame = new BigWheelGame();


    @Test
    public void validateTest(){
        int balance = 500;
        int wagerAmount = 1000;
        assertFalse(bigWheelGame.validateWagerInput(1000));
    }
    @Test
    public void winningMeethod1() {
        bigWheelGame.wagerAmount = 5;
        String winningNumber = "5";

        // When
        int winnings = bigWheelGame.calculateWinnings(winningNumber);

        // Then
        assertEquals(25, winnings);
    }

}
