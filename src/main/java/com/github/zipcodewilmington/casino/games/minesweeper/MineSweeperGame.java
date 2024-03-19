package com.github.zipcodewilmington.casino.games.minesweeper;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;

import java.util.Scanner;

public class MineSweeperGame implements GameInterface {
    MineSweeperPlayer player;
    boolean[][] mineGrid;
    Scanner sc = new Scanner(System.in);
    boolean exit = false;

    @Override
    public void run() {
        while (true) {
            System.out.println("Let's play Minesweeper.\n" +
                    "Select a cell by entering its coordinates.\n" +
                    "The selected cell will be revealed " +
                    "and if it is a mine, the game ends.\n" +
                    "Otherwise, the <payout will increase/numbers will be shown> " +
                    "and you can select another cell.\n" +
                    "If you reveal the entire grid except for the mines, you win!\n");
            System.out.println("Would you like to (p)lay or e(x)it? (p/X)");
            char input = sc.nextLine().toLowerCase().charAt(0);
            if (input == 'p') {
                playGame();
            } else {
                System.out.println("Exiting...");
                break;
            }
        }
        exitGame();
    }

    @Override
    public void run(CasinoAccount curr) {
        player = new MineSweeperPlayer(curr);
        run();
    }

    @Override
    public char playGame() {
        // TODO: Create an N by N grid with some amount of mines determined by the player.
        // Todo is ToDONE
        System.out.println("Enter a grid size. ");
        int sz = sc.nextInt();
        mineGrid = new boolean[sz][sz];
        while (!exit) {
            action();
        }
        return 0;
    }

    @Override
    public void setWager(int wager) {
        // This one does nothing at the moment
    }

    @Override
    public void action() {
        // TODO: Allow user to select a cell in an N by N grid to reveal or to exit to the menu

    }

    @Override
    public void exitGame() {
        this.player = null;
    }
}
