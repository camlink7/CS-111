/*
 * Name: Camden Link
 * Assignment: Lab 6
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-02-20
 * Purpose: This file contains implementation for a Reverse Polish Notation Calculator as detailed in Lab 6
 */

import java.util.Stack;
import java.util.Scanner;
import java.lang.Double;

/*
 * Class Name: Calculator
 * Purpose: This class contains the main() method for the runtime calculator of a Reverse Polish Notation using a Stack implementation
 * Exceptions: N/A
 */
public class Calculator {
	/*
	 * Method Name: main
	 * Purpose: The runtime loop for the calculator. Allows for the 4 basic math operations, an "exit" command, and a "print" command
	 * Parameters:
	 * - args: The runtime args given to the main method
	 * Preconditions: N/A
	 * Postconditions: Will continue to run the calculator until the "exit" command is received
	 * Exceptions:
	 * - System.err if the stack is empty and the 'print' command is ran
	 * - System.err if an operation is attempted on a stack with less than 2 numbers
	 * - System.err if the input is not a valid operation, command, or Double
	 */
	public static void main(String[] args) {
		boolean running = true;
		Scanner scanner = new Scanner(System.in);
		Stack<Double> stack = new Stack<Double>();
		
		while (running) {
			String input = scanner.nextLine();
			
			switch (input) {
				case "+":
					performOperationOnStack(stack, "+");
					break;
				case "-":
					performOperationOnStack(stack, "-");
					break;
				case "*":
					performOperationOnStack(stack, "*");
					break;
				case "/":
					performOperationOnStack(stack, "/");
					break;
				case "exit":
					running = false;
					break;
				case "print":
					if (!stack.empty()) {
						System.out.printf("%f\n", stack.peek());
					}
					else {
						System.err.println("There are no numbers to print!");
					}
					break;
				default:
					if (stringIsDouble(input)) {
						stack.push(Double.parseDouble(input));
					}
					else {
						System.err.println("Not a valid input!");
					}
					break;
			}
			
		}
	}
	
	/*
	 * Method Name: stringIsDouble
	 * Purpose: Determines if a given string is a valid double number
	 * Parameters:
	 * - str: The string to attempt to parse to a double
	 * Preconditions: N/A
	 * Postconditions:
	 * - Returns true: The given str is a valid double when parsed
	 * - Returns false: the given str is NOT a valid double when parsed
	 * Exceptions:
	 * - Uses try/catch, but does NOT throw any exceptions
	 */
	private static boolean stringIsDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	/*
	 * Method Name: performOperationOnStack
	 * Purpose: Performs one of the four basic math operations on the top two numbers in a given stack, MODIFYING the stack
	 * Parameters:
	 * - stack: The given stack to modify and perform the operations on
	 * - operation: The string operation to perform ("+", "-", "*", "/")
	 * Preconditions:
	 * - Stack MUST have at least two numbers
	 * - Operation must be one of the valid operator strings
	 * Postconditions:
	 * - Pops the top two numbers on the stack, performs the operation, and will push the result back onto the stack
	 * - NOTE: This method MODIFIES the stack directly
	 * Exceptions:
	 * - System.err if there are less than two numbers on the stack
	 */
	private static void performOperationOnStack(Stack<Double> stack, String operation) {
		//Make sure the stack has at least two numbers
		if (stack.size() < 2) {
			System.err.println("Must input at least two numbers to perform an operation!");
			return;
		}
		
		
		//Get the first two numbers on the stack
		double firstNum = stack.pop();
		double secondNum  = stack.pop();
		
		double result = 0;
		
		switch (operation) {
			case "+":
				result = firstNum + secondNum;
				break;
			case "-":
				result = secondNum - firstNum;
				break;
			case "*":
				result = firstNum * secondNum;
				break;
			case "/":
				result = secondNum / firstNum;
				break;
			default:
				return;
		}
		
		//Take the new result and push it back onto the stack
		stack.push(result);
		System.out.printf("%f\n", result);
	}

}