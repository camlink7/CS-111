/*
*Name: Camden Link
*Lab Assignment: Lab 2
*Date: 1/17/2022
*Purpose: This file's primary purpose is to contain he class "Refresher" which stores all of the methods needed for Lab #2
*/

package Lab2;

import java.util.Arrays;

/*
 * Class Name: Refresher
 * Purpose: Stores all the methods Lab 2 requires. Methods are simple implementations of "refresher" content from previous CS courses.
 * Exceptions: N/A
 */
public class Refresher {
	
	/*
	 * Method Name: swapHalves
	 * Purpose: Splits a given string in half and returns a new String with the halves swapped (second half followed by first half)
	 * Parameters:
	 * -line: Given string to be swapped
	 * Preconditions: N/A
	 * Postconditions: Returns a string with the halves of the original String swapped
	 * Exceptions: N/A
	 */
	public static String swapHalves(String line) {
		//Calculate the middle index
		int middleIndex = line.length() / 2;
		
		//If the length is odd, increment the middle index up by one to keep the extra character in the first half
		if (line.length() % 2 != 0) {
			middleIndex++;
		}
		return line.substring(middleIndex, line.length()) + line.substring(0, middleIndex);
	}

	/*
	 * Method Name: countVowels
	 * Purpose: Calculate the number of vowels in a given String
	 * Parameters:
	 * -line: Given string in which to calculate the number of vowels in
	 * Preconditions: N/A
	 * Postconditions: Returns the number of vowels in the given String
	 * Exceptions: N/A
	 */
	public static int countVowels(String line) {
		//Convert the string to lowercase to be perform a case-insensitive search
		String lowercaseLine = line.toLowerCase();
		final String VOWELS = "aeiou";
		int totalCount = 0;
		
		//Loop through the string, if VOWELS contains the character, it is a vowel therefore increment the total count.
		for (int i = 0; i < lowercaseLine.length(); i++) {
			if (VOWELS.indexOf(lowercaseLine.charAt(i)) != -1) {
				totalCount++;
			}
		}
		return totalCount;
	}
	
	/*
	 * Method Name: getMax
	 * Purpose: Finds the greatest (maximum) value in a given array of integers
	 * Parameters:
	 * -array: The given array to search for the max value in
	 * Preconditions: N/A
	 * Postconditions: Returns the greatest (maximum) value in the array
	 * Exceptions: N/A
	 */
	public static int getMax(int[] array) {
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}
		return maxValue;
	}

	/*
	 * Method Name: isPalindrome
	 * Purpose: Check if a given string is the same backwards as it is forwards
	 * Parameters:
	 * -line: The given string to check if it is a Palindrome
	 * Preconditions: Given string shouldn't contain whitespace
	 * Postconditions: 
	 * -Returns True -> String is a Palindrome
	 * -Returns False -> String is not a Palindrome
	 * Exceptions: N/A
	 */
	public static boolean isPalindrome(String line) {
		//Use the Java StringBuilder Object to avoid using a reverse for loop
		return (line.equals(new StringBuilder(line).reverse().toString()));
	}

	/*
	 * Method Name: factorial
	 * Purpose: Calculates the factorial value of a given integer
	 * Parameters:
	 * -n: The base integer given
	 * Preconditions: N/A
	 * Postconditions: Returns the factorial integer of the int given
	 * Exceptions: N/A
	 */
	public static int factorial(int n) {
		//Loop through n number of times and multiply the product each time
		int product = 1;
		for (int i = 1; i <= n; i++) {
			product *= i;
		}
		return product;
	}

	/*
	 * Method Name: getFibonacci
	 * Purpose: Calculates the Fibonacci sequence to the n-th number deep
	 * Parameters:
	 * -n: The depth of the Fibonacci sequence
	 * Preconditions: N/A
	 * Postconditions: Returns an array representing the Fibonacci sequence to the n-th number deep
	 * Exceptions: N/A
	 */
	public static int[] getFibonacci(int n) {
		//Create array the size of n with the first elem = 0, second elem = 1
		int[] array = {0, 1};
		array = Arrays.copyOf(array, n);
		
		//Move through the rest of the array setting the current index to the sum of the two previous indexes
		for (int i = 2; i < n; i++) {
			array[i] = array[i - 2] + array[i - 1];
		}
		return array;
	}

	
	/*
	 * Method Name: getC
	 * Purpose: Calculates the value of 'c' from the Pythogorean Theorem given side lengths 'a' and 'b'
	 * Parameters:
	 * -a: Side length 'a' value represented in the Pythogorean Theorem
	 * -b: Side length 'b' value represented in the Pythogorean Theorem
	 * Preconditions: N/A
	 * Postconditions: Returns the length of the hypotenuse, otherwise known as 'c' in the Pythogorean Theorem 
	 * Exceptions: N/A
	 */
	public static double getC(int a, int b) {
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}

	/*
	 * Method Name: getWeather
	 * Purpose: Determines a String describing the weather based on if its raining and the temperature in Fahrenheit
	 * Parameters:
	 * -rain: Boolean representing whether it is raining or not
	 * -temperature: The temperature in Fahrenheit
	 * Preconditions: N/A
	 * Postconditions: Will return...
	 * -"Snowy" if raining and <30 degrees
	 * -"Rainy" if raining and >=30 degrees
	 * -"Chilly" if not raining and <30 degrees
	 * -"Sunny" if not raining and >=30 degrees
	 * Exceptions: N/A
	 */
	public static String getWeather(boolean rain, int temperature) {
		if (rain && temperature < 30) { return "Snowy"; }
		else if (rain && temperature >= 30) { return "Rainy"; }
		else if (!rain && temperature < 30) { return "Chilly"; }
		else { return "Sunny"; }
	}

	/*
	 * Method Name: containsChar
	 * Purpose: Determines whether a specified char is in a given string
	 * Parameters:
	 * -line: The given string to search through
	 * -x: The specified char to look for in the string
	 * Preconditions: N/A
	 * Postconditions: Returns true if the char is found in the string, Returns false if the char is not found
	 * Exceptions: N/A
	 */
	public static boolean containsChar(String line, char x) {
		//If the indexOf 'x' is -1, its not in the String. Anything else, it must be in the String
		return line.indexOf(x) != -1;
	}

	/*
	 * Method Name: fillArray
	 * Purpose: Converts an existing 2D array to have all elements of odd rows = 0 and all elements of even rows = 1
	 * Parameters:
	 * -array: Existing 2D array to be converted
	 * Preconditions: N/A
	 * Postconditions: Returns a 2D array with odd row element's = 0 and even row element's = 1
	 * Exceptions: N/A
	 */
	public static int[][] fillArray(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				//Even row, set to 1
				if (row % 2 == 0) {
					array[row][col] = 1;
				}
				//Odd row, set to 0
				else {
					array[row][col] = 0;
				}
			}
		}
		return array;
	}

	/*
	 * Method Name: printOdd
	 * Purpose: Print out (using System.out.print()) all odd integers in a given array of integers 
	 * Parameters:
	 * -array: Array of integers in which odd integers will be printed from
	 * Preconditions: N/A
	 * Postconditions: Does not return anything. Prints out odd integers using System.out.print()
	 * Exceptions: N/A
	 */
	public static void printOdd(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) { System.out.print(array[i]); }
		}
	}

	/*
	 * Method Name: reverseString
	 * Purpose: To reverse a given string so that it is "backwards"
	 * Parameters:
	 * -line: The given String to be reversed
	 * Preconditions: N/A
	 * Postconditions: Returns a new String that is a reversed version of the given String
	 * Exceptions: N/A
	 */
	public static String reverseString(String line) {
		//Use Java's built-in StringBuilder to avoid using a reverse for loop
		return new StringBuilder(line).reverse().toString();
	}
	
	/*
	 * Method Name: swap
	 * Purpose: To swap two existing values in a given array
	 * Parameters:
	 * -array: The array containing the two values
	 * Preconditions: The array's length must be great enough to contain both given indexes to be swapped
	 * Postconditions: Returns the modified array with the values at the given indexes swapped
	 * Exceptions: N/A
	 */
	public static int[] swap(int[] array, int index1, int index2) {
		//Store the first index value in a temp variable so its not lost when replaced
		int temp = array[index1];
		
		array[index1] = array[index2];
		array[index2] = temp;
		return array;
	}

	/*
	 * Method Name: reverseInt
	 * Purpose: Reverses the order of digits in a given base-10 integer
	 * Parameters:
	 * -number: The integer given to have its digits reversed
	 * Preconditions: number must be a base-10 integer
	 * Postconditions: Returns a integer representing the reversed version of the given number
	 * Exceptions: N/A
	 */
	public static int reverseInt(int number) {
		//To avoid overcomplicated Mathematical calculations, convert number to a String, reverse the order,
		//and then convert it back to an Integer
		return Integer.valueOf(new StringBuilder(Integer.toString(number)).reverse().toString());
	}
	
	/*
	 * Method Name: rotateArray
	 * Purpose: Shifts all elements up an index in the array with the last index moving to the front of the new Array; 
	 * 			Otherwise known as "rotating" the array
	 * Parameters:
	 * -array: The given array to be "rotated"
	 * Preconditions: The given array must have a length of at least 2
	 * Postconditions: Returns a new array with each element shifted up an index and the last element moving to the front
	 * Exceptions: N/A
	 */
	public static int[] rotateArray(int[] array) {	
		//Move backwards through the array swapping each value to result in a shift of each element up
		//while moving the last element to the front of the array
		for (int i = array.length - 1; i > 0; i--) {
			int temp = array[i];
			array[i] = array[i - 1];
			array[i - 1] = temp;
		}
		return array;
	}
}