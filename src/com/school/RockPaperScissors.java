package com.school;

import java.util.Scanner;

public class RockPaperScissors {
    /*
    Initialize constants. The program is specifically setup this way so if any of the values of
    the constant change, assuming no of them are the same, the game will still function normally
     */
    final static int ROCK = 0;
    final static int PAPER = 1;
    final static int SCISSORS = 2;
    /*
    Initialize scanner object
     */
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Play Rock, Paper, Scissors!");
        /*
        Initialize boolean variable which is used to keep the loop going or end it.
        Default init value is true
         */
        Boolean playAgain;
        /*
        Do/while loop will always loop at least once
         */
        do {
            /*
            Use the getRandomRPSValue to return random integer from 0 to 2 and store
             */
            Integer compVal = getRandomRPSValue();
            /*
            This for loop is used to simply print to the user what value equates to what string value of
            rock, paper, or scissors. Again this was implemented because no matter what value order they are in
            the game will still still function the same.
             */
            try {
                for (int i = 0; i <= 2; i++) {
                    System.out.printf("Enter %s for %s\n", i, valueToString(i));
                }
                /*
                - get user input value (no validation).
                Using Integer.valueOf(string) because if the user inputs a character the program will exit if we
                use sc.nextInt due to InputMismatchException. This way we will experience a NumberFormatException
                instead which can be caught without exiting the program
                 */
                Integer usrValue = Integer.valueOf(sc.next());
                /*
                use valueToString() to get the string value of both user and computer guess to print messages below
                 */
                String computerValStr = valueToString(compVal);
                String userValStr = valueToString(usrValue);
                /*
                If the user and computer value are equal, the game is a tie
                 */
                if (usrValue.equals(compVal)) {
                    System.out.printf("Tie, go again! Your guess was %s and the computers was %s\n", userValStr, computerValStr);
                } else {
                    /*
                    if the user matches any of the conditions in which they will be beat, the gme is a loss
                     */
                    if ((usrValue.equals(ROCK) && compVal.equals(PAPER)) || (usrValue.equals(PAPER) && compVal.equals(SCISSORS) || usrValue.equals(SCISSORS) && compVal.equals(ROCK)))
                        System.out.printf("Sorry. You lose. Your guess was %s and the computers was %s\n", userValStr, computerValStr);
                    /*
                    last condition is the win condition
                     */
                    else {
                        System.out.printf("Congrats! You win! Your guess was %s and the computers was %s\n", userValStr, computerValStr);
                    }
                }
                /*
                Catch the integer being out of bounds 0 to 2 or type mismatch
                 */
            } catch (Exception e) {
                System.out.printf("Exception caught: %s\n", e.toString());
            }
             /*
            ask user to play again and input Y or N. use single line conditional if the user input equals Y
            set playAgain equal to true. Other wise set to false
             */
            System.out.println("Would you like to play again? Y/N");
            playAgain = (sc.next().equals("Y"));
            /*
            while the condition is the opposite of playAgain equals true (false) then start loop (game) over
             */
        } while (playAgain);
    }

    /**
     * Get random value 0 to 2 to represent value of rock, paper, or scissors
     *
     * @return int value from 0 to 2 inclusive
     */
    public static Integer getRandomRPSValue() {
        return (int) Math.floor(Math.random() * (3));
    }

    /**
     * Converts value from 0-2 to its RPS string value {0: "ROCK", 1: "PAPER", 2: "SCISSORS"}
     *
     * @param @notNull valInt from 0-2 inclusive
     * @return "ROCK", "PAPER", or "SCISSORS"
     * @throws Exception when value is out of range
     */
    public static String valueToString(Integer valInt) throws Exception {
        String valStr;
        /*
        switch/case statement will always return the correct string of its respective value. This is
        because the constant string is linked to the constant name. If the value for some reason was
        ever out of the range odf 0 to 2. Throw exception.
         */
        switch (valInt) {
            case PAPER:
                valStr = "PAPER";
                break;
            case ROCK:
                valStr = "ROCK";
                break;
            case SCISSORS:
                valStr = "SCISSORS";
                break;
            default:
                throw new Exception("Value was not in the range of 0 to 2 inclusive");
        }
        return valStr;
    }
}
