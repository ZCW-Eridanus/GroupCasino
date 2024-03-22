package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;

import java.util.*;

public class RouletteGame implements GameInterface {

    public   int wager;

    public CasinoAccount casinoAccount = new CasinoAccount();
    private int balance;

    public RouletteGame(){
        casinoAccount.setBalance(2500);
        this.balance = casinoAccount.getBalance();
    }

    private String red = String.valueOf(AnsiColor.RED);
    private String black = String.valueOf(AnsiColor.BLACK);
    private List<Integer> column1 = new ArrayList<>();
    private List<Integer> column2 = new ArrayList<>();
    private List<Integer> column3 = new ArrayList<>();
    private List<Integer> low = new ArrayList<>();
    private List<Integer> high = new ArrayList<>();
    private List<Integer> dozen1 = new ArrayList<>();
    private List<Integer> dozen2 = new ArrayList<>();
    private List<Integer> dozen3 = new ArrayList<>();
    private List<Integer> numbersOnTheRed = new ArrayList<>();
    private List<Integer> numberOnTheBlack = new ArrayList<>();
    private  List<Integer> single = new ArrayList<>();
    Random random = new Random();
    Scanner scan = new Scanner(System.in);
    int spin = random.nextInt(37);

    public void setBlackNumbers(List<Integer> blackNumbers) {
        blackNumbers.add(1);
    }

    public List<Integer> getBlackNumbers() {
        return numberOnTheBlack;
    }

    public int betWithColorRed(int number, int wager){
        setBlackNumbers(numberOnTheBlack);
        if(numberOnTheBlack.contains(number)){
            balance = balance - wager;
            return  balance = balance + 2 * wager;
        }
        else {
            return balance;
        }

    }


    public int betWithColorBlack(int number,int wager){
        setBlackNumbers(numberOnTheBlack);
        if(numberOnTheBlack.contains(number)){
            balance = balance - wager;
            return  balance = balance + 2 * wager;
        }
        else {
            return balance;
        }
    }

    public int betWithEvenNumber(int number,int wager){
        if(number%2==0&&number!=0){
            balance = balance - wager;
            return  balance = balance + 2 * wager;
        }
        else {
            return balance;
        }
    }

    public int betWithOddNumber(int number, int wager){

        if(number % 2 != 0){
            balance = balance - wager;
            return  balance = balance + 2 * wager;
        }
        else {
            return balance;
        }
    }

    public int betWithLow(int number, int wager){
        setLow(low);
        if(low.contains(number)){
            balance = balance - wager;
            return balance = balance + 2 * wager;
        }
        return balance;
    }
    public int betWithHigh(int number, int wager){
        setHigh(high);
        if(high.contains(number)){
            balance = balance - wager;
            return balance = balance + 2 * wager;
        }
        return balance;
    }

    public int betWithColumn1(int number,int wager){
        setColumn1(column1);
        if(getColumn1().contains(number)){
            balance = balance - wager;
            return  balance = balance + 3 * wager;
        }
         else {
            return balance;
        }
    }

    public int betWithColumn2(int number,int wager){
        setColumn2(column2);
        if(getColumn2().contains(number)){
            balance = balance - wager;
            return  balance = balance + 3 * wager;
        }
        else {
            return balance;
        }
    }
    public int betWithColumn3(int number,int wager){
        setColumn3(column3);
        if(getColumn3().contains(number)){
            balance = balance - wager;
            return  balance = balance + 3 * wager;
        }
        else {
            return balance;
        }
    }

    public int betWithSingle(int number,int wager){
        setSingle(single);
        if(getSingle().contains(number)){
            balance = balance - wager;
            return  balance = balance + 36 * wager;
        }
        else {
            return balance;
        }
    }

    public int betWithDozen1(int number,int wager){
        setDozen1(dozen1);
        if(getDozen1().contains(number)){
            balance = balance - wager;
            return  balance = balance + 3 * wager;
        }
        else {
            return balance;
        }
    }

    public int betWithDozen2(int number,int wager){
        setDozen2(dozen2);
        if(getDozen2().contains(number)){
            balance = balance - wager;
            return  balance = balance + 3 * wager;
        }
        else {
            return balance;
        }
    }

    public int betWithDozen3(int number,int wager){
        setDozen3(dozen3);
        if(getDozen3().contains(number)){
            balance = balance - wager;
            return  balance = balance + 3 * wager;
        }
        else {
            return balance;
        }
    }


    public void setColumn1(List<Integer> column1) {
        for(int i = 1;i<=34;i=i+3){
            this.column1.add(i);
        }
    }
    public List<Integer> getColumn1(){
        return column1;
    }

    public void setColumn2(List<Integer> column2) {
        for(int i = 2;i<=35;i=i+3){
            this.column2.add(i);
        }
    }
    public List<Integer> getColumn2(){
        return column2;
    }

    public void setColumn3(List<Integer> column3) {
        for(int i = 3;i<=36;i=i+3){
            this.column3.add(i);
        }
    }
    public void setLow(List<Integer> low) {
        for(int i = 1;i<=18;i++){
            this.low.add(i);
        }
    }

    public List<Integer> getLow() {
       return low;
    }

    public void setHigh(List<Integer> high) {
        for(int i = 19;i<=36;i++){
            this.high.add(i);
        }
    }

    public List<Integer> getHigh() {
        return high;
    }

    public List<Integer> getColumn3(){
        return column3;
    }

    public void setSingle(List<Integer> single) {
        for(int i = 0;i<37;i++){
            this.single.add(i);
        }
    }

    public List<Integer> getSingle(){
        return single;
    }


    public void setDozen1(List<Integer> list){
        for(int i = 1;i<13;i++){
            dozen1.add(i);
        }
    }

    public void setDozen2(List<Integer> list){
        for(int i = 13;i<25;i++){
            dozen2.add(i);
        }
    }

    public void setDozen3(List<Integer> list){
        for(int i = 24;i<37;i++){
            dozen3.add(i);
        }
    }

    public List<Integer> getDozen1(){
        return dozen1;
    }
    public List<Integer> getDozen2(){
        return dozen2;
    }
    public List<Integer> getDozen3(){
        return dozen3;
    }



    int getNumber(String message) {
        while (true) {
            System.out.print(message + "\t");
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\"" + scan.next() + "\" isn't a number!");
            }
        }
    }

    public void betMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("1.Red").append("\n")
                .append("2.Black").append("\n")
                .append("3.Even").append("\n")
                .append("4.Odd").append("\n")
                .append("5.Low 1 through 18").append("\n")
                .append("6.High 19 through 36").append("\n")
                .append("7.1st Column").append("\n")
                .append("8.2nd Column").append("\n")
                .append("9.3rd Column").append("\n")
                .append("10.1st Dozen 1 through 12").append("\n")
                .append("11.2nd Dozen 13 through 24").append("\n")
                .append("12.3rd Dozen 25 through 36").append("\n")
                        .append("13.Single Number");
        System.out.println(sb.toString());

    }



    @Override
    public void run() {
        //put code here
        System.out.println("Welcome to Roulette Game");
        int defaultBalance = balance;
        while (true) {
            betMenu();
            int wheelSpin = spin;
            while (true) {
                System.out.println("Please choose $1, $5, $10, $50, $100, $500 ");
                int wager = getNumber("Enter wager amount");
                System.out.println("Please enter bet options");
                int betOption = scan.nextInt();
                    switch (betOption) {
                        case 1:
                            System.out.println("Please enter bet number");
                            int red = scan.nextInt();
                            if(wheelSpin==red){
                                betWithColorRed(red, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                        case 2:
                            System.out.println("Please enter bet number");
                            int black = scan.nextInt();
                            if(wheelSpin==black){
                                betWithColorRed(black, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                        case 3:
                            System.out.println("Please enter bet number");
                            int even = scan.nextInt();
                            if(wheelSpin==even){
                                betWithEvenNumber(even, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                        case 4:
                            System.out.println("Please enter bet number");
                            int odd = scan.nextInt();
                            if(wheelSpin==odd){
                                betWithOddNumber(odd, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                        case 5:
                            System.out.println("Please enter bet number");
                            int low = scan.nextInt();
                            if(wheelSpin==low){
                                betWithLow(low, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                        case 6:
                            System.out.println("Please enter bet number");
                            int high = scan.nextInt();
                            if(wheelSpin==high){
                                betWithHigh(high, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                        case 7:
                            System.out.println("Please enter bet number");
                            int column1 = scan.nextInt();
                            if(wheelSpin==column1){
                                betWithColumn1(wheelSpin, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                        case 8:
                            System.out.println("Please enter bet number");
                            int column2 = scan.nextInt();
                            if(wheelSpin==column2){
                                betWithColumn1(column2, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                        case 9:
                            System.out.println("Please enter bet number");
                            int column3 = scan.nextInt();
                            if(wheelSpin==column3){
                                betWithColumn1(column3, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                        case 10:
                            System.out.println("Please enter bet number");
                            int dozen1 = scan.nextInt();
                            if(wheelSpin==dozen1){
                                betWithDozen1(dozen1, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                        case 11:
                            System.out.println("Please enter bet number");
                            int dozen2 = scan.nextInt();
                            if(wheelSpin==dozen2){
                                betWithDozen1(dozen2, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                        case 12:
                            System.out.println("Please enter bet number");
                            int dozen3 = scan.nextInt();
                            if(wheelSpin==dozen3){
                                betWithDozen1(dozen3, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                        case 13:
                            System.out.println("Please enter bet number");
                            int single = scan.nextInt();
                            if(wheelSpin==single){
                                betWithSingle(single, wager);
                            }
                            else {
                                balance = balance-wager;
                            }
                            break;
                    }
                    System.out.println("Would you like to continue add bet Y/N?");
                    String yesNo = scan.next();

                    if (yesNo.equalsIgnoreCase("y")&&balance>0) {
                        continue;
                    } else {
                        System.out.println("Balance: "+balance);
                        if(balance>defaultBalance){
                            System.out.println("Congratulation you Win! "+ (balance-defaultBalance));
                        }
                        else {
                            System.out.println("Dealers Wins! "+ (defaultBalance-balance));
                        }
                        break;
                    }
                }//inner loop

            System.out.println("Start New Game Y/N?");
            String yesNo = scan.next();

            if (yesNo.equalsIgnoreCase("y")) {
                continue;
            }
            else {
                System.out.println("Balance: "+balance);
                break;
            }
            }//outer loop



        }//method

    @Override
    public void run(CasinoAccount acct) {

    }

    @Override
    public <T extends PlayerInterface> char playGame(T player) {

        playGame();
        return '\n';
    }

    public void playGame() {

    }

    @Override
    public void setWager(int wager) {
        this.wager = wager;
    }

    @Override
    public <T extends PlayerInterface> void action(T player) {
        action();
    }

    @Override
    public <T extends PlayerInterface> void exitGame(T player) {

    }

    public int getWager(){
        return wager;
    }

    public void action() {

    }

    public void exitGame() {

    }
}
