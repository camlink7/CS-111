package Lab4;
/*
 * Name: Camden Link
 * Assignment: Lab 4
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-01-30
 * Purpose: This file contains the implementation of IntArray required for Lab 4. That is the only purpose of the file
 */

import java.util.Arrays;
import java.lang.ArrayIndexOutOfBoundsException;

/*
 * Class Name: IntArray
 * Purpose: The class behaves similar to an Array and only stores integers, but with the ability to use 
 * arbitrary index values. The IntArray becomes "Extensible" similar to an ArrayList.
 * Exceptions: N/A
 */
public class IntArray {
	private int[] array;
	
	/*
	 * Method Name: IntArray
	 * Purpose: Default constructor for class, constructs a new IntArray object
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: A new IntArray object is created with the length of 0
	 * Exceptions: N/A
	 */
	public IntArray() {
		this.array = new int[0];
	}

	/*
	 * Method Name: IntArray
	 * Purpose: Constructs a new IntArray object given a existing array of integers
	 * Parameters: 
	 * - array: Given array of integers to be copied into the IntArray object
	 * Preconditions: N/A
	 * Postconditions: New IntArray object created with the given integer array values
	 * Exceptions: N/A
	 */
	public IntArray(int[] array) {
		this.array = Arrays.copyOf(array, array.length);
	}

	/*
	 * Method Name: getValue
	 * Purpose: Gets the value at a specific index in the object. If the index is greater than the array length,
	 * the array size is expanded and padded with zeros.
	 * Parameters: 
	 * - index: The requested array index to get
	 * Preconditions: index should be >= 0
	 * Postconditions: Returns an integer representing the value at the requested index. If the array was expanded, it returns 0
	 * Exceptions: 
	 * - ArrayIndexOutOfBoundsException: Returned if an index < 0 is given
	 */
	public int getValue(int index) {
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException("IntArray index cannot be negative, must be greater than or equal to 0!");
		}
		else if (index >= 0 && index < this.array.length) {
			return this.array[index];
		}
		else {
			this.array = Arrays.copyOf(this.array, index + 1);
			return 0;
		}
	}

	/*
	 * Method Name: setValue
	 * Purpose: Sets the value at a given index in the IntArray. If the index is greater than the existing array size, 
	 * the array is "expanded" to hold the new value
	 * Parameters: 
	 * - index: The array index at which to set the new value at
	 * - value: The given integer value to store at the specified index
	 * Preconditions: index should be >= 0
	 * Postconditions: Stores the given value at the specified index in the object. Nothing is returned
	 * Exceptions: 
	 * - ArrayIndexOutOfBoundsException: Returned if an index < 0 is given
	 */
	public void setValue(int index, int value) {
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException("IntArray index cannot be negative, must be greater than or equal to 0!");
		}
		else if (index >= 0 && index < this.array.length) {
			this.array[index] = value;
		}
		else {
			this.array = Arrays.copyOf(this.array, index + 1);
			this.array[index] = value;
		}
	}
	
	/*
	 * Method Name: length
	 * Purpose: Gets the current allocated size of the object
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the current allocated size of the object
	 * Exceptions: N/A
	 */
	public int length() {
		return this.array.length;
	}

	/*
	 * Method Name: asArray
	 * Purpose: Gets the current object as a primitive integer array. DOES NOT modify the existing IntArray object
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns a new integer array representing the values stored in the current IntArray object 
	 * Exceptions: N/A
	 */
	public int[] asArray() {
		return Arrays.copyOf(this.array, this.array.length);
	}

	/*
	 * Method Name: equals
	 * Purpose: Compares the object to another IntArray object checking for perfect equality in the values stored,
	 * not Object in memory equality
	 * Parameters: 
	 * - that: other IntArray object to check for equality with
	 * Preconditions: N/A
	 * Postconditions: 
	 * - Returns true if the values are the same as the other IntArray object
	 * - Returns false if the values are NOT the same as the other IntArray object
	 * Exceptions: N/A
	 */
	public boolean equals(IntArray that) {
		return Arrays.equals(this.array, that.asArray());
	}
}