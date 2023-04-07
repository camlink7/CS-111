/*
 * Name: Camden Link
 * Assignment: Program 3
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-04-06
 * Purpose: 
 * - This file contains the PriorityQueue as outlined in Program 3.
 * - This file also contains the Node object used in the internal structure of the PriorityQueue
 */

/*
 * Class Name: PriorityQueue
 * Purpose: This class is a Queue data structure for Process objects that also allows for sorting the queue based on 
 *		the burstTime of the Processes (low to high)
 * Exceptions: N/A
 */
public class PriorityQueue {
	private int currentSize;
	private Node head;
	private Node tail;
	
	/*
	 * Method Name: PriorityQueue
	 * Purpose: Constructs a new PriorityQueue object with no elements
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Constructs an empty PriorityQueue object
	 * Exceptions: N/A
	 */
	public PriorityQueue() {
		this.currentSize = 0;
		this.head = null;
		this.tail = null;
	}

	
	/*
	 * Method Name: priorityEnqueue
	 * Purpose: Adds a new Process to the queue based on the burstTime of the new object. The lower the burstTime, the more towards the
	 * 		front of the Queue the process is placed
	 * Parameters:
	 * - proc: The process to be added to the queue
	 * Preconditions:
	 * - proc should be a properly initialized Process object
	 * Postconditions: Adds the process to the queue based on the burst time sorted from low to high
	 * Exceptions: N/A
	 */
	public void priorityEnqueue(Process proc) {
		Node newNode = new Node(proc);
		
		//Just insert if there are no other nodes
		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		}
		else {
			Node current = this.head;
			Node previous = null;
			boolean hasInserted = false;
			
			while (current != null) {
				if (proc.getBurst() < current.getProcess().getBurst()) {
					if (previous != null) { //Inserting somewhere after the beginning
						newNode.setNext(current);
						previous.setNext(newNode);
					}
					else { //Inserting at the beginning of the queue
						this.head = newNode;
						newNode.setNext(current);
					}
					hasInserted = true;
					break;
				}
				else if (proc.getBurst() == current.getProcess().getBurst()) {
					newNode.setNext(current.getNext());
					current.setNext(newNode);
					hasInserted = true;
					break;
				}
				previous = current;
				current = current.getNext();
			}
			
			//Insert at the end of the queue
			if (!hasInserted) {
				this.tail.setNext(newNode);
				this.tail = newNode;
			}
		}
		
		this.currentSize++;
	}

	/*
	 * Method Name: enqueue
	 * Purpose: Adds a new Process to the end of the queue, after the tail
	 * Parameters:
	 * - proc: The process to be added to the queue
	 * Preconditions:
	 * - proc should be a properly initialized Process object
	 * Postconditions: Adds the process to the very end of the queue, making it the new tail
	 * Exceptions: N/A
	 */
	public void enqueue(Process proc) {
		Node newNode = new Node(proc);
		if (this.isEmpty()) {
			this.head = newNode;
			this.tail = newNode;
		}
		else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
		this.currentSize++;
	}

	/*
	 * Method Name: dequeue
	 * Purpose: To remove and return the first Process in the queue
	 * Parameters: N/A
	 * Preconditions:
	 * - The list should not be empty (will return null if empty)
	 * Postconditions: Removes the first Process in the queue, updating the head. The Process that is removed is returned.
	 * 		If the list is empty, null is returned
	 * Exceptions: N/A
	 */
	public Process dequeue() {
		if (!this.isEmpty()) {
			Process removed;
			
			//Normal Dequeue
			if (this.size() > 1) {
				removed = new Process(this.head.getProcess());
				this.head = this.head.getNext();
			}
			
			//Only one element to remove
			else {
				removed = new Process(this.head.getProcess());
				this.head = null;
				this.tail = null;
			}
			
			this.currentSize--;
			return removed;
		}
		return null;
	}

	/*
	 * Method Name: isEmpty
	 * Purpose: Determines if the queue is currently empty
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns true of there are no Processes in the queue, returns false if there is at least one Process in the queue
	 * Exceptions: N/A
	 */
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	/*
	 * Method Name: size
	 * Purpose: Gets the current number of Processes in the queue
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the current number of Processes in the queue
	 * Exceptions: N/A
	 */
	public int size() {
		return currentSize;
	}
	
	
	/*
	 * Class Name: Node
	 * Purpose: This class is singly linked Node that stores a Process. It is used in the internal structure of the PriorityQueue
	 * Exceptions: N/A
	 */
	private class Node {
		private Process process;
		private Node next;
		
		
		public Node(Process process) {
			this.process = process;
		}
		
		
		/*
		 * Method Name: getNext
		 * Purpose: Gets the node that is linked next (after) to this node
		 * Parameters: N/A
		 * Preconditions: N/A
		 * Postconditions: Returns the next node (node after this node)
		 * Exceptions: N/A
		 */
		public Node getNext() {
			return this.next;
		}
		
		/*
		 * Method Name: setNext
		 * Purpose: Sets the next node (node linked after this)
		 * Parameters: N/A
		 * Preconditions: N/A
		 * Postconditions: Sets the next node to the given node
		 * Exceptions: N/A
		 */
		public void setNext(Node nextNode) {
			this.next = nextNode;
		}
		
		/*
		 * Method Name: getProcess
		 * Purpose: Gets the Process object stored in this node
		 * Parameters: N/A
		 * Preconditions: N/A
		 * Postconditions: Returns the Process object associated with this node
		 * Exceptions: N/A
		 */
		public Process getProcess() {
			return this.process;
		}
		
		/*
		 * Method Name: setProcess
		 * Purpose: Sets the Process object of this node to the given Process
		 * Parameters: N/A
		 * Preconditions: N/A
		 * Postconditions: Sets the current Process object stored in this node to the given Process object
		 * Exceptions: N/A
		 */
		public void setProcess(Process newProcess) {
			this.process = newProcess;
		}
	}
}