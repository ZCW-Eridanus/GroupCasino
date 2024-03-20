package com.github.zipcodewilmington.casino.games.BigWheel;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.ThreeCardPoker.ThreeCardPokerPlayer;

import java.util.Scanner;

public class BigWheelGame implements GameInterface{
    public static Scanner scanner = new Scanner(System.in);

    BigWheelPlayer player;
    double balance;
    public int wagerAmount;
    public int playerChosenSlot;
    public int selectedMultiplier;
    public int winnings;
    @Override
    public void run() {
        while (true) {
            if (playGame(player) == 'n') {
                exitGame(player);
                break;
            }
            rulesAndOdds(player);
            setWager(wagerAmount);
            spinTheWheel(player);
            playerWon();
            playerLost();
            endWheelTurn();
        }
    }

    @Override
    public void run(CasinoAccount curr) {
        player = new BigWheelPlayer(curr);
        balance = curr.getBalance();
        run();
    }

    @Override
    public <T extends PlayerInterface> char playGame(T player) {
        return playGame((BigWheelPlayer) player);
    }

    public void rulesAndOdds(BigWheelPlayer player){

    }


    @Override
    public void setWager(int wager) {
        System.out.println("Where would you like to place your wager? ");
        System.out.println("__________________");
        System.out.println(" Type 1 - 1X");
        System.out.println(" Type 2 - 2x");
        System.out.println(" Type 5 - 5X");
        System.out.println(" Type 10 - 10X");
        System.out.println(" Type 20 - 20X");
        System.out.println(" Type 40 - 40X");
        System.out.println("___________________");
        System.out.print("Choice: ");
        playerChosenSlot = scanner.nextInt();
        switch (playerChosenSlot) {
            case 1:
                selectedMultiplier = 1;
                break;
            case 2:
                selectedMultiplier = 2;
                break;
            case 5:
                selectedMultiplier = 5;
                break;
            case 10:
                selectedMultiplier = 10;
                break;
            case 20:
                selectedMultiplier = 20;
                break;
            case 40:
                selectedMultiplier = 40;
                break;
            default:
                System.out.println("\nInvalid Choice.");

                boolean isInputValid;
                System.out.println(" ");
                System.out.println("Enter your wager to play : ");
                wagerAmount = scanner.nextInt();
                isInputValid = validateWagerInput(wagerAmount);
                while (!isInputValid) {
                    wagerAmount = scanner.nextInt();
                    isInputValid = validateWagerInput(wagerAmount);
                }
                balance -= wagerAmount;
        }
    }
    public boolean validateWagerInput(int wagerCheck){
        if(wagerCheck > balance){
            System.out.println("You don't have enough credits. Enter a valid amount : ");
            return false;
        }
        return true;
    }

    @Override
    public <T extends PlayerInterface> void action(T player) {
        action(((BigWheelPlayer) player));
    }

    @Override
    public <T extends PlayerInterface> void exitGame(T player) {
        exitGame((BigWheelPlayer) player);
    }
    public int spinTheWheel(){

    }
    public void playerWon(){
        System.out.println("You won " + winnings);
    }
    public void playerLost(){
            System.out.println("Sorry you did not win.");
    }
}