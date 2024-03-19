package com.github.zipcodewilmington.casino.games.ThreeCardPoker;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.DealerWithDeckOfCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//TODO YOU need to set some parameters

public class ThreeCardPokerGame extends DealerWithDeckOfCards implements GameInterface {

    public static Scanner scanner = new Scanner(System.in);
    ArrayList<String> playerOneHand = new ArrayList<>();
    ArrayList<String> dealerHand = new ArrayList<>();


    ThreeCardPokerPlayer player;
    static CasinoAccount balance;
    static int wagerAmount;
    public int userWagerInput;
    String dealerCard1;
    String dealerCard2;
    String dealerCard3;
    String playerCard1;
    String playerCard2;
    String playerCard3;
    public int winnings;
    boolean pairPlus = false;
    boolean playedHand = false;
    boolean doTheyPairPlus;
    boolean doTheyAnteBonus;




    @Override
    public void run() {
        while (true) {
            if (playGame() == 'n') {
                exitGame();
                break;
            }
            setWager();   // do i put wager amount?

            pairPlus();
            action();
            getDeck();
            dealerHand();
            dealPlayerHand();
            playYourHand();
            pairPlusOdds();
            anteBounsOdds();
            playerWon();
            playerLost();



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
        System.out.println("____________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("- To start, the player places an ante wager and/or a pair plus wager, betting that they will have a hand of at least a pair or better.");
        System.out.println("- Three cards are then dealt face down to each player and to the dealer. You are only playing the dealer and not other players at the table.");
        System.out.println("- The player will then look at his hand and determine to place a play wager (equal to the amount they put as the ante wager) to pit his hand against the dealer’s hand or not.");
        System.out.println("- Optimum strategy says the player should “play” all hands greater than Queen, Six and Four and fold all hands worse.");
        System.out.println("- If a player folds, the hand is over and the dealer will collect the player's ante wager and pair plus wager. ");
        System.out.println("- If the player places a play wager, the cards will be turned over to determine if the player has a better hand than the dealer.");
        System.out.println("- If a player folds, the hand is over and the dealer will collect the player's ante wager and pair plus wager. ");
        System.out.println("- If the player places a play wager, the cards will be turned over to determine if the player has a better hand than the dealer.");
        System.out.println("- If the dealer has a hand of Jack-high or worse, the play wager is returned to the player. ");
        System.out.println("- If the dealer has a hand of Queen-high or better, both the play wager and the ante are paid out at 1 to 1 if the player has a better hand than the dealer.");
        System.out.println("- If the dealer’s hand is superior, both the ante and play bets are collected. The pair plus bet is determined completely independent to what the dealer has.");
        System.out.println("____________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println(" ");

        System.out.println("Are you ready to play? Yes/No");
        return scanner.next().toLowerCase().charAt(0);
    }

    @Override
    public void setWager(int wager) {
        System.out.println("_____________________________");
        System.out.println("Pair plus payouts: ");
        System.out.println(" ");
        System.out.println("Royal Flush  :  100 to 1");
        System.out.println("Straight Flush  :  40 to 1");
        System.out.println("Three of a Kind  :  30 to 1");
        System.out.println("Straight  :  6 to 1");
        System.out.println("Flush  :  3 to 1");
        System.out.println("Pair  :  1 to 1");
        System.out.println("_____________________________");
        System.out.println("Ante bonus payouts: ");
        System.out.println(" ");
        System.out.println("Straight Flush  :  5 to 1");
        System.out.println("Three of a Kind  :  4 to 1");
        System.out.println("Straight  :  1 to 1");
        System.out.println("_____________________________");
        boolean isInputValid;
        System.out.println(" ");
        System.out.println("Enter your wager to play : ");
        userWagerInput = scanner.nextInt();

        isInputValid = validateWagerInput();
            while(!isInputValid) {
            userWagerInput = scanner.nextInt();
            isInputValid = validateWagerInput();
            balance -= userWagerInput;

    }
}
public static boolean validateWagerInput(){
        if(wagerAmount > balance.getBalance() / 2 ){
        System.out.println("You don't have enough money. Enter a valid amount : ");
        return false;
    }
    return true;
}


    public void pairPlus() {
        System.out.println("Would you like to wager on Ante plus (Type - 0 - if not) : ");
        wagerAmount = scanner.nextInt();
        if(wagerAmount > 0){
            pairPlus = true;
        }
    }
    @Override
    public void action() {
        System.out.println("Type - Deal - to deal the cards. ");
        scanner.next().toLowerCase();
    }
    public void playYourHand() {
        System.out.println("Would you like to play your hand Yes/No");
         if(scanner.next().toLowerCase().charAt(0) == 'n'){
             exitGame();
         }
        if(wagerAmount > 0){
            playedHand = true;
        }
         balance -= userWagerInput
    }

    @Override
    public void exitGame() {
        System.out.println("Would you like to go back to the lobby or exit the casino?  Lobby / Casino");

    }
    public void dealerHand(){
        dealerCard1 = dealOneCard();
        dealerHand.add(dealerCard1);
        dealerCard2 = dealOneCard();
        dealerHand.add(dealerCard2);
        dealerCard3 = dealOneCard();
        dealerHand.add(dealerCard3);
        Collections.sort(dealerHand);
    }
    public void dealPlayerHand(){
        playerCard1 = dealOneCard();
        playerOneHand.add(playerCard1);
        playerCard2 = dealOneCard();
        playerOneHand.add(playerCard2);
        playerCard3 = dealOneCard();
        playerOneHand.add(playerCard2);
        Collections.sort(playerOneHand);
        System.out.println(playerOneHand);
    }
    public void playerWon(){
        System.out.println("You won " + winnings);
    }
    public void playerLost(){
        if(!doTheyPairPlus && !doTheyAnteBonus)
            System.out.println("Sorry the dealer won.");
    }
    public void pairPlusOdds() {
        String RoyalFlush;
        String straightFlush;
        String threeOfAKind;
        String straight;
        String flush;
        String pair;
        while(pairPlus && playedHand) {
            switch (playerOneHand) {
                case RoyalFlush:
                    if () {
                        winnings = wagerAmount * 100;
                        balance += winnings;
                        playerWon();

                    }
                    break;
                case straightFlush:
                    if () {
                        winnings = wagerAmount * 40;
                        balance += winnings;
                        playerWon();
                    }
                    break;
                case threeOfAKind:
                    if () {
                        winnings = wagerAmount * 130;
                        balance += winnings;
                        playerWon();
                    }
                    break;
                case straight:
                    if () {
                        winnings = wagerAmount * 6;
                        balance += winnings;
                        playerWon();
                    }
                    break;
                case flush:
                    if () {
                        winnings = wagerAmount * 3;
                        balance += winnings;
                        playerWon();
                    }
                    break;
                case pair:
                    if () {
                        winnings = wagerAmount;
                        balance += winnings;
                        playerWon();
                    }
                    break;
                default:
                    doTheyPairPlus = false ;
                    break;
            }
        }
    }
    public void anteBounsOdds(){
        String straightFlush;
        String threeOfAKind;
        String straight;
        while(pairPlus && playedHand){
            switch (playerOneHand){
                case straightFlush:
                    if(){
                        winnings = wagerAmount * 5;
                        balance += winnings;
                        playerWon();
                    }
                case threeOfAKind:
                    if(){
                        winnings = wagerAmount * 4;
                        balance += winnings;
                        playerWon();
                    }
                case straight:
                    if(){
                        winnings = wagerAmount;
                        balance += winnings;
                        playerWon();
                    }
                case default:
                    doTheyAnteBonus = false;
                    break;
            }
        }

    }

}
