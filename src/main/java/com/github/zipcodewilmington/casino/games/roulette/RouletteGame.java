package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.utils.AnsiColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RouletteGame implements GameInterface {

    int wager;
    private int balance = 500;
    private String red = String.valueOf(AnsiColor.RED);
    private String black = String.valueOf(AnsiColor.BLACK);
    private List<Integer> column1 = new ArrayList<>();
    private List<Integer> column2 = new ArrayList<>();
    private List<Integer> column3 = new ArrayList<>();
    private  List<Integer> single = new ArrayList<>();
    Random wheel = new Random();
    Scanner scan = new Scanner(System.in);
    int number = wheel.nextInt(37);

    public int betWithColorRed(String color,int wager){
        balance = balance - wager;
        if(color.equals("red")){
            return  balance = balance + 2 * wager;
        }
        else {
            return balance;
        }

    }

    public int betWithColorBlack(String color,int wager){
        balance = balance - wager;
        if(color.equals("black")){
            return  balance = balance + 2 * wager;
        }
        else {
            return balance;
        }
    }

    public int betWithColorRedAndBlack(String red,String black,int wager){
        balance = balance - wager;
        if(red.equals("red")||black.equals("black")){
            return  balance = balance + 2 * wager;
        }
        else {
            return balance;
        }
    }

    public int betWithEvenNumber(int number,int wager){
        balance = balance - wager;
        if(number%2==0&&number!=0){
            return  balance = balance + 2 * wager;
        }
        else {
            return balance;
        }
    }

    public int betWithOddNumber(int number, int wager){
        balance = balance - wager;
        if(number % 2 != 0){
            return  balance = balance + 2 * wager;
        }
        else {
            return balance;
        }
    }

    public int betWithColumn1(int wager,int number){
        setColumn1(column1);
        balance = balance - wager;
        if(getColumn1().contains(number)){
            return  balance = balance + 3 * wager;
        }
         else {
            return balance;
        }
    }

    public int betWithColumn2(int wager,int number){
        setColumn2(column2);
        balance = balance - wager;
        if(getColumn2().contains(number)){
            return  balance = balance + 3 * wager;
        }
        else {
            return balance;
        }
    }
    public int betWithColumn3(int wager,int number){
        setColumn3(column3);
        balance = balance - wager;
        if(getColumn3().contains(number)){
            return  balance = balance + 3 * wager;
        }
        else {
            return balance;
        }
    }

    public int betWithSingle(int wager,int number){
        setSingle(single);
        balance = balance - wager;
        if(getSingle().contains(number)){
            return  balance = balance + 36 * wager;
        }
        else {
            return balance;
        }
    }

    public void setColumn1(List<Integer> column1) {
        for(int i = 1;i<=36;i=i+3){
            column1.add(i);
        }
        this.column1 = column1;
    }
    public List<Integer> getColumn1(){
        return column1;
    }

    public void setColumn2(List<Integer> column2) {
        for(int i = 2;i<=36;i=i+3){
            column2.add(i);
        }
        this.column2 = column2;
    }
    public List<Integer> getColumn2(){
        return column2;
    }

    public void setColumn3(List<Integer> column3) {
        for(int i = 3;i<=36;i=i+3){
            column3.add(i);
        }
        this.column3 = column3;
    }
    public List<Integer> getColumn3(){
        return column3;
    }

    public void setSingle(List<Integer> single) {
        for(int i = 0;i<37;i++){
            single.add(i);
        }
        this.single = single;
    }

    public List<Integer> getSingle(){
        return single;
    }

    @Override
    public void run() {

    }

    @Override
    public void run(CasinoAccount acct) {

    }

    @Override
    public void playGame() {

    }

    @Override
    public void setWager(int wager) {
        this.wager = wager;
    }

    public int getWager(){
        return wager;
    }

    @Override
    public void action() {

    }

    @Override
    public void exitGame() {

    }
}
