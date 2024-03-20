package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.Deck;
import org.junit.Test;
import org.junit.Assert;

import static com.github.zipcodewilmington.casino.Card.Suits.*;
import static com.github.zipcodewilmington.casino.Card.Ranks.*;



public class DeckTest {


@Test
public void deckHasSuit() {
    Deck = Stack<Enum, String>;

    Card actual = deck.pop;
    Card expected = HEARTS || SPADES || DIAMONDS || CLUBS;

    Assert.assertEquals(expected, actual);
}

@Test
public void deckHasValue() {
    Deck = Stack<Enum, String>;

    Card actual = deck.pop;
    Card expected = TWO ||THREE || FOUR FIVE SIX SEVEN EIGHT NINE TEN JACK QUEEN KING ACE

    Assert.assertEquals(expected, actual);

    }
}
