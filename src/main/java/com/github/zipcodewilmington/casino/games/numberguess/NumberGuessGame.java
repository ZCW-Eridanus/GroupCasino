package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame implements GameInterface {
    NumberGuessPlayer player;
         public int mysteryNumber;
         public int guessRemaining = 25;
         int noMoreGuesses = 0;
         public int yourGuess;
         public boolean isPlaying = true;

         @Override
        public void run() {

            while (true) {
                if (toPlay().equals("no")) {
                    exitGame(player);
                    break;
                }
                mysteryNumber = chosenMysteryNumber();
                guessRemaining = 20;
                System.out.println("The Mystery Number is between 1 and 10,000! You have 20 guesses! Good luck :)");
                while (guessRemaining > noMoreGuesses) {
                    yourNumberGuess();
                    action(player);
                    didYouLose();
                    if (!isPlaying) break;
                }
            }
        }



    @Override
    public <T extends PlayerInterface> char playGame(T player) {
        return 0;
    }

    //THE NUMBER
        public  int chosenMysteryNumber() {
            int max = 10000, min = 1;
            return min + (int) (Math.random() * (max - min + 1));
        }


    @Override
    public <T extends PlayerInterface> void action(T player) {
            if (yourGuess == mysteryNumber) {
                System.out.println("You guessed the Number!!! WINNER");
            } else if (yourGuess > mysteryNumber){
                System.out.println("The number is lower!");
                System.out.println("You have " + guessRemaining + " remaining");
            } else{
                System.out.println("The number is higher!");
                System.out.println("You have " + guessRemaining + " remaining");
            }
        }
//THE NUMBER


        //SCANNERS
        public  String toPlay() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Do you want to play? Yes/No");
            //todo handle any input thats not yes or no
            return scan.next().toLowerCase();
        }
        public  void yourNumberGuess() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your number guess : ");
            yourGuess = scan.nextInt();
            System.out.println("You typed : " + yourGuess);
            guessRemaining--;
        }
//SCANNERS

        //END GAME RESULTS
        public  void didYouLose() {
            if (guessRemaining == 0){
                System.out.println("You're our of guesses... LOSER!!!");
            }
        }
    @Override
    public <T extends PlayerInterface> void exitGame(T player) {
            System.out.println("Goodbye!");
        }






    @Override
    public void run(CasinoAccount acct) {

    }

    @Override
    public void setWager(int wager) {

    }
    }
//END GAME RESULTS

