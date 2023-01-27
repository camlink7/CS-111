package Program1;
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
		return 0;
	}

	public char charAt(int index) {
		return 'x';
	}

	public MyString concat(MyString otherString) {
		return this;
	}

	public int indexOf(char ch) {
		return 0;
	}

	public int indexOf(char ch, int fromIndex) {
		return 0;
	}

	public MyString replace(char target, char replacement) {
		return this;
	}

	public MyString substring(int beginIndex) {
		return this;
	}

	public MyString substring(int beginIndex, int endIndex) {
		return this;
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