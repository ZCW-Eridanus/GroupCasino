package com.github.zipcodewilmington.casino.games.bingo;

import java.util.Random;
import java.util.Scanner;

class BingoCard {
    //Matrix
     int[][] numbers = new int[5][5];

    public BingoCard(Random random) {
    }
}

public class Bingo {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Bingo!");

        Random random = new Random();

        // Player Creator
        BingoCard player1Card = new BingoCard(random);
        BingoCard player2Card = new BingoCard(random);

        //player1
        int currentPlayer = 1;


        while (true){
            BingoCard currentCard = (currentPlayer ==1)?
                    player1Card : player2Card;
        }

    }

}
