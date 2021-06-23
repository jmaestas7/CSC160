package com.school;

import java.util.Scanner;

public class PigLatin {
    /*
    Initialize scanner object
     */
    final static Scanner sc = new Scanner(System.in);
    /*
    define list of common prefixes. We will use it to iterate over to check if the word starts
    with any of them
     */
    final static String[] commonPrefixes = {
            "bl", "br", "ch", "cl", "cr", "dr", "fl",
            "fr", "gl", "gr", "kl", "ph", "pl", "pr",
            "sh", "sl", "sp", "sr", "st", "th", "tr",
            "wh", "wr"};
    /*
    define phrase as a constant because I'm lazy and we use it multiple times anyways
     */
    final static String PHRASE = "Your word in pig latin is: ";

    public static void main(String[] args) {
        /*
        ask and store user input
         */
        System.out.println("Please enter a word");
        String userInput = sc.next();
        /*
        instantiate undefined pigLatinString which we will use below
         */
        String pigLatinString;
        /*
        utilize .matches() with regex as defined as:
        - (?i): match the remainder of the pattern with i flag modifier which ignores cases
        - ^: asserts start of string
        - [aeiou]: match first character with characters in brackets
        - .: matches any character (rest of string after first character)
        - *: matches the previous token between zero and unlimited times
        = $: asserts position at the end of the string
         */
        if(userInput.matches("(?i)^[aeiou].*$")){
            /*
            add "ay" to end
             */
            pigLatinString = userInput.concat("yay");
            /*
            print new pig latin string with PHRASE
            */
            System.out.println(PHRASE + pigLatinString);
        /*
        utilize startsWithCommonPrefix with user input (defined at function)
         */
        } else if (startsWithCommonPrefix(userInput)) {
            /*
            use .replaceFirst(regex, replacementString) with nothing "" with following regex
            parameter as defined:
            - ^: asserts start of string
            - .: matches any character (rest of string after first character)
            - {0,2}:  matches the previous token between 0 and 2 times
            then use .concat() to append substring() of first 2 characters and "ay" to new
            pigLatin string
             */
            pigLatinString = userInput
                    .replaceFirst("^.{0,2}", "")
                    .concat(userInput.substring(0, 2) + "ay");
            /*
            print new pig latin string with PHRASE
            */
            System.out.println(PHRASE + pigLatinString);
        } else {
            /*
            all other conditions use .replaceFirst() to remove first character (similar to above)
            then concatenate first letter to end of string and add "ay"
             */
            pigLatinString = userInput
                    .replaceFirst("^.?", "")
                    .concat(userInput.substring(0, 1) + "ay");
            /*
            print new pig latin string with PHRASE
            */
            System.out.println(PHRASE + pigLatinString);
        }

    }

    /**
     *
     * @param input user String input
     * @return Boolean if input contained any of the common prefixes
     */
    public static Boolean startsWithCommonPrefix(String input) {
        /*
        turn input into lower case so we don't need to separate lists of cases
         */
        input = input.toLowerCase();
        /* iterate from 0 to length of list and check for each prefix element if input
        starts with the element for which index of i the iteration currently is in. If a
        match is found then break loop by returning true
         */
        for (int i = 0; i < commonPrefixes.length; i++) {
            if (input.startsWith(commonPrefixes[i])) {
                return true;
            }
        }
        /*
        if the input string does not start with any in list, return false
         */
        return false;
    }

}
