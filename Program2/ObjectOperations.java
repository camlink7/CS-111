package Program2;
/*
 * Name: Camden Link
 * Assignment: Program 2
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-03-02
 * Purpose: This file contains the ObjectOperations class
 */

import java.util.Scanner;
import java.util.Arrays;

/*
 * Class Name: ObjectOperations
 * Purpose: This class is responsible for reading a shapes data .txt file, drawing, and printing each shape to the StdDraw canvas.
 * Exceptions: N/A
 */
public class ObjectOperations {
	private static GraphicObject[] array;
	private static int currentSize;
	
	/*
	 * Method Name: fillArray
	 * Purpose: Fills the static internal array of this object with GraphicObject instances which can be drawn and printed
	 * Parameters:
	 * - filename: Scanner object that has loaded a .txt file containing the data for a list of shapes
	 * Preconditions:
	 * - Shapes data .txt file requirements: 
	 * 		- First line is the number of shapes
	 * 		- Attributes of a shape should be seperated with a single space
	 * 		- The type of shape comes first, then the x & y coords, followed by the r, g, b integers of the color
	 * 		- The final attributes in each line are dependent on which shape is being drawn
	 * 		- Example to load Rectangle obj: "R 800 320 0 128 128 100 150"
	 * Postconditions: The internal static array will be filled with GraphicObject instances that have been loaded from 
	 * 		the shapes data .txt file
	 * Exceptions: N/A
	 */
	public static GraphicObject[] fillArray(Scanner filename) {
		///Get the number of shapes and init the array with that count
		int numberOfShapes = Integer.parseInt(filename.nextLine());
		array = new GraphicObject[numberOfShapes];
		currentSize = 0;
		
		//Read each shape from the file
		for (int i = 0; i < numberOfShapes; i++) {
			String[] shapeData = filename.nextLine().split(" ");
			
			String[] tempShapeData = new String[shapeData.length];
			int tempCurrentSize = 0;
			//Remove the shapeData elements that are simply blank spaces by stripping the element
			for (int x = 0; x < shapeData.length; x++) {
				if (!shapeData[x].strip().equals("")) {
					tempShapeData[tempCurrentSize] = shapeData[x];
					tempCurrentSize++;
				}
			}
			
			//Only copy to the part that is filled in, so no null values are still in the shape data
			shapeData = Arrays.copyOfRange(tempShapeData, 0, tempCurrentSize);
			
			//Instantiate an object for the appropriate shape type
			double x = Double.parseDouble(shapeData[1]);
			double y = Double.parseDouble(shapeData[2]);
			int red = Integer.parseInt(shapeData[3]);
			int green = Integer.parseInt(shapeData[5]);
			int blue = Integer.parseInt(shapeData[4]);
			switch (shapeData[0].toUpperCase()) {
				case "C":
					double radius = Double.parseDouble(shapeData[6]);
					array[currentSize] = new Circle(x, y, red, green, blue, radius);
					currentSize++;
					break;
				case "R": 
					double length = Double.parseDouble(shapeData[6]);
					double width = Double.parseDouble(shapeData[7]);
					array[currentSize] = new Rectangle(x, y, red, green, blue, length, width);
					currentSize++;
					break;
				case "S":
					double sideLength = Double.parseDouble(shapeData[6]);
					array[currentSize] = new Square(x, y, red, green, blue, sideLength);
					currentSize++;
					break;
				case "E":
					double semiMinorAxis = Double.parseDouble(shapeData[6]);
					double semiMajorAxis = Double.parseDouble(shapeData[7]);
					array[currentSize] = new Ellipse(x, y, red, green, blue, semiMajorAxis, semiMinorAxis);
					currentSize++;
					break;
			}
		}
		return array;
	}
	
	/*
	 * Method Name: drawList
	 * Purpose: Calls the draw() method on each GraphicObject currently stored in the given array
	 * Parameters:
	 * - objectList: GraphicObject[] array of GraphicObjects to draw
	 * Preconditions: N/A
	 * Postconditions: Draws each object in the given array to the StdDraw canvas
	 * Exceptions: N/A
	 */
	public static void drawList(GraphicObject[] objectList) {
		for (int i = 0; i < objectList.length; i++) {
			objectList[i].draw();
		}
	}
	
	/*
	 * Method Name: printList
	 * Purpose: Prints the results of the toString() method in each GraphicObject in the given array
	 * Parameters:
	 * - objectList: GraphicObject[] array of GraphicObjects to print
	 * Preconditions: N/A
	 * Postconditions: Prints a description (using GraphicObject.toString()) of each object in the given array
	 * Exceptions: N/A
	 */
	public static void printList(GraphicObject[] objectList) 
	{
		for (int i = 0; i < objectList.length; i++) {
			System.out.println(objectList[i].toString());
		}
	}
}