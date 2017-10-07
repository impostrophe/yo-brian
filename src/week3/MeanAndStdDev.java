package week3;
import java.util.Scanner;

public class MeanAndStdDev {
	
	public static void main(String[] args) {
				
		// variables to handle user input and calculations
		int size;
		double[] realNumbers;
		double mean = 0;
		double stdDev = 0;		
		
		// get user input to determine size of array
		System.out.println("how many real numbers would you like to enter?");
		size = getInt();
		realNumbers = new double[size];
		
		// get user input to fill array
		System.out.println("enter real numbers");
		buildArray(realNumbers, size);
		
		// calculate mean and standard deviation through function calls
		mean = findMean(realNumbers);		
		stdDev = findStdDev(realNumbers, mean);
		
		// print results to user
		System.out.println();
		System.out.println("the mean is " + mean);
		System.out.println("the standard deviation is " + stdDev);
						
	} // end of main method
	
	static Scanner in = new Scanner(System.in);

	// method to get a double from the user with input validation
	static double getDouble() {
		double result = 0;
		boolean isDouble = false;
		do {
			if(in.hasNextDouble()) {
				result = in.nextDouble();
				isDouble = true;
			} else {
				System.out.println("not a real number");
				in.next();
			}
		} while(!(isDouble));
		return result;
	}
	
	// method to get an int from the user with input validation
	static int getInt() {
		int result = 0;
		boolean isInt = false;
		do {
			if(in.hasNextInt()) {
				result = in.nextInt();
				isInt = true;
			} else {
				System.out.println("not an int");
				in.next();
			}
		} while(!(isInt));
		return result;
	}

	// method to build the array from user input
	static void buildArray(double[] anArray, int arraySize) {
		for(int nums = 0; nums < arraySize; nums++) {
			anArray[nums] = getDouble();
		}
	}

	// method to calculate the mean of an array
	static double findMean(double[] anArray) {
		double sum = 0;
		for(int i = 0; i < anArray.length; i++) {
			sum += anArray[i];			
		}
		return sum / anArray.length;
	}

	// method to find the standard deviation of an array
	static double findStdDev(double[] anArray, double aMean) {
		double sum = 0;
		for(int i = 0; i < anArray.length; i++) {
			sum += Math.pow(aMean - anArray[i], 2);
		}
		sum = sum / (anArray.length - 1);
		sum = Math.sqrt(sum);
		return sum;
	}
	
} // end of MeanandStdDev class