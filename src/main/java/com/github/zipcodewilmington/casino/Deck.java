package com.github.zipcodewilmington.casino;

public class Deck extends Card {

    public Deck(Suits suit, Ranks rank) {
        super(suit, rank);

        for (Suits s : Suits.values()) {
            for (Ranks r : Ranks.values()){
                Card card = new Card(s, r);

                System.out.println(card);

            }
        }
    }
}

