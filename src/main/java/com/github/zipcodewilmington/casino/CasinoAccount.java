package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `CasinoAccount` is registered for each user of the `Casino`.
 * The `CasinoAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    String name;
    String password;
    Double balance;

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
}
