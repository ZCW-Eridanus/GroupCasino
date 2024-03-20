package com.github.zipcodewilmington.casino.games.cardGame;
import com.github.zipcodewilmington.casino.games.cardGame.Card;
import com.github.zipcodewilmington.casino.games.cardGame.Card.*;

import java.util.Collections;
import java.util.Stack;

public class Deck {
  Stack<Card> deck;

  public Deck() {
    deck = new Stack<>();

    for (Suits s : Suits.values()) {
      for (Ranks r : Ranks.values()){
        Card card = new Card(s, r);
        deck.push(card);
      }
    }

    // Shuffle the cards because why not
    Collections.shuffle(deck);
  }

  public Card dealCard() {
    return deck.pop();
  }

  public Integer getSize() {
    return deck.size();
  }
}
