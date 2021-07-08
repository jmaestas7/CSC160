package com.school;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class randomFileGenerator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many grades you want to create");
		Integer usrInput = sc.nextInt();
		Integer counter = 1;
		DecimalFormat df = new DecimalFormat("0.00");

		FileWriter fw = null;
		String filename= "src/grades.txt";
		try {
			fw = new FileWriter(filename,true); //the true will append the new data
			do{
				if (Math.ceil(Math.random() * 2) == 1) {
					fw.write("grad\n");
				} else {
					fw.write("undergrad\n");
				}
				fw.write(df.format((Math.random() * 3.5) + 1)+"\n");
				counter ++;
			} while(counter <  usrInput);
			fw.write("quit");
			fw.close();
			sc.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
