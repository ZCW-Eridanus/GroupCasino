//package com.github.zipcodewilmington.casino.games.bingo;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.Scanner;
//
//class BingoCard {
//    //Matrix
//     int[][] numbers = new int[5][5];
//    private static int generateRandomNumber(Random random, int min, int max) {
//        return min + random.nextInt(max - min + 1);
//    }
//
//}
//
//public class Bingo {
//
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Welcome to Bingo!");
//
//        Random random = new Random();
//
//        // Player Creator
//        BingoCard player1Card = new BingoCard(random);
//        BingoCard player2Card = new BingoCard(random);
//
//        //tracks current player
//        int currentPlayer = 1;
//
//
//        while (true){
//            BingoCard currentCard = player1Card;
//            int drawnNumber = generatedRandomNumber(random, 0, 25);
//            drawnNumberAndMark(player1Card, player2Card, drawnNumber);
//
//
//
//            System.out.println("\nPlayer" + currentPlayer + "-Drawn Number:" + drawnNumber);
//            System.out.println("Player 1's Card");
//            displayCard(player1Card);
//            System.out.println("----------------");
//            displayCard("player2Card.");
//            System.out.println("----------------");
//
//            // check for Bingo
//            if (hasBingo(currentCard)) {
//                System.out.println("\nPlayer" + currentPlayer + "Hit Bingo!" );
//                break;
//            }
//            // switch to other player
//            currentPlayer = (currentPlayer==1)? 2:1;
//        }
//        }
//
//    private static int generatedRandomNumber(Random random, int min, int max) {
//        return min + random.nextInt(max - min + 1);
//    }
//
//    private static BingoCard createBingoCard(Random random) {
//        BingoCard card = new BingoCard();
//        List<Integer> possibleNumbers = new ArrayList<>();
//        for (int i = 1; i<=25; ++i){
//            possibleNumbers.add(i);
//        }
//
//}
//
//
//
//}
