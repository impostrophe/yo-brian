/** 
 * PalindromicPrimes prints up to the first 100 palindromic prime numbers by making
 *  sure a number passes both conditions and printing if so and then incrementing either way
 *  
 *  @author Ryan Schumacher
 *  class: Ser215
 */

import java.util.Scanner;

public class Java_Test {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
				
		System.out.println("Enter an int (max 100) ");
		int input = in.nextInt();
		
		// variables for while loop
		int count = 0;
		int lineSize = 0;
		int current = 2;
		
		// while loop checking integers beginning with 2 until a formatted list of
		// palindromic prime numbers of length equal to input is generated
		while(count<input) {
			if(lineSize == 10) {
				System.out.println();
				lineSize = 0;
			}
			if(primeCheck(current) && palindromeCheck(current)) {
				System.out.print(current + "\t");
				lineSize++;
				count++;
			}
			current++;
		}
	}
	
	// check if a number is a prime number using the modulus in a loop
	public static boolean primeCheck(int number) {
		for(int i=2; i<number; i++) {
			if(number % i == 0) { // is the number divisible by 0>i<number ?
				return false;
			}
		}
		return true;
	}
	
	// check if a number is a palindrome by reversing it and checking for equivalence
	public static boolean palindromeCheck(int number) {
		int temp = number;
		int end = 0;
		int result = 0;
		
		while(temp > 0) {
			end = temp % 10; // find the last digit (remainder)
			result = result*10 + end; // add a zero to the end of the result to be replaced by remainder
			temp = temp / 10; // drop the last digit with integer division and repeat if not 0
		}
	
		return number==result;
	}	
}