package com.github.zipcodewilmington.casino.games.BigWheel;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class BigWheelGame implements GameInterface{
    String[] wheelNumbers = {"7x Multiplier","2","1","5","1","2","5","1","2","10","1","2","1","20","1","2","1","2","1",
            "5","1","2","10","1","5","1","2","2x Multiplier","1","5","1","40","2","1","2","1","10","2","1","5","1","2","1","5",
            "2","1","20","1","2","1","10","1","2","1"};
    public static Scanner scanner = new Scanner(System.in);
    BigWheelPlayer player;
    double balance;
    public int wagerAmount;
    int selectedMultiplier;
    String winningNumber;
    public int winnings;
    @Override
    public void run() {
        while (true) {
            if (playGame(player) == 'n') {
                exitGame(player);
                break;
            }
            setWager(wagerAmount);
            action(player);
            calculateWinnings(winningNumber);
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
        selectedMultiplier = scanner.nextInt();


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

    public boolean validateWagerInput(int wagerCheck){
        if(wagerCheck > balance){
            System.out.println("You don't have enough credits. Enter a valid amount : ");
            return false;
        }
        return true;
    }

    @Override
    public <T extends PlayerInterface> void action(T player) {

        System.out.println("Get ready and let's spin!");
        winningNumber = String.valueOf(new Random().nextInt(wheelNumbers.length));
        System.out.println("The wheel has landed on : " + wheelNumbers[Integer.parseInt(winningNumber)] + " !");
        action(((BigWheelPlayer) player));
    }



    public int didItLandOnMultiplier(String winningNumber) {
        if (winningNumber.equals("7x Multiplier") || winningNumber.equals("2x Multiplier")) {
            action(player);
            return spinWheel();
        }
        return 1;
    }

    private int spinWheel() {
        int newWinningNumber = new Random().nextInt(wheelNumbers.length);
        System.out.println("Spinning the wheel again...");
        return newWinningNumber;
    }

    public int calculateWinnings(String winningNumber) {
        int multiplier = didItLandOnMultiplier(winningNumber);
        switch (wagerAmount) {
            case 1:
                return multiplier == 1 ? winnings = wagerAmount : wagerAmount ;
            case 2:
                return multiplier == 2 ? winnings =  wagerAmount * 2 : wagerAmount;
            case 5:
                return multiplier == 5 ? winnings = wagerAmount * 5 : wagerAmount;
            case 10:
                return multiplier == 10 ? winnings = wagerAmount * 10 : wagerAmount;
            case 20:
                return multiplier == 20 ? winnings = wagerAmount * 20 : wagerAmount;
            case 40:
                return multiplier == 40 ? winnings = wagerAmount * 40 : wagerAmount;
            default:
                System.out.println("\nInvalid Choice.");
                return 0;
        }
    }

    @Override
    public <T extends PlayerInterface> void exitGame(T player) {
        exitGame((BigWheelPlayer) player);
    }
    public void playerWon(){
        System.out.println("You won " + winnings);
    }
    public void playerLost(){
            System.out.println("Sorry you did not win.");
    }
    public void endWheelTurn(){
        System.out.println("Would you like to play again? Yes/No");
        if(scanner.nextLine().toLowerCase().equals("yes")){
            run();
        }
        else exitGame(player);
    }
}