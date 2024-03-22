package com.github.zipcodewilmington.casino;

import java.io.Serializable;

/**
 * Created by leon on 7/21/2020.
 * `CasinoAccount` is registered for each user of the `Casino`.
 * The `CasinoAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount implements Serializable {
    String name;
    String password;
    Double balance = 0.0;

    public CasinoAccount(){

    }

    public CasinoAccount(String name, String pw) {
        this.name = name;
        this.password = pw;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public boolean testPasswordEquals(String input) {
        return password.equals(input);
    }
}






