package com.github.zipcodewilmington.casino.games.ThreeCardPoker;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.DealerWithDeckOfCards;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.*;

//TODO YOU need to set some parameters

public class ThreeCardPokerGame extends DealerWithDeckOfCards implements GameInterface {

    public static Scanner scanner = new Scanner(System.in);
    ArrayList<String> playerOneHand = new ArrayList<>();
    ArrayList<String> dealerHand = new ArrayList<>();


    ThreeCardPokerPlayer player;
    double balance;
    public int wagerAmount;
    String dealerCard1;
    String dealerCard2;
    String dealerCard3;

    //card1 for player
        String playerCard1;
        String valueOfCard1;
        String suitOfCard1;
    //card2 for player
        String playerCard2;
        String valueOfCard2;
        String suitOfCard2;
    //card3 for player
        String playerCard3;
        String valueOfCard3;
        String suitOfCard3;
    public int winnings;
    boolean pairPlus = false;
    boolean playedHand = false;
    boolean doTheyPairPlus;
    boolean doTheyAnteBonus;




    @Override
    public void run() {
        while (true) {
            if (playGame(player) == 'n') {
                exitGame(player);
                break;
            }
            setWager(wagerAmount);

            pairPlus(wagerAmount);
            action(player);
            getDeck();
            dealerHand();
            dealPlayerHand();
            playYourHand(wagerAmount);
            pairPlusOdds(playerOneHand);
            anteBonusOdds(playerOneHand);
            playerWon();
            playerLost();



        }
        //End of while loop
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
    public void setWager(int playerWagerAmount) {
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
        wagerAmount = scanner.nextInt();

        isInputValid = validateFirstWagerInput(wagerAmount);
            while(!isInputValid) {
            wagerAmount = scanner.nextInt();
            isInputValid = validateFirstWagerInput(wagerAmount);
        }balance -= wagerAmount;
    }


public boolean validateFirstWagerInput(int firstWagerCheck){
        if(firstWagerCheck > balance / 2 ){
        System.out.println("You don't have enough money. Enter a valid amount : ");
        return false;
    }
    return true;
}



    public void pairPlus(int playerWagerAmount) {
        boolean isInputValid;
        System.out.println("Would you like to wager on Pair plus (Type - 0 - if not) : ");
        wagerAmount = scanner.nextInt();
        isInputValid = validatePairPlusInput(wagerAmount);
        while (!isInputValid) {
            wagerAmount = scanner.nextInt();
            isInputValid = validatePairPlusInput(wagerAmount);
        }
        if (wagerAmount > 0) {
            pairPlus = true;
        }
        balance -= wagerAmount;
    }




    public boolean validatePairPlusInput(int pairPlusCheck){
        if(pairPlusCheck > balance * 2){
            System.out.println("You don't have enough money to play pair plus if you want to continue your game. Enter a valid amount : ");
            return false;
        }
        return true;
    }



    @Override
    public <T extends PlayerInterface> void action(T player) {
        action(((ThreeCardPokerPlayer) player));
    }

    public void action(ThreeCardPokerPlayer player) {
        System.out.println("Type - Deal - to deal the cards. ");
        scanner.next().toLowerCase();
    }



    public void playYourHand(int playerWagerAmount) {
        System.out.println("Would you like to play your hand Yes/No");
        boolean isInputValid;
        if(scanner.next().toLowerCase().charAt(0) == 'n'){
             exitGame(player);
         }
        wagerAmount = scanner.nextInt();
        isInputValid = validatePlayYourHandInput(wagerAmount);
        while (!isInputValid) {
            wagerAmount = scanner.nextInt();
            isInputValid = validatePlayYourHandInput(wagerAmount);
        }

        if(wagerAmount > 0){
            playedHand = true;
        }
         balance -= wagerAmount;
    }


    /////IDK IF I NEED THIS
    public boolean validatePlayYourHandInput(int playHandCheck){
        if(playHandCheck > balance){
            System.out.println("You don't have enough money to play pair against the dealer. Enter a valid amount : ");
            return false;
        }
        return true;
    }
//IDK IF I NEED THIS
    @Override
    public <T extends PlayerInterface> void exitGame(T player) {
        exitGame((ThreeCardPokerPlayer) player);
    }

    public void exitGame(ThreeCardPokerPlayer player) {
        player.getAccount().setBalance(balance);
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

        System.out.println("? , ? , ?");

    }
    public void dealPlayerHand(){
        playerCard1 = dealOneCard();
         valueOfCard1 = String.valueOf(playerCard1.charAt(0));
         suitOfCard1 = String.valueOf(playerCard1.charAt(1));
        playerOneHand.add(playerCard1);
        playerCard2 = dealOneCard();
         valueOfCard2 = String.valueOf(playerCard1.charAt(0));
         suitOfCard2 = String.valueOf(playerCard1.charAt(1));
        playerOneHand.add(playerCard2);
        playerCard3 = dealOneCard();
         valueOfCard3 = String.valueOf(playerCard1.charAt(0));
         suitOfCard3 = String.valueOf(playerCard1.charAt(1));
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


    public void pairPlusOdds(ArrayList<String> playersHand) {
        String RoyalFlush = null;
        String straightFlush = null;
        String threeOfAKind = null;;
        String straight = null;;
        String flush = null;;
        String pair = null;;
        while(pairPlus && playedHand)
        {
            switch (playersHand) {
                case RoyalFlush:
                    if (3 > 1) {
                        winnings = wagerAmount * 100;
                        balance += winnings;
                        playerWon();

                    }
                    break;
                case straightFlush:
                    if (2 > 1) {
                        winnings = wagerAmount * 40;
                        balance += winnings;
                        playerWon();
                    }
                    break;
                case threeOfAKind:
                    if (33> 1) {
                        winnings = wagerAmount * 30;
                        balance += winnings;
                        playerWon();
                    }
                    break;
                case straight:
                    if (Integer.parseInt(valueOfCard1) +1  == Integer.parseInt(valueOfCard2)  ) {
                        winnings = wagerAmount * 6;
                        balance += winnings;
                        playerWon();
                    }
                    break;
                case flush:
                    if (5> 1) {
                        winnings = wagerAmount * 3;
                        balance += winnings;
                        playerWon();
                    }
                    break;
                case pair:
                    if (6 > 1) {
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
    public void anteBonusOdds(ArrayList<String> playersHand){
        String straightFlush;
        String threeOfAKind;
        String straight;
        while(pairPlus && playedHand){
            switch (playersHand){
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
