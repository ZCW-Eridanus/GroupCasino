package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardGame.Card;
import com.github.zipcodewilmington.casino.games.cardGame.Hand;

public class BlackJackPlayer implements PlayerInterface {

  Hand hand = new Hand();
  Integer score = 0;


  public void scoreHand() {

    for (Card card : hand) { // for each card in the hand

      switch (card.getRank()) {
        case TWO:
          score += 2;
          break;
        case THREE:
          score += 3;
          break;
        case FOUR:
          score += 4;
          break;
        case FIVE:
          score += 5;
          break;
        case SIX:
          score += 6;
          break;
        case SEVEN:
          score += 7;
          break;
        case EIGHT:
          score += 8;
          break;
        case NINE:
          score += 9;
          break;
        case TEN:
        case JACK:
        case QUEEN:
        case KING:
          score += 10;
          break;
        case ACE:
          score += 11;
          // until we do method for ace, but this is ok
          break;
      }

    }
  }

  public int getScore() {
    return this.score;
  }

  public Hand getHand() {
    return this.hand;
  }

  public void hit(Card card) {
    hand.addCard(card);
  }

  public BlackJackPlayer(CasinoAccount acct) {
  }

  @Override
  public CasinoAccount getAccount() {
    return null;
  }

  @Override
  public <SomeReturnType> SomeReturnType play() {
    return null;
  }
}
