package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.ThreeCardPoker.ThreeCardPokerGame;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
public class ThreeCardPokerTest {
        @Test
        public void testSetWager_ValidAmount() {
            ThreeCardPokerGame game = new ThreeCardPokerGame();
            game.balance = 100; // Set an initial balance
            game.scanner = new Scanner("50\n"); // Simulate user input of 50

            game.setWager(game.playWagerAmount);

            assertEquals(50, game.playWagerAmount);
            assertEquals(50, game.balance);
        }

        @Test
        public void testSetWager_InvalidAmount() {
            ThreeCardPokerGame game = new ThreeCardPokerGame();
            game.balance = 100; // Set an initial balance
            game.scanner = new Scanner("60\n70\n"); // Simulate user input of 60 and then 70

            game.setWager(game.playWagerAmount);

            assertEquals(70, game.playWagerAmount);
            assertEquals(30, game.balance); // Balance should be decreased by 70
        }
    @Test
    public void testPairPlus_ValidAmount() {
        ThreeCardPokerGame game = new ThreeCardPokerGame();
        game.balance = 100; // Set an initial balance
        game.playWagerAmount = 20; // Set an initial play wager amount
        game.scanner = new Scanner("15\n"); // Simulate user input of 15

        game.pairPlus(0);

        assertTrue(game.pairPlus);
        assertEquals(15, game.balance); // Balance should be decreased by 15
    }

    @Test
    public void testPairPlus_InvalidAmount() {
        ThreeCardPokerGame game = new ThreeCardPokerGame();
        game.balance = 100; // Set an initial balance
        game.playWagerAmount = 20; // Set an initial play wager amount
        game.scanner = new Scanner("50\n30\n"); // Simulate user input of 50 and then 30

        game.pairPlus(0);

        assertFalse(game.pairPlus);
        assertEquals(100, game.balance); // Balance should remain unchanged
    }

    @Test
    public void testValidatePairPlusInput_ValidAmount() {
        ThreeCardPokerGame game = new ThreeCardPokerGame();
        game.playWagerAmount = 20; // Set an initial play wager amount

        boolean isValid = game.validatePairPlusInput(30);

        assertTrue(isValid);
    }

    @Test
    public void testValidatePairPlusInput_InvalidAmount() {
        ThreeCardPokerGame game = new ThreeCardPokerGame();
        game.playWagerAmount = 20; // Set an initial play wager amount

        boolean isValid = game.validatePairPlusInput(50);

        assertFalse(isValid);
    }
    @Test
    public void testPlayYourHand_ValidAmount() {
        ThreeCardPokerGame game = new ThreeCardPokerGame();
        game.balance = 100; // Set an initial balance
        game.scanner = new Scanner("y\n30\n"); // Simulate user input of 'y' and then 30

        game.playYourHand(0);

        assertTrue(game.didTheyPlayHand);
        assertEquals(70, game.balance); // Balance should be decreased by 30
    }

    @Test
    public void testPlayYourHand_InvalidAmount() {
        ThreeCardPokerGame game = new ThreeCardPokerGame();
        game.balance = 100; // Set an initial balance
        game.scanner = new Scanner("y\n150\n20\n"); // Simulate user input of 'y', 150, and then 20

        game.playYourHand(0);

        assertFalse(game.didTheyPlayHand);
        assertEquals(100, game.balance); // Balance should remain unchanged
    }

    @Test
    public void testValidatePlayYourHandInput_ValidAmount() {
        ThreeCardPokerGame game = new ThreeCardPokerGame();
        game.balance = 100; // Set an initial balance

        boolean isValid = game.validatePlayYourHandInput(50);

        assertTrue(isValid);
    }

    @Test
    public void testValidatePlayYourHandInput_InvalidAmount() {
        ThreeCardPokerGame game = new ThreeCardPokerGame();
        game.balance = 100; // Set an initial balance

        boolean isValid = game.validatePlayYourHandInput(150);

        assertFalse(isValid);
    }




    }

