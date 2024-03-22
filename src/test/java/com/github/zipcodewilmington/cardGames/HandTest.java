package com.github.zipcodewilmington.cardGames;

import com.github.zipcodewilmington.casino.games.cardGame.Card;
import com.github.zipcodewilmington.casino.games.cardGame.Deck;
import com.github.zipcodewilmington.casino.games.cardGame.Hand;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HandTest {

@Test
public void testCardAdded() { // hands should be receiving cards from hand.addCard(deck.dealCard)
  Hand h = new Hand();
  Deck d = new Deck();

  h.addCard(d.dealCard());

  Integer expected = 1;
  Integer actual = h.size();



  Assert.assertEquals(expected, actual);
}

@Test
public void testHandIsEmpty() { // when we initiate a new hand in each instance of a game, it should be empty
  Hand h = new Hand();
  Deck d = new Deck();

  Integer expected = 0;
  Integer actual = h.size();

  Assert.assertEquals(expected, actual);
}
}

 /* for (int i = 0; i < 2; i++) {
  h.addCard(d.dealCard());
  }
  System.out.println(h); */  // put this in one of the values if you'd like to physically see a card in a deck! -Trey & Jacob