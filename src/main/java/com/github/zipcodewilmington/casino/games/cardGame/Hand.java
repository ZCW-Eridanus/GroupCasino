package com.github.zipcodewilmington.casino.games.cardGame;

import com.github.zipcodewilmington.casino.games.cardGame.Card;

import java.util.ArrayList;

public class Hand {
  ArrayList<Card> cards = new ArrayList<>();

  public boolean addCard(Card card) {
    cards.add(card);
    return true;
  }

  public ArrayList<Card> getCards() {
    return this.cards;
  }
}
