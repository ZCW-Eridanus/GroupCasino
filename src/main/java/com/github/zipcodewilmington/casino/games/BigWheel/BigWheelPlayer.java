package com.github.zipcodewilmington.casino.games.BigWheel;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BigWheelPlayer implements PlayerInterface {
    CasinoAccount acct;

    public BigWheelPlayer(CasinoAccount acct) {
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

