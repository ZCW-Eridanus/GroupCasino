package com.github.zipcodewilmington.casino.games.cardGame;

public class Card {

  private Suits suit;
  private Ranks rank;
  public enum Suits {
    SPADES,
    HEARTS,
    DIAMONDS,
    CLUBS;
  }
  public enum Ranks {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;
  }
  public Card(Suits suit, Ranks rank) {
    this.suit = suit;
    this.rank = rank;
  }

  @Override
  public String toString() {
    return "Suit: " + this.suit + ", Rank: " + this.rank;
  }
}