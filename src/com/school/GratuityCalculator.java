/*
* Jarred Maestas
* */
package com.school;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GratuityCalculator {
    //instantiate java.util.scanner as sc
    public static Scanner sc = new Scanner(System.in);
    //main argument and entry point to application
    public static void main(String[] args) {
        //set fixed anf final value for gratuity rate
        final float fixedGratuityRate = 0.15F;
        // ask user for name in CLI
        System.out.println("Please enter your name");
        // store name from user input
        String name = sc.next();
        System.out.println("Please enter a subtotal to 2 or less decimal places or a whole number");
        //assign user input value to string variable
        String subtotalStr = sc.next();
        // function to validate and convert entered subtotal to float
        float validatedSubtotalF = validateAndConvertSubtotalStrToFloat(subtotalStr);
        // get subtotal value to String (we'll need this for the bill print)
        String validatedSubtotalS = String.valueOf(validatedSubtotalF);
        /*
        this decimal formal will allow us to round all calculated values to 2 decimal values
        and convert to a string at the same time
         */
        DecimalFormat df = new DecimalFormat("0.00");
        /*
        get the total by multiplying the subtotal by 100 + the gratuity percentage
        (notice how the decimal format is used, it intakes non-string value and converts it to the requested format)
         */
        String totalS = df.format(validatedSubtotalF * (1+ fixedGratuityRate));
        // get float value of total
        Float totalF = Float.valueOf(totalS);
        // use the total to now subtract the subtotal to calulate the tip
        String gratuity = df.format(totalF - validatedSubtotalF);
        // create a whole number string of the gratuity rate as a percent to print on the bill
        String gratuityS = String.valueOf(Math.round(fixedGratuityRate*100));

        /*
        print the bill. the delimiter %s is an argument place holder so when any following arguments
        are placed in printf() the format string (first argument) will use all following arguments
        to replace them in order. %% is used to escape itself so we can print %
         */
        System.out.printf("Thank You For Coming \n\n   %s's Bill \n\n  Subtotal: $%s\n   %s%% Tip: $%s\n--------------------\n     Total: $%s",
                name,
                validatedSubtotalS,
                gratuityS,
                gratuity,
                totalS);

    }
    public static Float validateAndConvertSubtotalStrToFloat(String s){
        /*
        if the string is not empty and match regex pattern matches whole number values to "infinity"
        or with less than 2 decimal places the return the parsed value of the string as a double
         */
        if(!s.isEmpty() || s.matches("/^[1-9]\\d*(\\.\\d{2})?$/")){
            return Float.parseFloat(s);
        /*
        if not then re-ask user for a valid value and rerun the function and return nothing
        */
        } else {
            s = sc.next();
            System.out.println("Please enter a VALID subtotal");
            validateAndConvertSubtotalStrToFloat(s);
            return null;
        }
    }
}
