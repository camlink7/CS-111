/*
 * Name: Camden Link
 * Assignment: Program 1
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-02-06
 * Purpose: This file contains the MyString class, a custom implementation that is similar to Java's String class
 */
package Program1;

import java.lang.*;
import java.util.Arrays;

/*
 * Class Name: MyString
 * Purpose: The MyString class functions similar to Java's built-in String class, but is a custom implementation as required
 * for Program 1 Assignment
 * Exceptions: N/A
 */
public class MyString {
	private char[] text;

	/*
	 * Method Name: MyString Purpose: Constructs a new MyString object from a Java
	 * String Parameters: - original: The original Java String from which to keep
	 * the sequence of characters from Preconditions: N/A Postconditions: A new
	 * MyString object is created containing the character sequence found in the
	 * original String Exceptions: N/A
	 */
	public MyString(String original) {
		this.text = original.toCharArray();
	}

	/*
	 * Method Name: MyString Purpose: Constructs a new MyString object from a given
	 * array of chars Parameters: - original: The original array of chars from which
	 * to create the new object from Preconditions: N/A Postconditions: A new
	 * MyString object is created containing the character sequence found in the
	 * original char array Exceptions: N/A
	 */
	public MyString(char[] original) {
		this.text = new char[original.length];
		for (int i = 0; i < original.length; i++) {
			this.text[i] = original[i];
		}
	}

	/*
	 * Method Name: MyString Purpose: Constructs a new MyString object from another
	 * MyString object (copy constructor) Parameters: - original: The original
	 * MyString object Preconditions: N/A Postconditions: A new MyString object is
	 * created containing the character sequence found in the original MyString
	 * object Exceptions: N/A
	 */
	public MyString(MyString original) {
		char[] originalCharSequence = original.toString().toCharArray();
		this.text = Arrays.copyOf(originalCharSequence, originalCharSequence.length);
	}

	/*
	 * Method Name: length Purpose: Gets the current size of the object Parameters:
	 * N/A Preconditions: N/A Postconditions: Returns the current size of the char
	 * sequence in the object Exceptions: N/A
	 */
	public int length() {
		return this.text.length;
	}

	/*
	 * Method Name: charAt Purpose: Gets the character at a specified index in the
	 * object Parameters: - index: The index to get the character at Preconditions:
	 * index must be a valid index Postconditions: Returns the character at a
	 * specified index in the object Exceptions: - IndexOutOfBoundsException: Thrown
	 * when the index given does not exist. This occurs if index < 0 || index >= the
	 * length of the MyString object
	 */
	public char charAt(int index) {
		if (index >= 0 && index < text.length) {
			return this.text[index];
		}
		throw new IndexOutOfBoundsException("Given index does not exist!");
	}

	/*
	 * Method Name: concat Purpose: Combines the current MyString with another
	 * MyString object creating a single MyString object Parameters: - otherString:
	 * The other MyString object which will be concatenated to the end of this
	 * MyString object Preconditions: N/A Postconditions: Returns a new MyString
	 * object with the original char sequence followed by the otherString char
	 * sequence Exceptions: N/A
	 */
	public MyString concat(MyString otherString) {
		return new MyString(this.toString() + otherString.toString());
	}

	/*
	 * Method Name: indexOf Purpose: Gets the index of the first occurrence of a
	 * specified character in this MyString object by searching the ALL chars
	 * Parameters: - ch: The character to search the MyString for Preconditions: N/A
	 * Postconditions: Returns the index of the specified character stored in this
	 * MyString object. If the character is not found, -1 is returned Exceptions:
	 * N/A
	 */
	public int indexOf(char ch) {
		for (int i = 0; i < this.text.length; i++) {
			if (this.text[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * Method Name: indexOf Purpose: Gets the index of the first occurrence of a
	 * specified character in this MyString object by starting a search ONLY at the
	 * fromIndex parameter Parameters: - ch: The character to search MyString for -
	 * fromIndex: The index to begin the search at Preconditions: N/A
	 * Postconditions: Returns the index of the specified character stored in this
	 * MyString object starting a search at the fromIndex param. If the character is
	 * not found, -1 is returned Exceptions: N/A
	 */
	public int indexOf(char ch, int fromIndex) {
		for (int i = fromIndex; i < this.text.length; i++) {
			if (this.text[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * Method Name: replace Purpose: Replaces all occurrences of the target
	 * character with a replacement character in the object Parameters: - target:
	 * The character that should be replaced - replacement: The character to replace
	 * the target chars with Preconditions: N/A Postconditions: Returns a new
	 * MyString object in which all occurrences of target are replaced with
	 * replacement Exceptions: N/A
	 */
	public MyString replace(char target, char replacement) {
		char[] newCharArray = this.text.clone();
		for (int i = 0; i < newCharArray.length; i++) {
			if (newCharArray[i] == target) {
				newCharArray[i] = replacement;
			}
		}
		return new MyString(newCharArray);
	}

	/*
	 * Method Name: substring Purpose: Gets a 'piece' of the MyString object, or a
	 * substring beginning at a given beginIndex until the end of the MyString
	 * Parameters: - beginIndex: The index at which to start the partial character
	 * sequence at Preconditions: N/A Postconditions: Returns a new MyString object
	 * that is a portion of the original MyString starting at the given beginIndex
	 * Exceptions: - IndexOutOfBoundsException: Thrown if the given index is not
	 * valid (index < 0 || index >= length of this MyString)
	 */
	public MyString substring(int beginIndex) {
		char[] substring = new char[this.text.length - beginIndex];
		int substringCount = 0;

		if (beginIndex >= 0 && beginIndex < this.text.length) {
			for (int i = beginIndex; i < this.text.length; i++) {
				substring[substringCount] = this.text[i];
				substringCount++;
			}
			return new MyString(substring);
		}
		throw new IndexOutOfBoundsException("Given index does not exist!");
	}

	/*
	 * Method Name: substring Purpose: Gets a 'piece' of the MyString object, or a
	 * substring starting at the beginIndex until the endIndex given Parameters: -
	 * beginIndex: The index at which to start the partial character sequence at
	 * (inclusive) - endIndex: The index at which to end the partial character
	 * sequence exclusively (endIndex - 1) Preconditions: N/A Postconditions:
	 * Returns a new MyString object that is a substring from beginIndex to endIndex
	 * of the original MyString Exceptions: - IndexOutOfBoundsException: Thrown if
	 * the given indexes are not valid (index < 0 || index >= length of this
	 * MyString)
	 */
	public MyString substring(int beginIndex, int endIndex) {
		char[] substring = new char[endIndex - beginIndex];
		int substringCount = 0;

		if (beginIndex >= 0 && beginIndex < this.text.length && endIndex < this.text.length) {
			for (int i = beginIndex; i < endIndex; i++) {
				substring[substringCount] = this.text[i];
				substringCount++;
			}
			return new MyString(substring);
		}
		throw new IndexOutOfBoundsException("Given index does not exist!");
	}

	/*
	 * Method Name: toUpperCase Purpose: Converts all the characters in the MyString
	 * to upper case Parameters: N/A Preconditions: N/A Postconditions: Returns a
	 * new MyString object with the same chars at this MyString, but all upper case
	 * Exceptions: N/A
	 */
	public MyString toUpperCase() {
		char[] chars = Arrays.copyOf(this.text, this.text.length);
		for (int i = 0; i < chars.length; i++) {
			chars[i] = Character.toUpperCase(chars[i]);
		}
		return new MyString(chars);
	}

	/*
	 * Method Name: toLowerCase Purpose: Converts all the characters in the MyString
	 * to lower case Parameters: N/A Preconditions: N/A Postconditions: Returns a
	 * new MyString object with the same chars at this MyString, but all lower case
	 * Exceptions: N/A
	 */
	public MyString toLowerCase() {
		char[] chars = Arrays.copyOf(this.text, this.text.length);
		for (int i = 0; i < chars.length; i++) {
			chars[i] = Character.toLowerCase(chars[i]);
		}
		return new MyString(chars);
	}

	/*
	 * Method Name: toString Purpose: Creates a Java String from the character
	 * sequence in this MyString object Parameters: N/A Preconditions: N/A
	 * Postconditions: Returns a Java String with the character sequence stored in
	 * this MyString Object Exceptions: N/A
	 */
	public String toString() {
		String output = "";
		for (int i = 0; i < text.length; i++) {
			output += text[i];
		}
		return output;
	}

	/*
	 * Method Name: equals Purpose: Checks for perfect equality in the character
	 * sequence of this MyString object compared to another MyString object
	 * Parameters: N/A Preconditions: N/A Postconditions: - Returns true if the two
	 * MyStrings are equal in terms of the same character sequence - Returns false
	 * if they do NOT have the same character sequence Exceptions: N/A
	 */
	public boolean equals(MyString other) {
		// If the 'other' object is null, return false
		if (other == null) {
			return false;
		}

		char[] otherCharArray = other.toString().toCharArray();
		// If both objects have the same number of characters
		if (this.text.length == otherCharArray.length) {
			for (int i = 0; i < this.text.length; i++) {
				if (this.text[i] != otherCharArray[i]) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	/*
	 * Method Name: compareTo Purpose: Compares this MyString object to another
	 * MyString object lexicographically to determine how they compare relative to
	 * each other Parameters: - anotherString: The other MyString object to compare
	 * this MyString object to Preconditions: N/A Postconditions: - Returns 0 if the
	 * two MyStrings are equal - Returns number > 0 if this MyString
	 * lexicographically comes BEFORE anotherString - Returns number < 0 if this
	 * MyString lexicographically comes AFTER anotherString Exceptions: N/A
	 */
	public int compareTo(MyString anotherString) {
		char[] otherCharArray = anotherString.toString().toCharArray();
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
}