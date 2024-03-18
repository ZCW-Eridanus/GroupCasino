package com.github.zipcodewilmington.casino.games.minesweeper;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class MineSweeperPlayer implements PlayerInterface {
    CasinoAccount acct;

    public MineSweeperPlayer(CasinoAccount acct) {
        this.acct = acct;
    }

    @Override
    public CasinoAccount getAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
