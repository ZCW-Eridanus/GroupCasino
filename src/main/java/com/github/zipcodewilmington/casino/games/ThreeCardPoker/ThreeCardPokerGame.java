package com.github.zipcodewilmington.casino.games.ThreeCardPoker;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.DealerWithDeckOfCards;

import java.util.Scanner;

public class ThreeCardPokerGame extends DealerWithDeckOfCards implements GameInterface {

    public static Scanner scanner = new Scanner(System.in);
    ThreeCardPokerPlayer player;
    static int wagerAmount;
    String dealerCard1;
    String dealerCard2;
    String dealerCard3;
    String playerCard1;
    String playerCard2;
    String playerCard3;




    @Override
    public void run() {
        while (true) {
            if (playGame() == 'n') {
                exitGame();
                break;
            }
            setWager(wagerAmount);
            action();
            getDeck();
            dealerHand();
            dealPlayerHand();



        }
        //End of while loop
    }
    @Override
    public void run(CasinoAccount curr) {
        player = new ThreeCardPokerPlayer(curr);
        run();
    }

    @Override
    public char playGame() {
        System.out.println("- To start, the player places an ante wager and/or a pair plus wager, betting that they will have a hand of at least a pair or better.");
        System.out.println("- Three cards are then dealt face down to each player and to the dealer. You are only playing the dealer and not other players at the table.");
        System.out.println("- The player will then look at his hand and determine to place a play wager (equal to the amount they put as the ante wager) to pit his hand against the dealer’s hand or not.");
        System.out.println("- Optimum strategy says the player should “play” all hands greater than Queen, Six and Four and fold all hands worse.");
        System.out.println("- If a player folds, the hand is over and the dealer will collect the player's ante wager and pair plus wager. If the player places a play wager, the cards will be turned over to determine if the player has a better hand than the dealer.");
        System.out.println("- If a player folds, the hand is over and the dealer will collect the player's ante wager and pair plus wager. If the player places a play wager, the cards will be turned over to determine if the player has a better hand than the dealer.");
        System.out.println("- If the dealer has a hand of Jack-high or worse, the play wager is returned to the player. If the dealer has a hand of Queen-high or better, both the play wager and the ante are paid out at 1 to 1 if the player has a better hand than the dealer.");
        System.out.println("- If the dealer’s hand is superior, both the ante and play bets are collected. The pair plus bet is determined completely independent to what the dealer has.");
        System.out.println(" ");

        System.out.println("Are you ready to play? Yes/No");
        return scanner.next().toLowerCase().charAt(0);
    }

    @Override
    public void setWager(int wager) {
        System.out.println("Enter your wager : ");
        wagerAmount = scanner.nextInt();
    }

    @Override
    public void action() {
        System.out.println("Type - Deal - to deal the cards");
        scanner.next().toLowerCase();
    }


    @Override
    public void exitGame() {
        System.out.println("Would you like to go back to the lobby or exit the casino?  Lobby / Casino");

    }



    public void dealerHand(){
        dealerCard1 = dealOneCard();
        dealerCard2 = dealOneCard();
        dealerCard3 = dealOneCard();
    }
    public void dealPlayerHand(){
        playerCard1 = dealOneCard();
        playerCard2 = dealOneCard();
        playerCard3 = dealOneCard();
    }

}
