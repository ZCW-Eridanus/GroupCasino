package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardGame.Card;
import com.github.zipcodewilmington.casino.games.cardGame.Deck;
import com.github.zipcodewilmington.casino.games.cardGame.Hand;

import java.util.ListIterator;

public class BlackJackPlayer implements PlayerInterface {

  CasinoAccount acct;
  Hand hand = new Hand();
  Integer score = 0;


  public int scoreHand(Hand hand2) {

    System.out.println(hand2);
    int handScore = 0;

    ListIterator<Card> cardIterator = hand2.listIterator();

    while (cardIterator.hasNext()) {
      switch(cardIterator.next().getRank()){
        case TWO:
          handScore += 2;
          break;
        case THREE:
          handScore += 3;
          break;
        case FOUR:
          handScore += 4;
          break;
        case FIVE:
          handScore += 5;
          break;
        case SIX:
          handScore += 6;
          break;
        case SEVEN:
          handScore += 7;
          break;
        case EIGHT:
          handScore += 8;
          break;
        case NINE:
          handScore += 9;
          break;
        case TEN:
        case JACK:
        case QUEEN:
        case KING:
          handScore += 10;
          break;
        case ACE:
          handScore += 11;
          // until we do method for ace, but this is ok
          break;
      }
    }
    System.out.println(handScore);
    return handScore;
  }






  public Hand getHand() {
    return this.hand;
  }

  public Card hit() {
    Deck deck = new Deck();
    return deck.dealCard();
  }

  public String stay() {
    return "This user has chosen to stay.";
  }

  public BlackJackPlayer(CasinoAccount acct) { this.acct = acct;
  }

  @Override
  public CasinoAccount getAccount() {
    return this.acct;
  }

  @Override
  public <SomeReturnType> SomeReturnType play() {
    return null;
  }
}
