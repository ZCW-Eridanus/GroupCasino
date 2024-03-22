package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class NumberGuessPlayer implements PlayerInterface {
    CasinoAccount acct;

    public NumberGuessPlayer(CasinoAccount acct) {
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

