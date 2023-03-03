package Program2;
/*
 * Name: Camden Link
 * Assignment: Program 2
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-03-02
 * Purpose: This file contains the Tester class, which is a runtime class for testing the GraphicObject and its child classes via the
 * 		ObjectOperations class
 */

import java.io.File;
import java.util.Scanner;

/*
 * Class Name: Tester
 * Purpose: A runtime class that acts as an entry point for loading shape data from a .txt, drawing and printing each object
 * Exceptions: 
 * - Doesn't throw new Exception, but uses a try/catch to catch any errors while loading and reading the shapes data .txt file.
 * 	Will show a generic message if an error occurs and will be required to restart the program
 */
public class Tester {
	
	/*
	 * Method Name: main
	 * Purpose: The main entry point for testing; Prompts the user to enter the name of a file, attempts to open and parse that file,
	 * 		and draws each shape and prints each shape using the ObjectOperations class
	 * Parameters:
	 * - args[]: Java default parameter for the main() method containing any execution arguments
	 * Preconditions:
	 * - The filename given should be a valid .txt file containing the properly formatted shape data
	 * Postconditions: Prompts the user for a filename, attempts to open that file and will draw and print each shape loaded successfully
	 * Exceptions:
	 * - Doesn't throw new Exception, but uses a try/catch to catch any errors while loading and reading the shapes data .txt file. 
	 */
	public static void main(String args[]) {		
		try {
			//Prompt the user for the name of the file
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the name of the shapes' data file: ");
			String filename = input.nextLine();
			
			//Initialize and setup the StdDraw canvas
			StdDraw.setCanvasSize(1000, 1000);
			StdDraw.setXscale(0, 1000);
			StdDraw.setYscale(0, 1000);
			StdDraw.setPenRadius(0.02);
			
			GraphicObject[] fileShapeList = ObjectOperations.fillArray(new Scanner(new File(filename)));
			ObjectOperations.drawList(fileShapeList);
			ObjectOperations.printList(fileShapeList);
		} 
		catch(Exception e) {
			System.err.println("Something went wrong when trying to read that file!");
			System.err.println(e);
		}
	}
}