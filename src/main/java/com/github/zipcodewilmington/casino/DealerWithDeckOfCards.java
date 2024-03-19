package com.github.zipcodewilmington.casino;

import java.util.Collections;
import java.util.Stack;

public class DealerWithDeckOfCards {
    Stack<String> cards = new Stack<>();

    String[] suits = {"♣", "♥", "♦", "♠"};
    String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};



    private void initializeDeck() {
        for (String suit : suits) {
            for (String value : values) {
                cards.push(value + suit);
            }
        }
    }
    public void getDeck(){
        initializeDeck();
        Collections.shuffle(cards);
    }
    public String dealOneCard(){
        return cards.pop();
    }
}
