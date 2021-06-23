package com.school;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HeightConverter {
    //instantiate java.util.scanner as sc
    public static Scanner sc = new Scanner(System.in);
    //main argument and entry point to application
    public static void main(String[] args) {
        // ask user for height in CLI
        System.out.println("Please enter your height in first feet, and then inches ");
        // store feet from user
        String footHeight = sc.next();
        //assign user input value to string variable
        String inchHeight = sc.next();
        System.out.printf("Thank you. You have entered %s\'%s\"", footHeight, inchHeight);
        /*
        this decimal formal will allow us to round all calculated values to 2 decimal values
        and convert to a string at the same time
         */
        DecimalFormat df = new DecimalFormat("0.000");
        /*
        get the total height in centemeters by multiplying the feet by 12 and adding the inches then multiplying by 2.54
         */
        String totalHeightCentimeterssS = df.format(((Integer.valueOf(footHeight) * 12) + Integer.valueOf(inchHeight)) * 2.54);

        /*
        print the height in centimeters. the delimiter %s is an argument place holder so when any following arguments
        are placed in printf() the format string (first argument) will use all following arguments
        to replace them in order. /n is a line break
         */
        System.out.printf("\nYou are %s centimeters tall", totalHeightCentimeterssS);
    }
}
