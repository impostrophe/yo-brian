import java.util.Scanner;

public class GCD {

	static Scanner in = new Scanner(System.in);
	
	
	//method to find the greatest common divisor of two ints
	public static int gcd(int a, int b) {
		if((a % b) != 0) {
			return gcd(b, a%b);
		} else {
			return b;
		}
	}

	//method to retrieve and validate an int input from a user
	static int inputInt() {
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
	
	public static void main(String[] args) {
		
		//variables to track and manipulate inputs
		int firstInt;
		int secondInt;
		int lower;
		int higher;
		int gcd;

		System.out.println("Enter two integers to find their greatest common divisor.");
		System.out.println();
		System.out.println("first int: ");
		firstInt = inputInt();
		System.out.println("second int: ");
		secondInt = inputInt();
		
		//order the inputs from lower to higher
		lower = Math.min(firstInt, secondInt);
		higher = Math.max(firstInt, secondInt);

		//find the greatest common divisor
		gcd = gcd(lower, higher);

		//print results to user
		System.out.println();
		System.out.print("Number 1: " + lower + "\t");
		System.out.print("Number 2: " + higher + "\t");
		System.out.print("GCD: " + gcd);
		
	}//end main method
	
}//end GCD class
