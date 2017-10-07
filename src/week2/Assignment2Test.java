package week2;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment2Test {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		// variables for number of employees and days worked
		int employees = 0;
		int days = 0;
		
		// variable to track total hours worked for each employee
		int total = 0; 

		// variable for input validation
		boolean isInt;

		// gets user input for the number of employees
		do {			
			System.out.println("how many employees?");
			if(in.hasNextInt()) {
				employees = in.nextInt();
				isInt = true;
			} else {
				System.out.println("not an int");
				isInt = false;
				in.next();
			}
		} while(!(isInt));
		
		//gets user input for the number of days in work week
		do {			
			System.out.println("how many days?");
			if(in.hasNextInt()) {
				days = in.nextInt();
				isInt = true;
			} else {
				System.out.println("not an int");
				isInt = false;
				in.next();
			}
		} while(!(isInt));
		
		// array to store daily hours worked for each employee 
		int empHours[][] = new int[employees][days];
		
		// arrays to track names and hours worked for each employee
		String names[] = new String[employees];
		int totals[] = new int[employees];
		
		// for loop to build empHours array
		for(int row = 0; row < employees; row ++) {
				System.out.println("enter a name");
				names[row] = in.next(); // values for the names array
			
			// gets user input for employee hours worked each day
			for(int col = 0; col < days; col++) {
				do {			
					System.out.println("enter day's hours");
					if(in.hasNextInt()) {
						empHours[row][col] = in.nextInt(); // values for the daily hours  worked of empHours array
						isInt = true;
						total+= empHours[row][col];
					} else {
						System.out.println("not an int");
						isInt = false;
						in.next();
					}
				} while(!(isInt));
			}
			totals[row] = total; // values for the totals array
			total = 0;
		} // end of for empHours for loop
		
		// create a copy of totals array and names array
		int[] sortedTotals = Arrays.copyOf(totals, employees);
		String[] sortedNames = Arrays.copyOf(names, employees);

		// call sortArrays on copies of arrays to put them in descending order of hours worked
		sortArrays(sortedTotals, sortedNames);
		
		// print results
		System.out.println();
		for(int i = totals.length-1; i>=0;i--) {
			System.out.println(sortedNames[i] + " worked " + sortedTotals[i] + " hours");
		}

		in.close();
		
	} // end of main method
	

	// method to put arrays in descending order based on total hours worked
	public static void sortArrays(int[] hourArray, String[] nameArray) {				
		int tempHours;
		String tempName;
		for(int i = 1; i < hourArray.length; i++) {
			for(int j = i; j > 0; j--) {
				if(hourArray[j] < hourArray[j-1]) {
					tempHours = hourArray[j];
					tempName = nameArray[j];
					hourArray[j] = hourArray[j-1];
					hourArray[j-1] = tempHours;
					nameArray[j] = nameArray[j-1];
					nameArray[j-1] = tempName;
				}
				
			}
		}		
	}	
	
} // end of Assignment2 class
