package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.casino.games.ThreeCardPoker.ThreeCardPokerPlayer;

import java.util.ArrayList;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Runnable {
    ArrayList<PlayerInterface> players = new ArrayList<>();

    /**
     * adds a player to the game
     * @param player the player to be removed from the game
     */
    default void add(PlayerInterface player) {
        players.add(player);
    }

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    default void remove(PlayerInterface player) {
        players.remove(player);
    }

    /**
     * specifies how the game will run
     */
    void run();

    void run(CasinoAccount acct);

    <T extends PlayerInterface> char playGame(T player);

    void setWager(int wager);

    <T extends PlayerInterface> void action(T player);

    <T extends PlayerInterface> void exitGame(T player);
}
