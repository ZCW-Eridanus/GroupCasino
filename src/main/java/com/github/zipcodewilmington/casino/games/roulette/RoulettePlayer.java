package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RoulettePlayer implements PlayerInterface {
    public CasinoAccount account;



    public RoulettePlayer(CasinoAccount acct) {
        this.account = acct;
    }

    @Override
    public CasinoAccount getAccount() {
        return account;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }


}
