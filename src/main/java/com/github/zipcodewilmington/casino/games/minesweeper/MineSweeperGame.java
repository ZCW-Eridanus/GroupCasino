package com.github.zipcodewilmington.casino.games.minesweeper;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Arrays;
import java.util.Random;

public class MineSweeperGame implements GameInterface {
    MineSweeperPlayer player;
    boolean[][] mineGrid;
    char[][] revealedGrid;
    boolean exit = false;
    IOConsole cons = new IOConsole(AnsiColor.CYAN, System.in, System.out);
    public int gridSize;

    @Override
    public void run() {
        while (true) {
            cons.println("Let's play Minesweeper.\n" +
                    "Select a cell by entering its coordinates.\n" +
                    "The selected cell will be revealed " +
                    "and if it is a mine, the game ends.\n" +
                    "Otherwise, the <payout will increase/numbers will be shown> " +
                    "and you can select another cell.\n" +
                    "If you reveal the entire grid except for the mines, you win!\n");
            char input = cons.getStringInput("Would you like to (p)lay or e(x)it? (p/X)").toLowerCase().charAt(0);
            if (input == 'p') {
                playGame();
            } else {
                cons.println("Exiting...");
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

    public void initGrids() {
        mineGrid = new boolean[gridSize][gridSize];
        revealedGrid = new char[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            Arrays.fill(mineGrid[i], false);
            Arrays.fill(revealedGrid[i], '?');
        }
    }

    public void createMines(int numMines) {
        Random rng = new Random(System.currentTimeMillis());

        for (int i = 0; i < numMines; i++) {
            int row = rng.nextInt(gridSize), col = rng.nextInt(gridSize);
            while (mineGrid[row][col]) {
                row = rng.nextInt(gridSize);
                col = rng.nextInt(gridSize);
            }
            mineGrid[row][col] = true;
        }
    }

    @Override
    public void playGame() {
        setGridSize(cons.getIntegerInput("Enter a grid size. "));
        initGrids();

        int numMines = cons.getIntegerInput("How many mines would you like? ");
        createMines(numMines);

        cons.println("Board of size " + gridSize +
                " generated with " + numMines +
                " mines." + "\nGood luck!");
        while (!exit) {
            cons.println("Current board state: ");
            cons.println(getBoard());
            action();
        }
    }

    public boolean checkCell(int row, int col) {
        return mineGrid[row][col];
    }

    public char checkNeighbors(int row, int col) {
        int retVal = 0;
        if ((row > 0 && row < mineGrid.length - 1)) {
            if ((col > 0 && col < mineGrid[row].length - 1)) {
                if (mineGrid[row-1][col-1]) {
                    retVal++;
                }
                if (mineGrid[row][col-1]) {
                    retVal++;
                }
                if (mineGrid[row-1][col]) {
                    retVal++;
                }
                if (mineGrid[row-1][col+1]) {
                    retVal++;
                }
                if (mineGrid[row+1][col-1]) {
                    retVal++;
                }
                if (mineGrid[row+1][col]) {
                    retVal++;
                }
                if (mineGrid[row][col+1]) {
                    retVal++;
                }
                if (mineGrid[row+1][col+1]) {
                    retVal++;
                }
            } else if (col == 0) {
                if (mineGrid[row-1][col]) {
                    retVal++;
                }
                if (mineGrid[row-1][col+1]) {
                    retVal++;
                }
                if (mineGrid[row+1][col]) {
                    retVal++;
                }
                if (mineGrid[row][col+1]) {
                    retVal++;
                }
                if (mineGrid[row+1][col+1]) {
                    retVal++;
                }
            } else if (col == mineGrid[row].length - 1) {
                if (mineGrid[row+1][col-1]) {
                    retVal++;
                }
                if (mineGrid[row+1][col]) {
                    retVal++;
                }
                if (mineGrid[row-1][col-1]) {
                    retVal++;
                }
                if (mineGrid[row][col-1]) {
                    retVal++;
                }
                if (mineGrid[row-1][col]) {
                    retVal++;
                }
            }
        } else if (row == 0) {
            if ((col > 0 && col < mineGrid[row].length - 1)) {
                if (mineGrid[row][col-1]) {
                    retVal++;
                }
                if (mineGrid[row+1][col-1]) {
                    retVal++;
                }
                if (mineGrid[row+1][col]) {
                    retVal++;
                }
                if (mineGrid[row][col+1]) {
                    retVal++;
                }
                if (mineGrid[row+1][col+1]) {
                    retVal++;
                }
            } else if (col == 0) {
                if (mineGrid[row+1][col]) {
                    retVal++;
                }
                if (mineGrid[row][col+1]) {
                    retVal++;
                }
                if (mineGrid[row+1][col+1]) {
                    retVal++;
                }
            } else if (col == mineGrid[row].length - 1) {
                if (mineGrid[row+1][col-1]) {
                    retVal++;
                }
                if (mineGrid[row+1][col]) {
                    retVal++;
                }
                if (mineGrid[row][col-1]) {
                    retVal++;
                }
            }
        } else if (row == mineGrid.length - 1) {
            if ((col > 0 && col < mineGrid[row].length - 1)) {
                if (mineGrid[row-1][col-1]) {
                    retVal++;
                }
                if (mineGrid[row][col-1]) {
                    retVal++;
                }
                if (mineGrid[row-1][col]) {
                    retVal++;
                }
                if (mineGrid[row-1][col+1]) {
                    retVal++;
                }if (mineGrid[row][col+1]) {
                    retVal++;
                }
            } else if (col == 0) {
                if (mineGrid[row-1][col]) {
                    retVal++;
                }
                if (mineGrid[row-1][col+1]) {
                    retVal++;
                }
                if (mineGrid[row][col+1]) {
                    retVal++;
                }
            } else if (col == mineGrid[row].length - 1) {
                if (mineGrid[row-1][col-1]) {
                    retVal++;
                }
                if (mineGrid[row][col-1]) {
                    retVal++;
                }
                if (mineGrid[row-1][col]) {
                    retVal++;
                }
            }
        }
        return Character.forDigit(retVal, 10);
    }

    public void revealNeighbors(int row, int col) {
        if (row > 0 && row < mineGrid.length - 1) {
            if (col > 0 && col < mineGrid[row].length - 1) {
                // the " + 0"'s are only there to make it look pretty because everything is neatly lined up
                revealedGrid[row - 1][col - 1] = checkNeighbors(row - 1, col - 1);
                revealedGrid[row + 0][col - 1] = checkNeighbors(row + 0, col - 1);
                revealedGrid[row - 1][col + 0] = checkNeighbors(row - 1, col + 0);
                revealedGrid[row + 1][col - 1] = checkNeighbors(row + 1, col - 1);
                revealedGrid[row - 1][col + 1] = checkNeighbors(row - 1, col + 1);
                revealedGrid[row + 0][col + 1] = checkNeighbors(row + 0, col + 1);
                revealedGrid[row + 1][col + 0] = checkNeighbors(row + 1, col + 0);
                revealedGrid[row + 1][col + 1] = checkNeighbors(row + 1, col + 1);
            } else if (col == 0) {
                revealedGrid[row - 1][col + 0] = checkNeighbors(row - 1, col + 0);
                revealedGrid[row - 1][col + 1] = checkNeighbors(row - 1, col + 1);
                revealedGrid[row + 0][col + 1] = checkNeighbors(row + 0, col + 1);
                revealedGrid[row + 1][col + 0] = checkNeighbors(row + 1, col + 0);
                revealedGrid[row + 1][col + 1] = checkNeighbors(row + 1, col + 1);
            } else if (col == mineGrid[row].length - 1) {
                revealedGrid[row + 1][col + 0] = checkNeighbors(row + 1, col + 0);
                revealedGrid[row - 1][col - 1] = checkNeighbors(row - 1, col - 1);
                revealedGrid[row + 0][col - 1] = checkNeighbors(row + 0, col - 1);
                revealedGrid[row - 1][col + 0] = checkNeighbors(row - 1, col + 0);
                revealedGrid[row + 1][col - 1] = checkNeighbors(row + 1, col - 1);
            }
        } else if (row == 0) {
            if (col > 0 && col < mineGrid[row].length - 1) {
                // the " + 0"'s are only there to make it look pretty because everything is neatly lined up
                revealedGrid[row + 0][col - 1] = checkNeighbors(row + 0, col - 1);
                revealedGrid[row + 1][col - 1] = checkNeighbors(row + 1, col - 1);
                revealedGrid[row + 0][col + 1] = checkNeighbors(row + 0, col + 1);
                revealedGrid[row + 1][col + 0] = checkNeighbors(row + 1, col + 0);
                revealedGrid[row + 1][col + 1] = checkNeighbors(row + 1, col + 1);
            } else if (col == 0) {
                revealedGrid[row + 0][col + 1] = checkNeighbors(row + 0, col + 1);
                revealedGrid[row + 1][col + 0] = checkNeighbors(row + 1, col + 0);
                revealedGrid[row + 1][col + 1] = checkNeighbors(row + 1, col + 1);
            } else if (col == mineGrid[row].length - 1) {
                revealedGrid[row + 1][col + 0] = checkNeighbors(row + 1, col + 0);
                revealedGrid[row + 0][col - 1] = checkNeighbors(row + 0, col - 1);
                revealedGrid[row + 1][col - 1] = checkNeighbors(row + 1, col - 1);
            }
        } else if (row == mineGrid.length - 1) {
            if (col > 0 && col < mineGrid[row].length - 1) {
                // the " + 0"'s are only there to make it look pretty because everything is neatly lined up
                revealedGrid[row - 1][col - 1] = checkNeighbors(row - 1, col - 1);
                revealedGrid[row + 0][col - 1] = checkNeighbors(row + 0, col - 1);
                revealedGrid[row - 1][col + 0] = checkNeighbors(row - 1, col + 0);
                revealedGrid[row - 1][col + 1] = checkNeighbors(row - 1, col + 1);
                revealedGrid[row + 0][col + 1] = checkNeighbors(row + 0, col + 1);
            } else if (col == 0) {
                revealedGrid[row - 1][col + 0] = checkNeighbors(row - 1, col + 0);
                revealedGrid[row - 1][col + 1] = checkNeighbors(row - 1, col + 1);
                revealedGrid[row + 0][col + 1] = checkNeighbors(row + 0, col + 1);
            } else if (col == mineGrid[row].length - 1) {
                revealedGrid[row - 1][col - 1] = checkNeighbors(row - 1, col - 1);
                revealedGrid[row + 0][col - 1] = checkNeighbors(row + 0, col - 1);
                revealedGrid[row - 1][col + 0] = checkNeighbors(row - 1, col + 0);
            }
        }
    }

    public String getBoard() {
        StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < revealedGrid.length; i++) {
            sb.append(" | ").append(i);
        }
        sb.append(" |\n");
        for (int i = 0; i < revealedGrid.length; i++) {
            sb.append(i).append(" | ");
            for (int j = 0; j < revealedGrid[i].length; j++) {
                sb.append(revealedGrid[i][j]).append(" | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void setWager(int wager) {
        // This one does nothing at the moment
    }

    @Override
    public void action() {
        String cell = cons.getStringInput("Please select a cell, or type X to eXit. (ex 0, 0)");
        if (cell.equals("X")) {
            exit = true;
            return;
        }
        String[] rowCol = cell.split(",");
        rowCol[0] = rowCol[0].trim();
        rowCol[1] = rowCol[1].trim();
        int row = Integer.parseInt(rowCol[0]), col = Integer.parseInt(rowCol[1]);
        if (checkCell(row, col)) {
            exit = true;
            cons.println("You've hit a mine! Returning to game menu...");
        } else {
            revealedGrid[row][col] = checkNeighbors(row, col);
            if (revealedGrid[row][col] == '0') {
                revealNeighbors(row, col);
            }
        }
    }

    @Override
    public void exitGame() {
        this.player = null;
    }

    public void setGridSize(int newSize) {
        this.gridSize = newSize;
    }

    public char getCell(int row, int col) {
        return revealedGrid[row][col];
    }
}
