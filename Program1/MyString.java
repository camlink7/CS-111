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
		for (int i = 0; i < this.text.length; i++) {
			this.text[i] = Character.toUpperCase(this.text[i]);
		}
		return this;
	}

	public MyString toLowerCase() {
		for (int i = 0; i < this.text.length; i++) {
			this.text[i] = Character.toLowerCase(this.text[i]);
		}
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
		//If the 'other' object is null, return false
		if (other == null) { return false; }
		
		char[] otherCharArray = other.toString().toCharArray();
		//If both objects have the same number of characters
		if (this.text.length == otherCharArray.length) {
			for (int i = 0; i < this.text.length; i++) {
				if (this.text[i] != otherCharArray[i]) {
					return false;
				}
			}
		}
		else {
			return false;
		}
		return true;
	}

	public int compareTo(MyString anotherString) {
		char[] otherCharArray = anotherString.toString().toCharArray();
		int minLength = Math.min(this.text.length, otherCharArray.length);
		
		//Check for a difference in characters based on the Character class numerical comparison
		for (int i = 0; i < minLength; i++) {
			int compare = Character.compare(this.text[i], otherCharArray[i]);
			if (compare != 0) {
				return compare;
			}
		}
		
		//If all characters are the same until the min length is reached, return the difference in length
		return this.text.length - otherCharArray.length;
	}
}