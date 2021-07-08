package com.school;

import java.util.Locale;
import java.util.Scanner;

public class CrapsTable {

    public static void main(String[] args) {
        /*
        Initialize boolean variable which is used to keep the loop going or end it.
        Default init value is true
         */
        Boolean playAgain;
        /*
        Do/while loop will always loop at least once
         */
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Let's play some craps!\nPress Enter to roll your dice");
            /*
            Wait for user to press enter to move on
             */
            sc.nextLine();
            /*
            Use rollDice function to set 2 SEPARATE values of dice. Then add them together as
            as a sum of their values
            (It's important to do this instead of finding value 2 to 12 because the statistical
            spread is different than that of 2 rolled dice)
             */
            Integer diceOne = rollDice();
            Integer diceTwo = rollDice();
            Integer diceSum = diceOne + diceTwo;
            /*
            Print users initiual dice values and sum
             */
            System.out.printf("You rolled a %s and a %s which is %s\n",
                    String.valueOf(diceOne),
                    String.valueOf(diceTwo),
                    String.valueOf(diceSum));
            /*
            If the user rolls an initial 7 or 11 print winning phrase and dice sum
             */
            if (diceSum.equals(7) || diceSum.equals(11)){
                System.out.printf("Congratulations! You win! You rolled a %s on your first throw\n", diceSum);
            /*
            Else if user rolls an inital 2, 3, or 12 print loosing phrase and dice sum
             */
            } else if (diceSum.equals(2) || diceSum.equals(3) || diceSum.equals(12)) {
                System.out.printf("Sorry, you lose. You rolled a %s on your first throw\n", diceSum);
            /*
            All other cases of dice value
             */
            } else {
                /*
                Set dice value equal to a new variable playersPoint
                 */
                Integer playersPoint = diceSum;
                /*
                Initiate boolean 'exit' which will be used to break or continue loop
                 */
                Boolean exit;
                /*
                Print user's player point
                 */
                System.out.printf("Your player point is now %s.\n", playersPoint);
                /*
                Loop at hleast once
                 */
                do{
                    System.out.println("Press Enter to roll again");
                    /*
                    When user presses enter move on
                     */
                    sc.nextLine();
                    /*
                    Use rollDice function to set 2 SEPARATE values of dice. Then add them together as
                    as a sum of their values
                     */
                    diceOne = rollDice();
                    diceTwo = rollDice();
                    diceSum = diceOne + diceTwo;
                    /*
                    If ther rolled sum equals 7 break loop by setting exit = false and print loosing phrase
                    */
                    if(diceSum.equals(7)) {
                        System.out.printf("Sorry, you lose. You rolled a 7\n");
                        exit = false;
                    /*
                    else if the playerPoint equals the new dice roll print winning phrase and dice sum and break loop
                     */
                    } else if(playersPoint.equals(diceSum)){
                        System.out.printf("You made your point! You rolled a %s and a %s which is %s\n",
                                String.valueOf(diceOne),
                                String.valueOf(diceTwo),
                                String.valueOf(diceSum));
                        exit = false;
                    /*
                    If dice not 7 or equal to player point, do not break loop and print user to try again
                     */
                    } else {
                        System.out.printf("You rolled a %s and a %s which is %s\nTry again.\n",
                                String.valueOf(diceOne),
                                String.valueOf(diceTwo),
                                String.valueOf(diceSum));
                        exit = true;
                    }
                /*
                this will break the loop when exit = false, and not when exit = true
                 */
                } while(exit);
            }
            /*
            ask user to play again and input Y or N. use single line conditional if the user input equals Y
            set playAgain equal to true. Other wise set to false
             */
            System.out.println("Would you like to play again? Y/N");
            playAgain = (sc.nextLine().toLowerCase().equals("y"));
        /*
        while playAgain equals true start loop over restarting the game, if not break
         */
        } while(playAgain);
    }

    /**
     * rolls virtual dice
     * @return Integer between 1 and 6
     */
    private static Integer rollDice(){
        return (int) Math.ceil(Math.random()*6);
    }
}
