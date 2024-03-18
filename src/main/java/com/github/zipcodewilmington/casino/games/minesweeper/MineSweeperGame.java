package com.github.zipcodewilmington.casino.games.minesweeper;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;

public class MineSweeperGame implements GameInterface {
    MineSweeperPlayer player;

    @Override
    public void run() {
        playGame();
    }

    @Override
    public void run(CasinoAccount curr) {
        player = new MineSweeperPlayer(curr);
        run();
    }

    @Override
    public void playGame() {
        // TODO: Create an N by N grid with some amount of mines determined by the player.
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
