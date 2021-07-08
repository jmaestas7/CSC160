/*
This is your Midterm exam and is worth 100 points.

For research purposes and to assist students, the admissions office of your local university wants to know how well
undergrad and grad students perform in certain courses.
You will receive input that contains undergrad and grad students' GPAs for certain courses.  Due to confidentiality,
the word "undergrad" is used for undergrad students and "grad" is used for grad students.

Every input entry consists of an undergrad/grad string followed by a GPA (for example, undergrad 3.9).  The number of
entries is unknown.

Write a program that computes and outputs the average GPA for both undergrad and grad students.  Format your results to
two decimal places.

Make your program take all the input from the user, reading in "undergrad" or "grad" followed by the GPA decimal value.
Loop until the user enters "quit".  As you are looping,
be computing the overall undergrad and grad GPA sums and how many GPAs you have entered (per undergrad and per grad).
Then after your loop, compute your two averages.

Requirements:
- take a String and a double as input from the user
- the user's input should be case-insensitive...that is, I should be able to enter Undergrad, GRAD, underGrad, etc and
  get the same results
- your output must come out to two decimal places using the System.printf method
- if the user enter's invalid input, print an error message
- use constants for "undergrad", "grad" and "quit"
- your output must look just like my example output

Add comments to your program starting with your name at the top, then throughout your program to describe what you are
doing.  Be sure and declare all the variables you need and make your calculations clear.  Give your variables meaningful
names.  Also be sure to indent consistently throughout your program to make it more readable.

Extra Credit: For 5 points of extra credit, make another version of your program that reads all the entries from a text
file instead of from the user.  Hint: look over TextFileExample.java in the Content area for how to read from a text
file.  Create a text file that has several lines of data where each line looks like

undergrad 98.1

grad 97.0

undergrad 89.5

etc.

Be sure you submit your text file with your program to earn the extra credit.  Note: You must still submit the original
program with no extra credit, then a second program with the extra credit.

Please submit your program in the Assignments area by midnight on Wednesday, July 7.  Upload your actual .java file, I
will compile and run it on my computer.  Be sure you have tested it first to make sure it compiles with no errors and
then runs and does what you expect.  You will not receive any credit for a program that does not compile.

Sample run:

Test 1:

Please enter the student type: 'undergrad', 'grad', or 'quit' to exit.

undergrad

Please enter this undergrad's GPA:

3.9

Please enter the student type: 'undergrad', 'grad', or 'quit' to exit.

grad

Please enter this grad's GPA:

3.8

Please enter the student type: 'undergrad', 'grad', or 'quit' to exit.

undergrad

Please enter this undergrad's GPA:

2.5

Please enter the student type: 'undergrad', 'grad', or 'quit' to exit.

giraffe

Invalid student type, please enter 'undergrad' for undergrad, 'grad' for grad, or 'quit' to exit.
Please enter the student type: 'undergrad', 'grad', or 'quit' to exit.

quit

The average GPA of all undergrad students is 3.80
The average GPA of all grad students is 3.20

---------

Test 2:

Please enter the student type: 'undergrad', 'grad', or 'quit' to exit.

quit

The average grade of all undergrad students is 0.00
The average grade of all grad students is 0.00

---------

Extra credit sample test data:

Test 1, text file contains:

undergrad 3.9

grad 3.8

undergrad 2.5

Output:

Reading data from text file grades.txt...

The average GPA of all undergrad students is 3.80
The average GPA of all grad students is 3.20

----------

Test 2:

(empty text file)

Output:

Reading data from text file grades.txt...

The average GPA of all undergrad students is 0.00
The average GPA of all grad students is 0.00
 */

package com.school;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Midterm1 {
	/*
	Instantiate initial values. Must be equal to zero and !null. Must also be static and in the same scope as the
	addToSum function
	*/
	static Integer gradCounter = 0;
	static Double gradTotalGpa = 0.0;
	static Integer undergradCounter = 0;
	static Double undergradTotalGpa = 0.0;

	public static void main(String[] args){
		/*
		Boolean that maintains the state of the program quitting if it's ever true
		 */
		Boolean quit = false;
		/*
		Instantiate Scanner object but as null because it'll either be a file reader or a user reader
		 */
		Scanner sc = null;
		/*
		Instantiate decimal formatter
		 */
		DecimalFormat df = new DecimalFormat("0.00");

		/*
		instantiate grade sums that will be printed later
		 */
		double gradGradeSum;
		double undergradGradeSum;
		/*
		Dictate the location of the text file grades can be read from
		 */
		File f = new File("src/grades.txt");
		/*
		If the file is found and not a directory, ask the user if they would like to read from the file
		 */
		if(f.exists() && !f.isDirectory()) {
			System.out.println("File found.");
			System.out.println("Would you like to read from grade file? Y/N");
			/*
			Temporarily set the scanner to System.in (CLI). If the user enters "Y", set scanner to file reader.
			Catch fileNotFoundException
			 */
			sc = new Scanner(System.in);
			/*
			Single line conditional, Y = true, allElse = false
			 */
			Boolean readFromFile = (sc.nextLine().equals("Y")? true : false);
			if(readFromFile){
				try{
					sc = new Scanner(f);
				} catch (FileNotFoundException fileNotFoundException) {
					fileNotFoundException.printStackTrace();
				}
				/*
				If the user does not want to read from file or doesn't exist, set scanner equal to the CLI
				 */
			} else {
				sc = new Scanner(System.in);
			}
		} else {
			sc = new Scanner(System.in);
		}
		/*
		Begin loop
		 */
		do{/*
			Ask user(or file) to enter input.
			 */
			System.out.println("Please enter the student type: 'undergrad', 'grad', or 'quit' to exit.");
			String usrInput = sc.nextLine();
			/*
			fix user input to be lowercase
			 */
			String fixedUserInput = usrInput.toLowerCase();
			/*
			if user input equals "qiuuuit"
			 */
		if(fixedUserInput.equals("quit")){
			double undergradAvg = undergradTotalGpa/undergradCounter;
			if(Double.isNaN(undergradAvg)){
				undergradAvg = 0.00;
			}
			System.out.printf("The average GPA of all undergrad students is %s\n", df.format(undergradAvg));
			double gradAvg = gradTotalGpa/gradCounter;
			if(Double.isNaN(gradAvg)) {
				gradAvg = 0.00;
			}
			System.out.printf("The average GPA of all grad students is %s\n", df.format(gradAvg));
			quit = true;
		} else if(fixedUserInput.equals("grad") || fixedUserInput.equals("undergrad")){
			System.out.printf("Please enter this %s's GPA:\n", fixedUserInput);
			double gpa = Double.valueOf(sc.nextLine());
			addToSum(fixedUserInput, gpa);
		} else {
			System.out.println("Invalid student type, please enter 'undergrad' for undergrad, 'grad' for grad, or 'quit' to exit.");
		}
		} while(!quit );
	}

	public static void addToSum(String gradOrUndergrad, Double gpa){
		switch(gradOrUndergrad){
			case "grad":
				gradTotalGpa = gradTotalGpa + gpa;
				gradCounter ++;
				break;
			case "undergrad":
				undergradTotalGpa = undergradTotalGpa + gpa;
				undergradCounter ++;
				break;
		}
	}
}
