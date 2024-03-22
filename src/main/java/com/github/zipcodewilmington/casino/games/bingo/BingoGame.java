package com.github.zipcodewilmington.casino.games.bingo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BingoGame  {

    private List<PlayerBoard> playerBoards; // Collection of player boards
    private Random random;
    private Scanner scanner;

    public BingoGame() {
        playerBoards = new ArrayList<>();
        random = new Random();
        scanner = new Scanner(System.in);
    }

    // player board the collection
    public void addPlayerBoard(PlayerBoard playerBoard) {
        playerBoards.add(playerBoard);
    }


    public void printPlayerBoards() {
        for (PlayerBoard playerBoard : playerBoards) {
            playerBoard.printBoard();
            System.out.println();
        }
    }


    public void playBingo() {
        int bingoNumbers = 25;

        while (bingoNumbers > 0) {
            int drawnNumber = random.nextInt(75) + 1;
            System.out.println("Number drawn: " + drawnNumber);

            for (PlayerBoard playerBoard : playerBoards) {
                playerBoard.printBoard();
                System.out.println("Does Player " + playerBoard.getPlayerNumber() + " have number " + drawnNumber + "? (yes/no)");
                String answer = scanner.next();

                if (answer.equalsIgnoreCase("yes")) {
                    playerBoard.markNumber(drawnNumber);
                }
            }

            System.out.println("Updated Player Boards:");
            printPlayerBoards();

            bingoNumbers--;
        }

        System.out.println("All bingo numbers have been drawn.");
    }

    public static void main(String[] args) {
        BingoGame bingoGame = new BingoGame();

        PlayerBoard player1 = new PlayerBoard(1);
        PlayerBoard player2 = new PlayerBoard(2);

        bingoGame.addPlayerBoard(player1);
        bingoGame.addPlayerBoard(player2);

        // Start Bingo
        bingoGame.playBingo();
    }

    public List<PlayerBoard> getPlayerBoards() {
    return playerBoards;}
}
