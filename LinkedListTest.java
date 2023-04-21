import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.lang.IndexOutOfBoundsException;

class LinkedListTest<E> extends LinkedList<E> {

	final Integer[] INTEGERS = {1, 5, -2, 6, 1};
	final Integer excludedValue = -5; //Should NOT be in the array of ints above
	
	@Test
	void testInsertBefore() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for (Integer i : INTEGERS) {
			list.insertBefore(0, i);
			assertEquals(i, list.getValue(0));
		}
		
		for (Integer i : INTEGERS) {
			list.insertBefore(2, i);
			assertEquals(i, list.getValue(2));
		}
		
		try {
			list.insertBefore(INTEGERS.length, 5);
		}
		catch (IndexOutOfBoundsException e){
			//Pass test silently
		}
	}
	
	@Test
	void testInsertAfter() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (Integer i : INTEGERS) {
			list.insertAfter(0, i);
			assertEquals(i, list.getValue(0));
		}
		
		
//		for (Integer i : INTEGERS) {
//			list.insertAfter(2, i);
//			assertEquals(i, list.getValue(3));
//		}
		
		try {
			list.insertAfter(INTEGERS.length, 5);
		}
		catch (IndexOutOfBoundsException e){
			//Pass test silently
		}
	}

	@Test
	void testRemove() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		int last = -1;
		for (Integer i : INTEGERS) {
			list.insertBefore(0, i);
			last = i;
		}
		
		assertEquals(last, list.remove(0));
		int endVal = list.getValue(INTEGERS.length - 2);
		assertEquals(endVal, list.remove(INTEGERS.length - 2));
		
		
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.insertBefore(0, 1);
		list2.insertBefore(0, 2);
		list2.insertBefore(0, 3);
		assertEquals(list2.remove(1), 2);
		assertEquals(list2.getValue(1), 1);
		assertEquals(list2.getValue(0), 3);
		
	}
	
	@Test
	void testGetValue() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (Integer i : INTEGERS) {
			list.insertBefore(0, i);
		}
		assertEquals(INTEGERS[0], list.getValue(0));
		assertEquals(INTEGERS[2], list.getValue(2));
		assertEquals(INTEGERS[INTEGERS.length - 1], list.getValue(INTEGERS.length - 1));
		
		try {
			list.getValue(INTEGERS.length);
		}
		catch (IndexOutOfBoundsException e){
			//Pass test silently
		}
	}
	
	@Test
	void testIndexOf() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (Integer i : INTEGERS) {
			list.insertAfter(0, i);
		}
		assertEquals(0, list.indexOf(INTEGERS[0]));
		assertEquals(2, list.indexOf(INTEGERS[2]));
		assertEquals(INTEGERS.length - 1, list.indexOf(INTEGERS[INTEGERS.length - 1]));
		
		assertEquals(-1, list.indexOf(excludedValue));
	}
	
	@Test
	void testSize() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (Integer i : INTEGERS) {
			list.insertBefore(0, i);
		}
		
		assertEquals(INTEGERS.length, list.size());
	}
}
