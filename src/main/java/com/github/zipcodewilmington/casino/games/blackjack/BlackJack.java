package com.github.zipcodewilmington.casino.games.blackjack;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardGame.Card;
import com.github.zipcodewilmington.casino.games.cardGame.Hand;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;


public class BlackJack implements GameInterface {


  BlackJackPlayer BJPlayer = new BlackJackPlayer(new CasinoAccount("1", "1"));
  BlackJackPlayer BJDealer = new BlackJackPlayer(new CasinoAccount("1", "1"));

  int playerScore = 0;
  int dealerScore = 0;
  int hiddenDealerScore = 0;
  Hand BJPlayerHand = new Hand();
  Hand BJDealerHand = new Hand();
  IOConsole cons = new IOConsole(AnsiColor.YELLOW, System.in, System.out);


  public void add(PlayerInterface BJPlayer, PlayerInterface BJDealer) {
    this.BJPlayer = (BlackJackPlayer) BJPlayer;
    this.BJDealer = (BlackJackPlayer) BJDealer;
  }

  public void run() {
    while (true) {
      cons.println("Let's play BlackJack! \n" +
        "The goal of this game is to reach a summative 21 points from the value of your cards (or be the closest to it.) \n" +
        "Going above this number will result in a BUST! \n" +
        "All face cards (Jack, Queen, King) count as 10 points each. \n");

      char input = cons.getStringInput(" Now that you've heard the rules... \n" +
        "Would you still like to play? Enter : Y/N").toLowerCase().charAt(0);
      if (input == 'y') {
        playGame(this.BJPlayer, this.BJDealer);
        break;
      } else {
        break;
      }
    }
    exitGame();
  } // good

  @Override
  public void run(CasinoAccount curr) {
    this.BJPlayer = new BlackJackPlayer(curr);
    this.BJDealer = new BlackJackPlayer(curr);
    run();
  }

  @Override
  public <T extends PlayerInterface> char playGame(T player) {
    return 0;
  }

  public void initializeHands() {
    int score = 0;

//    BJPlayerHand = BJPlayer.getHand();
//    BJDealerHand = BJDealer.getHand();

    score = BJDealerHand.addValuedCard(BJDealer.hit()); // score is equal to first card added

    hiddenDealerScore += score; // adding the first cards score to a value we aren't printing

    dealerScore += score; // adding that to the score we're going to actually print

    hiddenDealerScore += BJDealerHand.addValuedCard(BJDealer.hit()); // this is adding the second card to the hidden/true score


    playerScore += BJPlayerHand.addValuedCard(BJPlayer.hit());

    playerScore += BJPlayerHand.addValuedCard(BJPlayer.hit());

  }



  public void playGame() {
    playGame(this.BJPlayer, this.BJDealer);
  }

  public void playGame(BlackJackPlayer BJPlayer, BlackJackPlayer BJDealer) {
    BJPlayerHand = BJPlayer.getHand();
    BJDealerHand = BJDealer.getHand();

    initializeHands();

    getDealerScore();
    getDealerHand();

    getPlayerScore();
    getPlayerScore();

    action();

    // if no one won yet

  }

  public void getDealerScore() {
    System.out.println("The dealer's current score is ... " + dealerScore);
  }

  public void getPlayerScore() {
    System.out.println("Your current score is ... " + playerScore);
  }

  public Hand getDealerHand() {
    return BJDealer.getHand();
  }

  public Hand getBJPlayerHand() {
    return BJPlayer.getHand();
  }

  @Override
  public void setWager(int wager) {

  }

  @Override
  public <T extends PlayerInterface> void action(T player) {

  }

  @Override
  public <T extends PlayerInterface> void exitGame(T player) {

  }


  public boolean checkWinOrLoss() {
    if (playerScore < 21 || hiddenDealerScore < playerScore || (BJDealer.isBusted(hiddenDealerScore) && !BJPlayer.isBusted(playerScore))) {
      return true;
    } else {
      return false;
    }
  }

  public void dealersChoice() {
    if (hiddenDealerScore <= 15) {
      BJDealerHand.addValuedCard(BJDealer.hit());
    } else {
      BJDealer.stay();
    }
  }


  public void action() {
    while (true) { // while true is not the right loop to do, the actual method doesn't end
      String input = cons.getStringInput("Would you like to hit or stay?");
      if (input.equals("stay")) {
        getBJPlayerHand();
        BJPlayer.stay();
        getPlayerScore();
        dealersChoice();
        break;

      } else if (input.equals("hit")) {
        playerScore += BJPlayerHand.addValuedCard(BJPlayer.hit());
        getBJPlayerHand();
        getPlayerScore();
        dealersChoice();

      }
      if (BJPlayer.isBusted(playerScore)) {
        break;
      }
    }
    if (!checkWinOrLoss()) {
      cons.println("You lost...");
    } else {
      cons.println("You won...");
    }
  }


  public void youWon() {
    while (checkWinOrLoss() == true) {
      cons.println("You win!");
      char input = cons.getStringInput("Would you like to play again? Type Y for Yes, any other key will return you to the menu. \n").toLowerCase().charAt(0);
      if (input == 'y') {
        playGame();
      } else {
        exitGame();
      }
    }
  }


  public void youLost() {
    while (checkWinOrLoss() == false) {
      cons.println("You lost!");
      char input = cons.getStringInput("Would you like to play again? Type Y for Yes, any other key will return you to the menu. \n").toLowerCase().charAt(0);
      if (input == 'y') {
        playGame();
      } else {
        exitGame();
      }
    }
  }


  public void exitGame() {
    this.BJPlayer = null;
  }
}

// if says yes to stay
// the player doesn't get a card and the score is printed,
// but the dealer's method is still ran
// if says yes to hit
// player gets another card,
// and the method for whether the dealer is going to hit or stay is ran.
// check if someone won or lost
// if no one win/loss is false,
// redo the loop
// if win/loss is true
//