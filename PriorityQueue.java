public class PriorityQueue {
	private int currentSize;
	private Node head;
	private Node tail;
	
	public PriorityQueue() {
		this.currentSize = 0;
		this.head = null;
		this.tail = null;
	}

	public void priorityEnqueue(Process proc) {
		Node nodeBeforeInsert = this.head;
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