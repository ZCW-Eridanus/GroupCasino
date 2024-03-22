package com.github.zipcodewilmington.casino.games.cardGame;

import com.github.zipcodewilmington.casino.games.blackjack.BlackJack;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackPlayer;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {
  ArrayList<Card> hand = new ArrayList<>();

  public boolean addCard(Card card) {
    hand.add(card);
    return true;
  }

  public int addValuedCard (Card card) {
    int handScore = 0;

    hand.add(card);

    switch(card.getRank()){
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

    return handScore;
  }

  public int size() { return hand.size(); }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Hand: { ");
    for (int i = 0; i < hand.size(); i++) {
      sb.append(hand.get(i).toString());
      if (i < hand.size() - 1) {
        sb.append(", ");
      }
    }
    sb.append(" }");
    return sb.toString();
  }
}



