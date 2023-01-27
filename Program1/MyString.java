package Program1;

import java.lang.*;

public class MyString {
	private char[] text;
	
	public MyString(String original) {
		this.text = original.toCharArray();
	}

	public MyString(char[] original) {
		this.text = new char[original.length];
		for (int i = 0; i < original.length; i++) {
			this.text[i] = original[i];
		}
	}

	public MyString(MyString original) {
		this.text = original.toString().toCharArray();
	}

	public int length() {
		return this.text.length;
	}

	public char charAt(int index) {
		if (index >= 0 && index < text.length) {
			return this.text[index];
		}
		throw new IndexOutOfBoundsException("Given index does not exist!");
	}

	public MyString concat(MyString otherString) {
		return new MyString(this.toString() + otherString.toString());
	}

	public int indexOf(char ch) {
		for (int i = 0; i < this.text.length; i++) {
			if (this.text[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	public int indexOf(char ch, int fromIndex) {
		for (int i = fromIndex; i < this.text.length; i++) {
			if (this.text[i] == ch) {
				return i;
			}
		}
		return -1;
	}

	public MyString replace(char target, char replacement) {
		char[] newCharArray = this.text.clone();
		for (int i = 0; i < newCharArray.length; i++) {
			if (newCharArray[i] == target) {
				newCharArray[i] = replacement;
			}
		}
		return new MyString(newCharArray);
	}

	public MyString substring(int beginIndex) {
		char[] substring = new char[this.text.length - beginIndex];
		int substringCount = 0;
		
		if (beginIndex >= 0 && beginIndex < this.text.length) {
			for (int i = beginIndex; i < this.text.length; i++) {
				substring[substringCount] = this.text[i];
				substringCount++;
			}
			return new MyString(substring);
		}
		throw new IndexOutOfBoundsException("Given index does not exist!");
	}

	public MyString substring(int beginIndex, int endIndex) {
		char[] substring = new char[this.text.length - beginIndex];
		int substringCount = 0;
		
		if (beginIndex >= 0 && beginIndex < this.text.length) {
			for (int i = beginIndex; i < this.text.length; i++) {
				substring[substringCount] = this.text[i];
				substringCount++;
			}
			return new MyString(substring);
		}
		throw new IndexOutOfBoundsException("Given index does not exist!");
	}

	public MyString toUpperCase() {
		return this;
	}

	public MyString toLowerCase() {
		return this;
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < text.length; i++) {
			output += text[i];
		}
		return output;
	}

	public boolean equals(MyString other) {
		return false;
	}

	public int compareTo(MyString anotherString) {
		return 0;
	}
}