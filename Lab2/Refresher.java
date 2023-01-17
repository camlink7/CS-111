/*
*Name: Camden Link
*Lab Assignment: Lab 2
*Date: 1/17/2022
*Purpose: This file's primary purpose is to contain he class "Refresher" which stores all of the methods needed for Lab #2
*/

package Lab2;

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
	 * Purpose: Check if a given string is the read the same backwards as it is forwards
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

	public static int[] getFibonacci(int n) {
		return new int[n];
	}

	public static double getC(int a, int b) {
		return 0.0;
	}

	public static String getWeather(boolean rain, int temperature) {
		return "";
	}

	public static boolean containsChar(String line, char x) {
		return false;
	}

	public static int[][] fillArray(int[][] array) {
		return array;
	}

	public static void printOdd(int[] array) {
	}

	public static String reverseString(String line) {
		return "";
	}

	public static int[] swap(int[] array, int index1, int index2) {
		return array;
	}

	public static int reverseInt(int number) {
		return 0;
	}

	public static int[] rotateArray(int[] array) {
		return array;
	}
}