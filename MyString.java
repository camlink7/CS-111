/*
 * Name: Camden Link
 * Assignment: Lab 7
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-02--27
 * Purpose: This file contains the updated MyString class that implements the Cloneable and Comparable interfaces as specified in Lab 7
 */
	
import java.lang.Comparable;
import java.lang.Cloneable;
import java.util.Arrays;

/*
 * Class Name: MyString
 * Purpose: The MyString class implementing Cloneable and Comparable interfaces as well as functions similar to Java's built-in String class, but is a custom implementation as required
 * for Lab 7
 * Exceptions: N/A
 */
public class MyString implements Cloneable, Comparable<MyString> {
	private char[] text;

	/*
	 * Method Name: MyString 
	 * Purpose: Constructs a new MyString object from a Java String 
	 * Parameters: 
	 * - original: The original Java String from which to keep the sequence of characters from 
	 * Preconditions: N/A 
	 * Postconditions: A new MyString object is created containing the character sequence found in the original String 
	 * Exceptions: N/A
	 */
	public MyString(String original) {
		this.text = original.toCharArray();
	}
	
	/*
	* Method Name: MyString 
	* Purpose: Constructs a new MyString object from a given array of chars 
	* Parameters: 
	* - original: The original array of chars from which to create the new object from 
	* Preconditions: N/A 
	* Postconditions: A new MyString object is created containing the character sequence found in the original char array 
	* Exceptions: N/A
	*/
	public MyString(char[] original) {
		this.text = Arrays.copyOf(original, original.length);
	}
	 
	/*
	 * Method Name: toString 
	 * Purpose: Creates a Java String from the character sequence in this MyString object 
	 * Parameters: N/A 
	 * Preconditions: N/A
	 * Postconditions: Returns a Java String with the character sequence stored in this MyString Object 
	 * Exceptions: N/A
	 */
	public String toString() {
		String output = "";
		for (int i = 0; i < text.length; i++) {
			output += text[i];
		}
		return output;
	}

	/*
	 * Method Name: getCharArray
	 * Purpose: Used as a getter to get a copy of the current internal character array representing the MyString
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns a char[] that is a COPY of the character sequence representing by the MyString object
	 * Exceptions: N/A
	 */
	public char[] getCharArray() { 
		return Arrays.copyOf(this.text, this.text.length);
	}
	
	/*
	 * Method Name: compareTo 
	 * Purpose: Compares this MyString object to another MyString object lexicographically to determine how they compare relative to each other 
	 * Parameters: 
	 * - anotherString: The other MyString object to compare this MyString object to 
	 * Preconditions: N/A 
	 * Postconditions: 
	 * - Returns 0 if the two MyStrings are equal
	 * - Returns number > 0 if this MyString 
	 * 		lexicographically comes BEFORE anotherString - Returns number < 0 if this MyString lexicographically comes AFTER anotherString 
	 * Exceptions: N/A
	 */
	public int compareTo(MyString anotherString) {
		char[] otherCharArray = anotherString.getCharArray();
		int minLength = Math.min(this.text.length, otherCharArray.length);

		// Check for a difference in characters based on the Character class numerical
		// comparison
		for (int i = 0; i < minLength; i++) {
			int compare = Character.compare(this.text[i], otherCharArray[i]);
			if (compare != 0) {
				return compare;
			}
		}

		// If all characters are the same until the min length is reached, return the
		// difference in length
		return this.text.length - otherCharArray.length;
	}
	
	/*
	 * Method Name: clone
	 * Purpose: Clones this MyString object and returns a new MyString object with the same character sequence (deep copy)
	 * Parameters: N/A 
	 * Preconditions: N/A
	 * Postconditions: Returns a new MyString object with the same internal data as this MyString. It creates a DEEP COPY
	 * Exceptions: N/A
	 */
	public MyString clone() {
		return new MyString(Arrays.copyOf(this.text, this.text.length));
	}
}