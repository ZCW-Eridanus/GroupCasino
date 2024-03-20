package BlackJackTest;

import com.github.zipcodewilmington.casino.games.Card;
import com.github.zipcodewilmington.casino.games.Deck;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class DeckTest {
  @Test
  public void testDeckConstructor() {
    Deck d = new Deck();
    // TODO actually test this
  }

  @Test
  public void testDealCard() {
    Deck d = new Deck();
    int originalSize = 52;
    Card dealtCard = d.dealCard();
    int newSize = d.getSize();

    assertEquals(originalSize - 1, newSize);
    assertNotNull(dealtCard);
    assertTrue(dealtCard instanceof Card);
  }

  @Test
  public void testDealCardEmptyDeck() {
    Deck d = new Deck();
    int numToDeal = 52;
    for (int i = 0; i < numToDeal; i++) {
      d.dealCard();
    }

    assertEquals(52 - numToDeal, (int) d.getSize());

    try {
      d.dealCard();
      fail();
    } catch (EmptyStackException expected) {
      assertTrue(true);
    }
  }
}