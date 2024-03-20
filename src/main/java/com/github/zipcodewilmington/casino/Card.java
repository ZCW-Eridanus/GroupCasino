package com.github.zipcodewilmington.casino;

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

}
