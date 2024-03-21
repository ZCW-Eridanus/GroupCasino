package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.games.cardGame.*;
import com.github.zipcodewilmington.utils.*;

public class BlackJack implements GameInterface  {

  BlackJackPlayer BJPlayer;
  BlackJackPlayer BJDealer;
  IOConsole cons = new IOConsole(AnsiColor.YELLOW, System.in, System.out);

  // BJDealer.getScore()
  // BJPlayer.getScore()

  public void add(PlayerInterface player) {
    this.BJPlayer = (BlackJackPlayer) player;
  }
  @Override
  public void run() {
    while (true) {
      cons.println("Let's play BlackJack! \n" +
        "The goal of this game is to reach a summative 21 points from the value of your cards (or be the closest to it.) \n" +
        "Going above this number will result in a BUST! \n" +
        "All face cards (Jack, Queen, King) count as 10 points each. \n" +
        "Except for Ace; it can count as a 1 or a 10, depending on what's better for the deck.");

      char input = cons.getStringInput("Hearing all that... \n" +
        "Would you still like to play? Enter : Y/N").toLowerCase().charAt(0);
        if (input == 'y') {
          playGame(this.BJPlayer, this.BJDealer);
        }
        else{
          break;
        }
    } exitGame();
  }


  @Override
  public void run(CasinoAccount acct) {
    this.BJPlayer = new BlackJackPlayer(acct);
  }

  @Override
  public void playGame() {
    playGame(this.BJPlayer, this.BJDealer);
  }

  public void playGame(BlackJackPlayer BJPlayer, BlackJackPlayer BJDealer) {

  }

  public int getDealerScore() {
    return BJDealer.getScore();
  }

  public int getPlayerScore() {
    return BJPlayer.getScore();
  }

  public Hand getDealerHand() {
    return BJDealer.getHand();
  }

  public Hand getPlayerHand() {
    return BJPlayer.getHand();
  }

  @Override
  public void setWager(int wager) {

  }

  @Override
  public void action() {

  }

  @Override
  public void exitGame() {

  }
}
