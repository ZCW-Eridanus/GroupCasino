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

  public Card(Suits suit, Ranks rank) { // i need to check the cards for value by rank
    this.suit = suit;
    this.rank = rank;
  }

//  @Override
//  public String toString() {
//    return "Suit: " + this.suit + ", Rank: " + this.rank;
//  }

  public Suits getSuit() {
    return this.suit;
  }

  public Ranks getRank() {
    return this.rank;
  }


@Override
  public String toString() {
    String rankString = "";
    String suitSymbol = "";
    switch (this.suit) {
      case DIAMONDS:
        suitSymbol = "♢";
        break;
      case CLUBS:
        suitSymbol = "♧";
        break;
      case SPADES:
        suitSymbol = "♤";
        break;
      case HEARTS:
        suitSymbol = "♡";
        break;
    }
    switch (this.rank) {
      case ACE:
        rankString = "A";
        break;
      case TWO:
        rankString = "2";
        break;
      case THREE:
        rankString = "3";
        break;
      case FOUR:
        rankString = "4";
        break;
      case FIVE:
        rankString = "5";
        break;
      case SIX:
        rankString = "6";
        break;
      case SEVEN:
        rankString = "7";
        break;
      case EIGHT:
        rankString = "8";
        break;
      case NINE:
        rankString = "9";
        break;
      case TEN:
        rankString = "10";
        break;
      case JACK:
        rankString = "J";
        break;
      case QUEEN:
        rankString = "Q";
        break;
      case KING:
        rankString = "K";
        break;
    }
    return rankString + suitSymbol;
  }
}
// this should be good to go Ethan