package com.github.zipcodewilmington.casino.games.ThreeCardPoker;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardGame.*;

import java.util.*;
import java.util.function.BooleanSupplier;

public class ThreeCardPokerGame implements GameInterface {

    public static Scanner scanner = new Scanner(System.in);
    ThreeCardPokerPlayer player;
    Hand playerHand;
    Hand dealerHand;
    Deck threeCardDeck;
    public double balance;
    public int playWagerAmount;
    int pairPlusWagerAmount;
    public int winnings;
    public boolean pairPlus = false;
    public boolean didTheyPlayHand = false;
    String playerCard1;
    String playerCard2;
    String playerCard3;
    String dealerCard1;
    String dealerCard2;
    String dealerCard3;
    boolean royalFlush = false;
    boolean straightFlush = false;
    boolean threeOfAKind = false;
    boolean straight = false;
    boolean flush = false;
    boolean pair = false;
    boolean dealerRoyalFlush = false;
    boolean dealerStraightFlush = false;
    boolean dealerThreeOfAKind = false;
    boolean dealerStraight = false;
    boolean dealerFlush = false;
    boolean dealerPair = false;
    boolean straightFlushAnte = false;
    boolean threeOfAKindAnte = false;
    boolean straightAnte = false;
    boolean eligibleToPlay = false;


    boolean doTheyPairPlus;
    boolean doTheyAnteBonus;



    @Override
    public void run() {
        while (true) {
            if (playGame(player) == 'n') {
                exitGame(player);
                break;
            }
            setWager(playWagerAmount);

            pairPlus(pairPlusWagerAmount);
            action(player);

            playYourHand(playWagerAmount);
            dealerHandGrade();
            gradeHand();
            pairPlusOdds();
            anteBonusOdds();
            playerWon();
            playerLost();
            playAgain(player);
        }
    }
    @Override
    public void run(CasinoAccount curr) {
        player = new ThreeCardPokerPlayer(curr);
        balance = curr.getBalance();
        run();
    }
    @Override
    public <T extends PlayerInterface> char playGame(T player) {
        return playGame((ThreeCardPokerPlayer) player);
    }
    public char playGame(ThreeCardPokerPlayer player) {
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
    public void setWager(int playWagerAmount) {
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
        playWagerAmount = scanner.nextInt();

        isInputValid = validateFirstWagerInput(playWagerAmount);
            while(!isInputValid) {
                playWagerAmount = scanner.nextInt();
            isInputValid = validateFirstWagerInput(playWagerAmount);
        }balance -= playWagerAmount;
    }
public boolean validateFirstWagerInput(int firstWagerCheck){
        if(firstWagerCheck > balance / 2 ){
        System.out.println("You don't have enough money. Enter a valid amount : ");
        return false;
    }
    return true;
}
    public void pairPlus(int pairPlusWagerAmount) {
        boolean isInputValid;
        System.out.println("Would you like to wager on Pair plus (Type - 0 - if not) : ");
        pairPlusWagerAmount = scanner.nextInt();
        isInputValid = validatePairPlusInput(pairPlusWagerAmount);
        while (!isInputValid) {
            pairPlusWagerAmount = scanner.nextInt();
            isInputValid = validatePairPlusInput(pairPlusWagerAmount);
        }
        if (pairPlusWagerAmount > 0) {
            pairPlus = true;
        }
        balance -= pairPlusWagerAmount;
    }
    public boolean validatePairPlusInput(int pairPlusCheck){
        if(pairPlusCheck > playWagerAmount * 2){
            System.out.println("You don't have enough money to play pair plus if you want to continue your game. Enter a valid amount : ");
            return false;
        }
        return true;
    }



    @Override
    public <T extends PlayerInterface> void action(T player) {
        action(((ThreeCardPokerPlayer) player));
        System.out.println("Type - Deal - to deal the cards. ");
        scanner.next().toLowerCase();
        playerCard1 = String.valueOf(playerHand.addCard(threeCardDeck.dealCard()));
        playerCard2 = String.valueOf(playerHand.addCard(threeCardDeck.dealCard()));
        playerCard3 = String.valueOf(playerHand.addCard(threeCardDeck.dealCard()));

        dealerCard1 = String.valueOf(dealerHand.addCard(threeCardDeck.dealCard()));
        dealerCard2 = String.valueOf(dealerHand.addCard(threeCardDeck.dealCard()));
        dealerCard3 = String.valueOf(dealerHand.addCard(threeCardDeck.dealCard()));


        System.out.println(playerHand);
        System.out.println("DEALER'S HAND - ? , ? , ?");
    }




    public void playYourHand(int playerWagerAmount) {
        System.out.println("Would you like to play your hand Yes/No");
        boolean isInputValid;
        if(scanner.next().toLowerCase().charAt(0) == 'n'){
             exitGame(player);
         }
        playerWagerAmount = scanner.nextInt();
        isInputValid = validatePlayYourHandInput(playerWagerAmount);
        while (!isInputValid) {
            playerWagerAmount = scanner.nextInt();
            isInputValid = validatePlayYourHandInput(playerWagerAmount);
        }

        if(playerWagerAmount > 0){
            didTheyPlayHand = true;
        }
         balance -= playerWagerAmount;
    }
    public boolean validatePlayYourHandInput(int playHandCheck){
        if(playHandCheck > balance){
            System.out.println("You don't have enough money to play pair against the dealer. Enter a valid amount : ");
            return false;
        }
        return true;
    }
    @Override
    public <T extends PlayerInterface> void exitGame(T player) {
        exitGame((ThreeCardPokerPlayer) player);
    }
    public void playAgain(ThreeCardPokerPlayer player) {
        System.out.println("Would you like to play again?   Yes/N");
        if(scanner.next().toLowerCase().charAt(0) == 'n'){
            exitGame(player);
        }
        setWager(playWagerAmount);
    }
    public void exitGame(ThreeCardPokerPlayer player) {
        player.getAccount().setBalance(balance);
        System.out.println("Would you like to go back to the lobby or exit the casino?  Lobby / Casino");
    }

    public void playerWon(){
        System.out.println("You won " + winnings);
    }
    public void playerLost(){
        if(!doTheyPairPlus && !doTheyAnteBonus)
            System.out.println("Sorry the dealer won.");
    }

    public boolean gradeHand(){
            int playerRank = getHandRank(playerHand);
            int dealerRank = getHandRank(dealerHand);
        if (playerRank > dealerRank) {
            playerWon();
            return true;
        } else if (playerRank < dealerRank) {
            playerLost();
            return false;
        } else {
            System.out.println("It's a tie!");
            return false;
        }
    }
    private int getHandRank(Hand hand) {
        if (isRoyalFlush(hand)) {
            return 9;
        } else if (isStraightFlush(hand)) {
            return 8;
        } else if (isThreeOfAKind(hand)) {
            return 7;
        } else if (isStraight(hand)) {
            return 6;
        } else if (isFlush(hand)) {
            return 5;
        } else if (isPair(hand)) {
            return 4;
        } else {
            return getHighCardRank(hand);
        }
    }
    private int getHighCardRank(Hand hand) {
        int rank = 0;
        for (Card card : hand.getCards()) {
            rank = Math.max(rank, getCardRank(card));
        }
        return rank;
    }
    private int getCardRank(Card card) {
        // Assign ranks to each card
        switch (card.getRank()) {
            case "A":
                return 14; // Ace is the highest card
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            default:
                return Integer.parseInt(card.getRank());
        }
    }




    public void pairPlusOdds() {
        while(pairPlus && didTheyPlayHand) {
            switch(playerHand) {
                case royalFlush:
                    if (Integer.parseInt(playerCard1.substring(0, 1)) == Integer.parseInt(playerCard2.substring(0, 1) + 1) &&
                            Integer.parseInt(playerCard1.substring(0, 1)) == Integer.parseInt(playerCard3.substring(0, 1) + 2)
                            && playerCard1.charAt(1) == playerCard2.charAt(1) && playerCard1.charAt(1) == playerCard3.charAt(1)) {
                        royalFlush = true;
                        winnings = pairPlusWagerAmount * 100;
                        balance += winnings;
                    }
                    break;
                case straightFlush:
                    if (Integer.parseInt(playerCard1.substring(0, 1)) == Integer.parseInt(playerCard2.substring(0, 1) + 1) &&
                            Integer.parseInt(playerCard1.substring(0, 1)) == Integer.parseInt(playerCard3.substring(0, 1) + 2)
                            && playerCard1.charAt(1) == playerCard2.charAt(1) && playerCard1.charAt(1) == playerCard3.charAt(1)) {
                        straightFlush = true;
                        winnings = pairPlusWagerAmount * 40;
                        balance += winnings;
                    }
                    break;
                case threeOfAKind:
                    if (playerCard1.charAt(0) == playerCard2.charAt(0) && playerCard1.charAt(0) == playerCard3.charAt(0)) {
                        threeOfAKind = true;
                        winnings = pairPlusWagerAmount * 30;
                        balance += winnings;
                    }
                    break;
                case straight:
                    if (Integer.parseInt(playerCard1.substring(0, 1)) == Integer.parseInt(playerCard2.substring(0, 1) + 1) &&
                            Integer.parseInt(playerCard1.substring(0, 1)) == Integer.parseInt(playerCard3.substring(0, 1) + 2)) {
                        straight = true;
                        winnings = pairPlusWagerAmount * 6;
                        balance += winnings;
                    }
                    break;
                case flush:
                    if (playerCard1.charAt(1) == playerCard2.charAt(1) && playerCard1.charAt(1) == playerCard3.charAt(1)) {
                        flush = true;
                        winnings = pairPlusWagerAmount * 3;
                        balance += winnings;
                    }
                    break;
                case pair:
                    if (playerCard1.charAt(0) == playerCard2.charAt(0) || playerCard1.charAt(0) == playerCard3.charAt(0)
                            || playerCard2.charAt(0) == playerCard3.charAt(0)) {
                        pair = true;
                        winnings = pairPlusWagerAmount;
                        balance += winnings;
                    }
                    break;
                default:
                    doTheyPairPlus = false;
                    break;
            }
        }
    }


    public void anteBonusOdds(){
        while(didTheyPlayHand){
            switch (playerHand){
                case straightFlushAnte:
                    if((Integer.parseInt(playerCard1.substring(0, 1)) == Integer.parseInt(playerCard2.substring(0, 1) + 1) &&
                            Integer.parseInt(playerCard1.substring(0, 1)) == Integer.parseInt(playerCard3.substring(0, 1) + 2)
                            && playerCard1.charAt(1) == playerCard2.charAt(1) && playerCard1.charAt(1) == playerCard3.charAt(1))){
                        straightFlushAnte = true;
                        winnings = playWagerAmount * 5;
                        balance += winnings;
                    }
                case threeOfAKindAnte:
                    if(playerCard1.charAt(0) == playerCard2.charAt(0) && playerCard1.charAt(0) == playerCard3.charAt(0)){
                        threeOfAKindAnte = true;
                        winnings = playWagerAmount * 4;
                        balance += winnings;
                    }
                case straightAnte:
                    if(Integer.parseInt(playerCard1.substring(0, 1)) == Integer.parseInt(playerCard2.substring(0, 1) + 1) &&
                            Integer.parseInt(playerCard1.substring(0, 1)) == Integer.parseInt(playerCard3.substring(0, 1) + 2)){
                        straightAnte = true;
                        winnings = playWagerAmount;
                        balance += winnings;
                    }
                case default:
                    doTheyAnteBonus = false;
                    break;
            }
        }
    }
    public void dealerHandGrade() {
        while(pairPlus && didTheyPlayHand) {
            switch(dealerHand) {
                case royalFlush:
                    if (Integer.parseInt(dealerCard1.substring(0, 1)) == Integer.parseInt(dealerCard2.substring(0, 1) + 1) &&
                            Integer.parseInt(dealerCard1.substring(0, 1)) == Integer.parseInt(dealerCard3.substring(0, 1) + 2)
                            && dealerCard1.charAt(1) == dealerCard2.charAt(1) && dealerCard1.charAt(1) == dealerCard3.charAt(1)) {
                        dealerRoyalFlush = true;
                    }
                    break;
                case straightFlush:
                    if (Integer.parseInt(dealerCard1.substring(0, 1)) == Integer.parseInt(dealerCard2.substring(0, 1) + 1) &&
                            Integer.parseInt(dealerCard1.substring(0, 1)) == Integer.parseInt(dealerCard3.substring(0, 1) + 2)
                            && dealerCard1.charAt(1) == dealerCard2.charAt(1) && dealerCard1.charAt(1) == dealerCard3.charAt(1)) {
                        dealerStraightFlush = true;
                    }
                    break;
                case threeOfAKind:
                    if (dealerCard1.charAt(0) == dealerCard2.charAt(0) && dealerCard1.charAt(0) == dealerCard3.charAt(0)) {
                        dealerThreeOfAKind = true;
                    }
                    break;
                case straight:
                    if (Integer.parseInt(dealerCard1.substring(0, 1)) == Integer.parseInt(dealerCard2.substring(0, 1) + 1) &&
                            Integer.parseInt(dealerCard1.substring(0, 1)) == Integer.parseInt(dealerCard3.substring(0, 1) + 2)) {
                        dealerStraight = true;
                    }
                    break;
                case flush:
                    if (dealerCard1.charAt(1) == dealerCard2.charAt(1) && dealerCard1.charAt(1) == dealerCard3.charAt(1)) {
                        dealerFlush = true;
                    }
                    break;
                case pair:
                    if (dealerCard1.charAt(0) == dealerCard2.charAt(0) || dealerCard1.charAt(0) == dealerCard3.charAt(0)
                            || dealerCard2.charAt(0) == dealerCard3.charAt(0)) {
                        dealerPair = true;
                    }
                    break;
                case eligibleToPlay:
                    if(playerCard3.charAt(0)== 'Q'|| playerCard3.charAt(0)== 'K'||playerCard3.charAt(0)== 'A')
                        eligibleToPlay = true;
                default:
                   eligibleToPlay = false;
                    break;
            }
        }
    } private boolean isRoyalFlush(Hand hand) {
        return false;
    }
    private boolean isStraightFlush(Hand hand) {
        return false;
    }
    private boolean isThreeOfAKind(Hand hand) {
        return false;
    }
    private boolean isStraight(Hand hand) {
        return false;
    }
    private boolean isFlush(Hand hand) {
        return false;
    }
    private boolean isPair(Hand hand) {
        return false;
    }




}
