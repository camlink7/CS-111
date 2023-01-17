package Lab2;
public class Refresher {
	public static String swapHalves(String line) {
		int middleIndex = line.length() / 2;
		if (line.length() % 2 != 0) {
			middleIndex++;
		}
		return line.substring(middleIndex, line.length()) + line.substring(0, middleIndex);
	}

	public static int countVowels(String line) {
		String lowercaseLine = line.toLowerCase();
		final String VOWELS = "aeiou";
		int count = 0;
		for (int i = 0; i < lowercaseLine.length(); i++) {
			if (VOWELS.indexOf(lowercaseLine.charAt(i)) != -1) {
				count++;
			}
		}
		return count;
	}

	public static int getMax(int[] array) {
		int maxValue = Integer.MIN_VALUE;
		int maxIndex = 0;
		for (int i = 0; i < array.length; i++) {
			//
		}
		return 0;
	}

	public static boolean isPalindrome(String line) {
		return false;
	}

	public static int factorial(int n) {
		return 0;
	}

	public static int[] getFibonacci(int n) {
		return new int[n];
	}

	public static double getC(int a, int b) {
		return 0.0;
	}

	public static String getWeather(boolean rain, int temperature) {
		return "";
	}

	public static boolean containsChar(String line, char x) {
		return false;
	}

	public static int[][] fillArray(int[][] array) {
		return array;
	}

	public static void printOdd(int[] array) {
	}

	public static String reverseString(String line) {
		return "";
	}

	public static int[] swap(int[] array, int index1, int index2) {
		return array;
	}

	public static int reverseInt(int number) {
		return 0;
	}

	public static int[] rotateArray(int[] array) {
		return array;
	}
}