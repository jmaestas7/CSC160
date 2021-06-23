package com.school;

import java.util.Scanner;
public class SubStringTest {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String String1 = scan.nextLine();
        System.out.println("Enter another string: ");
        String String2 = scan.nextLine();
        if (String2.indexOf(String1) >= 0)
            System.out.println(String1 + " is a substring of " + String2 +".");
        else
            System.out.println(String1 + " is not a substring of " + String2 +".");

    }
}
