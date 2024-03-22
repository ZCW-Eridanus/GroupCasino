package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NumberGuessTest {
    NumberGuessGame numberGuessGame = new NumberGuessGame();
    @BeforeEach
    public void setUp() {
        // Reset game state before each test
        numberGuessGame.isPlaying = true;
        numberGuessGame.guessRemaining = 25;
    }

    @Test
    public void testChosenMysteryNumber() {
        int mysteryNumber = numberGuessGame.chosenMysteryNumber();
        assertTrue(mysteryNumber >= 1 && mysteryNumber <= 10000);
    }

    @Test
    public void testCheckingAgainstTheMysteryNumber() {
        numberGuessGame.mysteryNumber = 50; // Set the mystery number
        numberGuessGame.yourGuess = 30;
        numberGuessGame.checkingAgainstTheMysteryNumber();
        assertEquals("The number is higher!\nYou have 24 remaining", getOutput());

        numberGuessGame.yourGuess = 70;
        numberGuessGame.checkingAgainstTheMysteryNumber();
        assertEquals("The number is lower!\nYou have 23 remaining", getOutput());

        numberGuessGame.yourGuess = 50;
        numberGuessGame.checkingAgainstTheMysteryNumber();
        assertEquals("You guessed the Number!!! WINNER", getOutput());
    }

    @Test
    public void testToPlay() {
        assertEquals("yes", numberGuessGame.toPlay());
        assertEquals("no", numberGuessGame.toPlay());
    }

    @Test
    public void testDidYouLose() {
        numberGuessGame.guessRemaining = 0;
        numberGuessGame.didYouLose();
        assertEquals("You're our of guesses... LOSER!!!", getOutput());
    }

    @Test
    public void testEndTheGame() {
        numberGuessGame.endTheGame();
        assertFalse(numberGuessGame.isPlaying);
    }

    private String getOutput() {
        return System.out.toString().trim();
    }
}