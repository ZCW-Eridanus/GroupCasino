package com.github.zipcodewilmington.casino.games.ThreeCardPoker;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class ThreeCardPokerPlayer implements PlayerInterface {
    CasinoAccount acct;

    public ThreeCardPokerPlayer(CasinoAccount acct) {
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

