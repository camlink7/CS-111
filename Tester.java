
public class Tester {
	public static void main(String args[]) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertBefore(0, 3);
		list.insertBefore(0, 2);
		list.insertBefore(0, 1);
		printLinkedList(list);
		
		list.insertAfter(0, 5);
		printLinkedList(list);
		list.remove(2);
		printLinkedList(list);
	
	}
	
	private static void printLinkedList(LinkedList<Integer> list) {
		System.out.print("[ ");
		for (int i = 0; i < list.size() - 1; i++) {
			System.out.print(Integer.toString(list.getValue(i)) + ", ");
		}
		System.out.print(Integer.toString(list.getValue(list.size() - 1)) + " ]");
		System.out.println("");
	}
}
