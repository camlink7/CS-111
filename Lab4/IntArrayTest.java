package Lab4;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntArrayTest {

	@Test
	void testIntArrayIntArray() {
		int[] arr = { 0, 1, 2, 3, 4, 5 };
		IntArray ia = new IntArray(arr);
		assertArrayEquals(arr, ia.asArray());
		assertNotSame(arr, ia.asArray());
	}

	@Test
	void testGetValue() {
		int[] arr = { 0, 1, 2, 3, 4, 5 };
		IntArray ia = new IntArray(arr);
		int[] test = ia.asArray();
		for (int i = 0; i < arr.length; i++) {
			assertEquals(arr[i], ia.getValue(i));
		}
		for (int i = 0; i < 10; i++) {
			assertEquals(0, ia.getValue(arr.length + i));
		}
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			ia.getValue(-1);
		});
	}

	@Test
	void testSetValue() {
		int[] arr = { 0, 1, 2, 3, 4, 5 };
		IntArray ia = new IntArray();
		for (int i = 0; i < arr.length; i++) {
			ia.setValue(i, arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			assertEquals(arr[i], ia.getValue(i));
		}
		for (int i = 0; i < 10; i++) {
			assertEquals(0, ia.getValue(arr.length + i));
		}
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			ia.setValue(-1, 0);
		});
	}
	
	@Test
	void testLength() {
		IntArray ia = new IntArray();
		assertEquals(0, ia.length());
		ia = new IntArray(new int[] { 0, 1, 2, 3, 4 });
		assertEquals(5, ia.length());
		ia.setValue(10, 10);
		assertEquals(11, ia.length());
		ia.getValue(20);
		assertEquals(21, ia.length());
	}

	@Test
	void testAsArray() {
		int[] arr = { 0, 1, 2, 3, 4, 5 };
		IntArray ia = new IntArray(arr);
		assertArrayEquals(arr, ia.asArray());
		assertNotSame(arr, ia.asArray());
	}

	@Test
	void testEqualsIntArray() {
		int[] arr = { 0, 1, 2, 3, 4, 5 };
		int[] arr2 = { 0, 1 };
		IntArray ia1 = new IntArray(arr);
		IntArray ia2 = new IntArray(arr);
		IntArray ia3 = new IntArray(arr2);
		assertTrue(ia1.equals(ia2));
		ia1.setValue(0, 1);
		assertFalse(ia1.equals(ia2));
		assertFalse(ia1.equals(ia3));
	}

}