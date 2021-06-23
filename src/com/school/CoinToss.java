package com.school;

import java.util.Scanner;

public class CoinToss {

    final static int HEADS = 1;
    final static int TAILS = 0;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Integer computerCoinValue = getRandomCoinValue();
        System.out.println("Guess the coin toss. Enter 1 for heads and 0 for tails");
        Integer userCoinValue = sc.nextInt();
        String computerCoinStr = coinToString(computerCoinValue);
        String userCoinStr = coinToString(userCoinValue);

        if(userCoinValue.equals(computerCoinValue)) {
            System.out.printf("Congratulations! Your guess was %s and the computers was %s", userCoinStr, computerCoinStr);
        } else {
            System.out.printf("Sorry. Your guess was %s and the computers was %s", userCoinStr, computerCoinStr);
        }
    }

    public static Integer getRandomCoinValue(){
        if(Math.random() < 0.5) {
            return TAILS;
        } else {
            return HEADS;
        }
    }

    public static String coinToString(Integer coinInt){
        String coinStr = null;
        switch(coinInt){
            case HEADS:
                coinStr =  "HEADS";
                break;
            case TAILS:
                coinStr =  "TAILS";
                break;
        }
        return coinStr;
    }
}
