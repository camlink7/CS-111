package Program1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyStringTest {
	
	@Test
	void testMyStringString() {
		String str = "string";
		MyString mystr = new MyString(str);
		assertEquals(str, mystr.toString());
	}

	@Test
	void testMyStringCharArray() {
		char[] arr = { 'a', 'r', 'r', 'a', 'y' };
		String str = new String(arr);
		MyString mystr = new MyString(arr);
		assertEquals(str, mystr.toString());
	}

	@Test
	void testMyStringMyString() {
		String str = "string";
		MyString mystr1 = new MyString(str);
		MyString mystr2 = new MyString(mystr1);
		assertEquals(mystr1.toString(), mystr2.toString());
	}

	@Test
	void testLength() {
		MyString mystr = new MyString("test");
		assertEquals(4, mystr.length());
	}

	@Test
	void testCharAt() {
		MyString mystr = new MyString("foo bar baz");
		assertEquals('b', mystr.charAt(4));
	}

	@Test
	void testConcat() {
		MyString mystr1 = new MyString("foo");
		MyString mystr2 = new MyString("bar");
		MyString mystr3 = new MyString("foobar");
		assertEquals(mystr3.toString(), mystr1.concat(mystr2).toString());
	}

	@Test
	void testIndexOfChar() {
		MyString mystr = new MyString("search me");
		assertEquals(1, mystr.indexOf('e'));
	}

	@Test
	void testIndexOfCharInt() {
		MyString mystr = new MyString("search me");
		assertEquals(8, mystr.indexOf('e', 2));
	}

	@Test
	void testReplace() {
		MyString mystr1 = new MyString("foo bar");
		MyString mystr2 = new MyString("fee bar");
		assertEquals(mystr2.toString(), mystr1.replace('o', 'e').toString());
	}

	@Test
	void testSubstringInt() {
		MyString mystr1 = new MyString("the haystack has a needle");
		MyString mystr2 = new MyString("needle");
		assertEquals(mystr2.toString(), mystr1.substring(19).toString());
	}

	@Test
	void testSubstringIntInt() {
		MyString mystr1 = new MyString("find a needle in the haystack");
		MyString mystr2 = new MyString("needle");
		assertEquals(mystr2.toString(), mystr1.substring(7, 13).toString());
	}

	@Test
	void testToUpperCase() {
		MyString mystr1 = new MyString("foo bar baz");
		MyString mystr2 = new MyString("FOO BAR BAZ");
		assertEquals(mystr2.toString(), mystr1.toUpperCase().toString());
	}

	@Test
	void testToLowerCase() {
		MyString mystr1 = new MyString("FOO BAR BAZ");
		MyString mystr2 = new MyString("foo bar baz");
		assertEquals(mystr2.toString(), mystr1.toLowerCase().toString());
	}

	@Test
	void testToString() {
		String str = "foo bar baz";
		MyString mystr = new MyString(str);
		assertEquals(str, mystr.toString());
	}

	@Test
	void testEqualsMyString() {
		MyString mystr1 = new MyString("foo");
		MyString mystr2 = new MyString(mystr1);
		MyString mystr3 = new MyString("bar");
		assertTrue(mystr1.equals(mystr2));
		assertFalse(mystr1.equals(mystr3));
	}

	@Test
	void testCompareTo() {
		MyString mystr1 = new MyString("foo");
		MyString mystr2 = new MyString("bar");
		assertTrue(mystr1.compareTo(mystr2) > 0);
		assertTrue(mystr2.compareTo(mystr1) < 0);
	}

}