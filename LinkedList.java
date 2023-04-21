/*
 * Name: Camden Link
 * Assignment: Bonus Lab
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-04-21	
 * Purpose: This file contains the LinkedList class that allows for arbitrary inserting as outlined in the Bonus Lab assignment
 */

import java.lang.IndexOutOfBoundsException;

/*
 * Class Name: LinkedList
 * Purpose: This class works like a normal linked list in which each value is linked to one another doubly, however this class also allows for the
 * 	insertion of values at random indexes
 * Exceptions:
 * - IndexOutOfBoundsException: Thrown if values that do not exist are attempted to be accessed or removed
 */
public class LinkedList<E> {
	private Node<E> head;
	private int currentSize;
	
	/*
	 * Method Name: LinkedList
	 * Purpose: Constructs a new LinkedList object
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Constructs a new LinkedList object with no values stored 
	 * Exceptions: N/A
	 */
	public LinkedList() {
		this.head = null;
		this.currentSize = 0;
	}

	/*
	 * Method Name: insertBefore
	 * Purpose: Inserts a value into the list before a given index
	 * Parameters: 
	 * - index: The index to insert the value before
	 * - value: The data value to be inserted
	 * Preconditions: N/A
	 * Postconditions: The value is inserted into the list just before the given index
	 * Exceptions:
	 * - IndexOutOfBoundsException: Thrown if the given index is less than 0 or greater than or equal to the current size of the list
	 */
	public void insertBefore(int index, E value) {
		if ((index >= this.currentSize || index < 0) && index != 0) { throw new IndexOutOfBoundsException("Index out of range!"); }
		
		Node<E> newNode = new Node<E>(value);
		//Insert at the very beginning
		if (index == 0) {
			if (this.size() >= 1) {
				newNode.next = this.head;
				this.head.prev = newNode;
				this.head = newNode;
			}
			else {
				this.head = newNode;
			}
		}
		
		//Inserting in the middle of the list
		else {
			Node<E> beforeNode = findNode(index);
			newNode.next = beforeNode;
			newNode.prev = beforeNode.prev;
			beforeNode.prev.next = newNode;
			beforeNode.prev = newNode;
		}
		
		this.currentSize++;
	}

	/*
	 * Method Name: insertAfter
	 * Purpose: Inserts a value into the list after the given index
	 * Parameters: 
	 * - index: The index to insert the value after
	 * - value: The data value to be inserted
	 * Preconditions: N/A
	 * Postconditions: The value is inserted into the list just after the given index
	 * Exceptions:
	 * - IndexOutOfBoundsException: Thrown if the given index is less than 0 or greater than or equal to the current size of the list
	 */
	public void insertAfter(int index, E value) {
		if ((index >= this.currentSize || index < 0) && index != 0) { throw new IndexOutOfBoundsException("Index out of range!"); }
		
		Node<E> newNode = new Node<E>(value);
		if (index == 0) {
			if (this.size() > 1) {
				newNode.next = this.head.next;
				newNode.prev = this.head;
				this.head.next.prev = newNode;
				this.head.next = newNode;
			}
			else if (this.size() == 1) {
				this.head.next = newNode;
				newNode.prev = this.head;
			}
			else {
				this.head = newNode;
			}
		}
		else {
			Node<E> targetNode = this.findNode(index);
			if (targetNode.next != null) {
				newNode.next = targetNode.next;
				targetNode.next.prev = newNode;
			}
			targetNode.next = newNode;
			newNode.prev = targetNode;
		}
		
		this.currentSize++;
	}
	
	/*
	 * Method Name: remove
	 * Purpose: Removes the value at a specified index from the list
	 * Parameters: 
	 * - index: The index to remove the value from
	 * Preconditions: N/A
	 * Postconditions: The value at the given index is removed from the list and returned
	 * Exceptions:
	 * - IndexOutOfBoundsException: Thrown if the given index is less than 0 or greater than or equal to the current size of the list
	 */
	public E remove(int index) {
		E removed = null;
		if (index < this.currentSize && index >= 0) {
			if (index == 0) {
				removed = this.head.item;
				if (this.head.next != null) {
					this.head = this.head.next;
				}
				else {
					this.head = null;
				}
			}
			else {
				Node<E> targetNode = this.findNode(index);
				targetNode.prev.next = targetNode.next;
				removed = targetNode.item;
			}
			this.currentSize--;
			return removed;
		}
		else {
			throw new IndexOutOfBoundsException("Index out of range!");
		}
	}
	
	/*
	 * Method Name: getValue
	 * Purpose: Gets the value at a given index in the list
	 * Parameters: 
	 * - index: The index to get the value at
	 * Preconditions: N/A
	 * Postconditions: The value at the given index is returned, no changes to the list are made
	 * Exceptions:
	 * - IndexOutOfBoundsException: Thrown if the given index is less than 0 or greater than or equal to the current size of the list
	 */
	public E getValue(int index) {
		if (index < this.currentSize && index >= 0) {
			return this.findNode(index).item;
		}
		else {
			throw new IndexOutOfBoundsException("Index out of range!");
		}
	}

	/*
	 * Method Name: indexOf
	 * Purpose: Finds the index of the first occurrence of the given value in the list
	 * Parameters: 
	 * - value: The data value to search for in the list to find the index of
	 * Preconditions: N/A
	 * Postconditions: 
	 * 	- The index of the first occurrence of the value in the list is returned. 
	 * 	- If the value is not in the list, -1 is returned
	 * Exceptions: N/A
	 */
	public int indexOf(E value) {
		int count = 0;
		for (Node<E> elem = this.head; elem != null; elem = elem.next) {
			if (elem.item.equals(value)) {
				return count;
			}
			count++;
		}
		return -1;
	}

	/*
	 * Method Name: size
	 * Purpose: Gets the current number of elements stored in the list
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the current number of elements in the list
	 * Exceptions: N/A
	 */
	public int size() {
		return this.currentSize;
	}
	
	/*
	 * Method Name: findNode
	 * Purpose: Helper method to traverse the LinkedList and find the node at a given index
	 * Parameters: 
	 * - index: The index in the LinkedList to get the node at
	 * Preconditions: N/A
	 * Postconditions: The node at the current index returned
	 * Exceptions: N/A
	 */
	private Node<E> findNode(int index) {
		Node<E> targetNode = null;
		int count = 0;
		for (Node<E> elem = this.head; elem != null; elem = elem.next) {
			if (count == index) {
				targetNode = elem;
			}
			count++;
		}
		return targetNode;
	}
	
	/*
	 * Class Name: Node
	 * Purpose: This Node class is used to represent the generic nodes in the LinkedList object as outlined in the Bonus Lab
	 * Exceptions: N/A
	 */
	private class Node<E> {
		public Node<E> next;
		public Node<E> prev;
		public E item;
		
		/*
		 * Method Name: Node
		 * Purpose: Constructs a new generic Node object with the given item
		 * Parameters: N/A
		 * Preconditions: N/A
		 * Postconditions: Constructs a new generic Node object and stores the given data item in the node
		 * Exceptions: N/A
		 */
		public Node(E item) {
			this.item = item;
		}
	}
}
