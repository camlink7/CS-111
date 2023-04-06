/*
 * Name: Camden Link
 * Assignment: Program 3
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-04-06
 * Purpose: This file contains the PriorityQueue as outlined in Program 3
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

	
	//TODO: FINISH THIS
	/*
	 * Method Name: priorityEnqueue
	 * Purpose: Adds a new Process to the queue based on the burstTime of the new object. The lower the burstTime, the more towards the
	 * 		front of the Queue the process is placed
	 * Parameters:
	 * - proc: The process to be added to the queue
	 * Preconditions:
	 * - proc should be a properly initialized Process object
	 * Postconditions: Constructs a new Process object with the given parameter
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

	public Process dequeue() {
		if (!this.isEmpty()) {
			Process removed;
			
			//Only one element to remove
			if (this.size() == 1) {
				removed = new Process(this.head.getProcess());
				this.head = null;
				this.tail = null;
			}
			
			//Normal deque
			else {
				removed = new Process(this.head.getProcess());
				this.head = this.head.getNext();
			}
			
			this.currentSize--;
			return removed;
		}
		return null;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	public int size() {
		return currentSize;
	}
	
	
	private class Node {
		private Process process;
		private Node next;
		
		public Node(Process process) {
			this.process = process;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		public void setNext(Node nextNode) {
			this.next = nextNode;
		}
		
		public Process getProcess() {
			return this.process;
		}
		
		public void setProcess(Process newProcess) {
			this.process = newProcess;
		}
	}
}