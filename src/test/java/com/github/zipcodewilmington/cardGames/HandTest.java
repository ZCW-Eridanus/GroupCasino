package com.github.zipcodewilmington.cardGames;

import com.github.zipcodewilmington.casino.games.cardGame.Card;
import com.github.zipcodewilmington.casino.games.cardGame.Deck;
import com.github.zipcodewilmington.casino.games.cardGame.Hand;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HandTest {

@Test
public void testCardAdded() {
  Hand h = new Hand();
  Deck d = new Deck();

  h.addCard(d.dealCard());

  Integer expected = 1;
  Integer actual = h.size();

  for (int i = 0; i < 2; i++) {
    h.addCard(d.dealCard());
  }
  System.out.println(h);

  Assert.assertEquals(expected, actual);
}
}
