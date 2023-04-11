import java.lang.IndexOutOfBoundsException;

public class LinkedList<E> {
	private Node<E> head;
	private int currentSize;
	
	public LinkedList() {
		this.head = null;
		this.currentSize = 0;
	}

	public void insertBefore(int index, E value) {
		if (index >= this.size() && index != 0) { throw new IndexOutOfBoundsException("Index out of range!"); }
		
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
		}
		
		this.currentSize++;
	}

	public void insertAfter(int index, E value) {
	}
	
	public E remove(int index) {
		return null;
	}
	
	public E getValue(int index) {
		return null;
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
