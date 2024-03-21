package com.github.zipcodewilmington.casino.games.cardGame;

import java.util.ArrayList;

public class Hand {
  ArrayList<Card> hand = new ArrayList<>();

  public boolean addCard(Card card) {
    Deck deck = new Deck();

    hand.add(deck.dealCard());
    return true;
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
