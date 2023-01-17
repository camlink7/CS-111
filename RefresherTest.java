import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;

public class RefresherTest {
	@Test
	public void testSwapHalves() {
		assertEquals("twoone", Refresher.swapHalves("onetwo"));
		assertEquals("cattaco", Refresher.swapHalves("tacocat"));
	}

	@Test
	public void testCountVowels() {
		assertEquals(0, Refresher.countVowels("bcd)"));
		assertEquals(1, Refresher.countVowels("abcd"));
		assertEquals(2, Refresher.countVowels("abcde"));
		assertEquals(5, Refresher.countVowels("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
	}

	@Test
	public void testGetMax() {
		assertEquals(100, Refresher.getMax(new int[] { 0, 100, 2, 3, 1 }));
		assertEquals(0, Refresher.getMax(new int[] { -100, -20, 0, -15, -42 }));
	}

	@Test
	public void testIsPalindrome() {
		assertTrue(Refresher.isPalindrome("tacocat"));
		assertFalse(Refresher.isPalindrome("cattaco"));
	}

	@Test
	public void testFactorial() {
		assertEquals(1, Refresher.factorial(0));
		assertEquals(1, Refresher.factorial(1));
		assertEquals(2, Refresher.factorial(2));
		assertEquals(6, Refresher.factorial(3));
		assertEquals(24, Refresher.factorial(4));
		assertEquals(120, Refresher.factorial(5));
	}

	@Test
	public void testGetFibonacci() {
		int f4[] = { 0, 1, 1, 2 };
		int f6[] = { 0, 1, 1, 2, 3, 5 };
		int f8[] = { 0, 1, 1, 2, 3, 5, 8, 13 };
		assertArrayEquals(f4, Refresher.getFibonacci(4));
		assertArrayEquals(f6, Refresher.getFibonacci(6));
		assertArrayEquals(f8, Refresher.getFibonacci(8));
	}

	@Test
	public void testGetC() {
		assertEquals(5.0, Refresher.getC(3, 4));
		assertEquals(13.0, Refresher.getC(5, 12));
		assertEquals(25.0, Refresher.getC(7, 24));
	}

	@Test
	public void testGetWeather() {
		assertEquals("Snowy", Refresher.getWeather(true, 29));
		assertEquals("Rainy", Refresher.getWeather(true, 30));
		assertEquals("Chilly", Refresher.getWeather(false, 29));
		assertEquals("Sunny", Refresher.getWeather(false, 30));
	}

	@Test
	public void testContainsChar() {
		assertTrue(Refresher.containsChar("The five boxing wizards jump quickly", 'x'));
		assertFalse(Refresher.containsChar("characters are case sensitive", 'C'));
	}

	@Test
	public void testFillArray() {
		int filled[][] = {
			{ 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1 },
		};
		int tofill[][] = new int[5][5];
		assertArrayEquals(filled, Refresher.fillArray(tofill));
		assertArrayEquals(filled, tofill);
	}

	@Test
	public void testPrintOdd() {
		ByteArrayOutputStream testOut = new ByteArrayOutputStream();
		PrintStream systemOut = System.out;
		System.setOut(new PrintStream(testOut));

		Refresher.printOdd(new int[] { 0, 1, 3, 4, 5, 7 });
		assertEquals("1357", testOut.toString());

		testOut.reset();
		Refresher.printOdd(new int[] { -23, -15, 0, 2, 4, 6, 8, 11 });
		assertEquals("-23-1511", testOut.toString());

		System.setOut(systemOut);
	}

	@Test
	public void testReverseString() {
		assertEquals("esrever", Refresher.reverseString("reverse"));
		assertEquals("sdrawkcab si gnirts sihT", Refresher.reverseString("This string is backwards"));
	}

	@Test
	public void testSwap() {
		int a1[] = { 0, 1 };
		int a2[] = { 1, 0 };
		int a3[] = { 8, 6, 7, 5, 3, 0, 9 };
		int a4[] = { 8, 6, 9, 5, 3, 0, 7 };
		assertArrayEquals(a2, Refresher.swap(a1, 0, 1));
		assertArrayEquals(a2, a1);
		assertArrayEquals(a4, Refresher.swap(a3, 2, 6));
		assertArrayEquals(a4, a3);
	}

	@Test
	public void testReverseInt() {
		assertEquals(54321, Refresher.reverseInt(12345));
		assertEquals(24, Refresher.reverseInt(42));
	}

	@Test
	public void testRotateArray() {
		int a0[] = { 0, 1, 2, 3, 4, 5 };
		int a1[] = { 0, 1, 2, 3, 4, 5 };
		int a2[] = { 5, 0, 1, 2, 3, 4 };
		int a3[] = { 4, 5, 0, 1, 2, 3 };
		assertArrayEquals(a2, Refresher.rotateArray(a1));
		assertArrayEquals(a2, a1);
		assertArrayEquals(a3, Refresher.rotateArray(a2));
		assertArrayEquals(a3, a2);
	}
}