package com.github.zipcodewilmington.casino.games.bingo;

import java.util.Random;

public class PlayerBoard {
    private int[][] board;
    private int playerNumber;
    private Random random;

    public PlayerBoard(int playerNumber) {
        this.playerNumber = playerNumber;
        board = new int[5][5];
        random = new Random();
        initializeBoard();
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    private void initializeBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    board[i][j] = random.nextInt(15) + 1;
                } else if (j == 1) {
                    board[i][j] = random.nextInt(15) + 16;
                } else if (j == 2) {
                    board[i][j] = random.nextInt(15) + 31;
                } else if (j == 3) {
                    board[i][j] = random.nextInt(15) + 46;
                } else if (j == 4) {
                    board[i][j] = random.nextInt(15) + 61;
                }
            }
        }
    }

    public void markNumber(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == number) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public boolean isBingo() {
        // Check rows
        for (int i = 0; i < board.length; i++) {
            boolean rowBingo = true;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    rowBingo = false;
                    break;
                }
            }
            if (rowBingo) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < board[0].length; j++) {
            boolean collumnBingo = true;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != 0) {
                    collumnBingo = false;
                    break;
                }
            }
            if (collumnBingo) {
                return true;
            }
        }

        // Check diagonals
        boolean diagonal1Bingo = true;
        boolean diagonal2Bingo = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != 0) {
                diagonal1Bingo = false;
            }
            if (board[i][board.length - 1 - i] != 0) {
                diagonal2Bingo = false;
            }
        }
        if (diagonal1Bingo || diagonal2Bingo) {
            return true;
        }


        return false;
    }


    public void printBoard() {
        System.out.println("Player " + playerNumber + "'s Board:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print((board[i][j] != 0) ? board[i][j] + " | " : "X | ");
            }
            System.out.println();
        }

    }


    public int[][] getBoard() {
        return board;
    }
}