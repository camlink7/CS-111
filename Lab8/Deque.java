/*
 * Name: Camden Link
 * Assignment: Lab 8
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-03-06
 * Purpose: This file contains the Deque class as required by Lab 8
 */

import java.util.NoSuchElementException;
import java.util.Arrays;

/*
 * Class Name: Deque
 * Purpose: This class takes a generic object type and is a mix between the functionality of a Queue and a Stack. Essentially, it is a Queue that can be added and removed to
 *		from both sides. It is known as a Double Ended Queue, or Deque
 * Exceptions:
 * - NoSuchElementException: Thrown when a method that modifies the Deque is called, but the Deque is empty and contains no elements
 */
public class Deque<E> {
	private E[] array;
	
	/*
	 * Method Name: Deque
	 * Purpose: Constructor for creating a new Deque. Initializes a new Deque object with 0 objects in it
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Constructs a new Deque object with no elements
	 * Exceptions: N/A
	 */
	public Deque() {
		this.array = (E[]) new Object[0];
	}

	/*
	 * Method Name: addFirst
	 * Purpose: To add a generic object type to the beginning of the Deque, shifting all other elements up one index
	 * Parameters:
	 * - e: The generic object type that will be added to the beginning of the Deque
	 * Preconditions: N/A
	 * Postconditions: The given generic object type is added to the beginning of the Deque, shifting any existing elements up on index
	 * Exceptions: N/A
	 */
	public void addFirst(E e) {
		this.shiftUp();
		this.array[0] = e;
	}

	/*
	 * Method Name: removeFirst
	 * Purpose: To remove the generic object at the beginning of the Deque
	 * Parameters: N/A
	 * Preconditions: The Deque must not be empty
	 * Postconditions: Modifies the Deque and removes the generic object at the beginning, inherently shifting all other elements down an index. It also returns the object that was removed
	 * Exceptions:
	 * - NoSuchElementException: Thrown when the method is called, but the Deque is empty
	 */
	public E removeFirst() {
		if (!this.isEmpty()) {
			E first = this.array[0];
			this.array = Arrays.copyOfRange(this.array, 1, this.size());
			return first;
		}
		else {
			throw new NoSuchElementException("Deque is empty!");
		}
	}

	/*
	 * Method Name: getFirst
	 * Purpose: To get the generic object currently at the beginning of the Deque
	 * Parameters: None
	 * Precondition: The Deque must not be empty
	 * Postconditions: Returns the generic object that is at the beginning of the array. It does NOT modify the Deque in any way.
	 * Exceptions:
	 * - NoSuchElementException: Thrown if this method is called when the Deque is empty
	 */
	public E getFirst() {
		if (!this.isEmpty()) {
			return this.array[0];
		}
		else {
			throw new NoSuchElementException("Deque is empty!");
		}
	}

	/*
	 * Method Name: addLast
	 * Purpose: To add a generic object to the end of the Deque
	 * Parameters: 
	 * - e: The generic object that will be added to the end of the Deque
	 * Precondition: N/A
	 * Postconditions: The given object is added to the end of the Deque, modifying this Deque object
	 * Exceptions: N/A
	 */
	public void addLast(E e) {
		this.array = Arrays.copyOf(this.array, this.size() + 1);
		this.array[this.size()] = e;
	}

	/*
	 * Method Name: removeLast
	 * Purpose: To remove the generic object at the end of the Deque
	 * Parameters: N/A
	 * Precondition: The Deque must not be empty
	 * Postconditions: Removes the object at the end of the Deque and returns a generic object representing the element that was removed
	 * Exceptions:
	 * - NoSuchElementException: Thrown if this method is called when the Deque is empty
	 */
	public E removeLast() {
		if (!this.isEmpty()) {
			E last = this.array[this.size() - 1];
			this.array = Arrays.copyOf(this.array, this.size() - 1);
			return last;
		}
		else {
			throw new NoSuchElementException("Deque is empty!");
		}
	}

	/*
	 * Method Name: getLast
	 * Purpose: To get the generic object currently at the end of the Deque
	 * Parameters: N/A
	 * Precondition: The Deque must not be empty
	 * Postconditions: Returns the generic object that is at the end of the Deque. Does NOT modify this Deque object in any way.
	 * Exceptions:
	 * - NoSuchElementException: Thrown if this method is called when the Deque is empty
	 */
	public E getLast() {
		if (!this.isEmpty()) {
			return this.array[this.size() - 1];
		}
		else {
			throw new NoSuchElementException("Deque is empty!");
		}
	}

	/*
	 * Method Name: size
	 * Purpose: To get the current size of the Deque (the current number of objects it is holding)
	 * Parameters: N/A
	 * Precondition: N/A
	 * Postconditions: Returns the number of objects currently stored in the Deque
	 * Exceptions: N/A
	 */
	public int size() {
		int currentSize = 0;
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] != null) {
				currentSize++;
			}
		}
		return currentSize;
	}
	
	/*
	 * Method Name: isEmpty
	 * Purpose: To check if the Deque is empty
	 * Parameters: N/A
	 * Precondition: N/A
	 * Postconditions: Returns true if the Deque has no objects stored currently, returns false if there is one or more objects currently stored in the Deque
	 * Exceptions: N/A
	 */
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	/*
	 * Method Name: shiftUp
	 * Purpose: To shift all of the existing objects in the Deque up by one index, leaving the element at index 0 to be empty, or null
	 * Parameters: N/A
	 * Precondition: This method will do nothing if this Deque is empty
	 * Postconditions: Shifts all the existing objects in the Deque up by one index, making the beginning element empty, or null. Directly modifies this Deque object
	 * Exceptions: N/A
	 */
	private void shiftUp() {
		E[] temp = Arrays.copyOf(this.array, this.size() + 1);
		for (int i = this.size() - 1; i >= 0; i--) {
			temp[i + 1] = this.array[i];
		}
		this.array = temp;
	}
}