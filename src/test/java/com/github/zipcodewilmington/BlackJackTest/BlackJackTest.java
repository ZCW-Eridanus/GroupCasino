package com.github.zipcodewilmington.BlackJackTest;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.cardGame.Deck;
import com.github.zipcodewilmington.casino.games.cardGame.Hand;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlackJackTest {

@Test
public void hitTest() {
  Deck d = new Deck();
  BlackJackPlayer player = new BlackJackPlayer(new CasinoAccount(null, null));
  player.hit(d.dealCard());

  Integer expected = 1;
  Integer actual = player.getHand().size();
  assertEquals(expected, actual);
}

@Test
public void bustTest() {
  Hand h = new Hand();
  Integer score = 0; // given that there's a new hand and a new score
  Deck d = new Deck();

  h.addCard(d.dealCard());
  h.addCard(d.dealCard());
  h.addCard(d.dealCard());
  h.addCard(d.dealCard());
  h.addCard(d.dealCard());
  h.addCard(d.dealCard());
  h.addCard(d.dealCard()); // add an absurd amount of cards to the deck


}

@Test
public void blackJackCheckTest() {

}

@Test
public void splitCheckTest() {

}

@Test
public void isAceTest() {

}

@Test
public void isJQK() {

}

@Test
public void changeJQKValueTest() {

}

@Test
public void changeAceValueTest() {

}

@Test
public void isPushTest() {

}

@Test
public void pushTest() {

}

@Test
public void addedFundsTest(){

}

@Test
public void checkWinOrLossTest(){

}

}
