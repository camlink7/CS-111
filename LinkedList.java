import java.lang.IndexOutOfBoundsException;

public class LinkedList<E> {
	private Node<E> head;
	private int currentSize;
	
	public LinkedList() {
		this.head = null;
		this.currentSize = 0;
	}

	public void insertBefore(int index, E value) {
		if (index >= this.currentSize || index < 0) { throw new IndexOutOfBoundsException("Index out of range!"); }
		
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
			System.out.println(beforeNode);
			newNode.next = beforeNode;
			newNode.prev = beforeNode.prev;
			beforeNode.prev = newNode;
		}
		
		this.currentSize++;
	}

	public void insertAfter(int index, E value) {
		if (index >= this.currentSize || index < 0) { throw new IndexOutOfBoundsException("Index out of range!"); }
		
		Node<E> newNode = new Node<E>(value);
		if (index == 0) {
			if (this.size() >= 1) {
				newNode.prev = this.head;
				newNode.next = this.head.next;
				this.head.next = newNode;
			}
			else {
				this.head = newNode;
			}
		}
		else {
			
		}
		
		this.currentSize++;
	}
	
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
	
	public E getValue(int index) {
		if (index < this.currentSize && index >= 0) {
			return this.findNode(index).item;
		}
		else {
			throw new IndexOutOfBoundsException("Index out of range!");
		}
	}

	public int indexOf(E value) {
		return -1;
	}

	public int size() {
		return this.currentSize;
	}
	
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
	
	private class Node<E> {
		public Node<E> next;
		public Node<E> prev;
		public E item;
		
		public Node(E item) {
			this.item = item;
		}
	}
}
