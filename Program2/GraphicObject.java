package Program2;
/*
 * Name: Camden Link
 * Assignment: Program 2
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-03-02
 * Purpose: This file contains the GraphicObject abstract class
 */

import java.awt.Color;

/*
 * Class Name: GraphicObject
 * Purpose: Abstract class representing an a Graphical Object that can be draw to an 
 * 		StdDraw canvas. ALL child shapes extend this class
 * Exceptions: N/A
 */
public abstract class GraphicObject {
	private double x;
	private double y;
	private Color color;
	
	/*
	 * Method Name: GraphicObject
	 * Purpose: Constructs a new abstract GraphicObject object at a certain location and a specified color
	 * Parameters:
	 * - newX: The x-coordinate of the object on the StdDraw canvas
	 * - newY: The y-coordinate of the object on the StdDraw canvas
	 * - red: The red RGB value for the color of the GraphicObject
	 * - green: The green RGB value for the color of the GraphicObject
	 * - blue: The blue RGB value for the color of the GraphicObject
	 * Preconditions: 
	 * - The x, y coordinates should be within the bounds of the canvas
	 * Postconditions: Constructs a new abstract GraphicObject at the specified location with the specified color
	 * Exceptions: N/A
	 */
	public GraphicObject(double newX, double newY, int red, int green, int blue) {
		this.x = newX;
		this.y = newY;
		this.color = new Color(red, green, blue);
	}
	
	/*
	 * Method Name: getX
	 * Purpose: To get the x-coordinate of the GraphicObject
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the x-coordinate of the GraphicObject
	 * Exceptions: N/A
	 */
	public double getX() {
		return this.x;
	}
	
	/*
	 * Method Name: getY
	 * Purpose: To get the y-coordinate of the GraphicObject
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the y-coordinate of the GraphicObject
	 * Exceptions: N/A
	 */
	public double getY() {
		return this.y;
	}
	
	/*
	 * Method Name: getColor
	 * Purpose: To get the color of the shape
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns the color of the shape as a java Color object
	 * Exceptions: N/A
	 */
	public Color getColor() {
		return this.color;
	}
	
	/*
	 * Method Name: toString
	 * Purpose: To get a string that describes all the information about this GraphicObject
	 * Parameters: N/A
	 * Preconditions: N/A
	 * Postconditions: Returns a string describing the object and all its attributes including location, object type, color
	 * 			area, and perimeter
	 * Exceptions: N/A
	 */
	public String toString() {
		return String.format("The object at location: %s %s is an instance of %s Red: %s Blue: %s Green %s. It has the area:"
				+ " %s, and perimeter: %s", Double.toString(this.x), Double.toString(this.y), this.getClass().toString(), 
				Integer.toString(this.color.getRed()), Integer.toString(this.color.getBlue()), Integer.toString(this.color.getGreen()),
				Double.toString(this.calculateArea()), Double.toString(this.calculatePerimeter()));
	}
	
	/*
	 * Method Name: draw
	 * Purpose: Abstract method to draw the object to the active StdDraw canvas
	 * Parameters: N/A
	 * Preconditions:
	 * - The StdDraw canvas must be setup and configured properly before drawing. Specific implementation depends on the child class
	 * Postconditions: Draws the GraphicObject to the StdDraw canvas at this object's (x, y) coordindate and this object's color
	 * Exceptions: N/A
	 */
	public abstract void draw();
	
	/*
	 * Method Name: calculateArea
	 * Purpose: Abstract method to calculate the area of the GraphicObject shape. Specific implementation depends on the child class
	 * Parameters: N/A
	 * Preconditions:
	 * - The shape must have valid size parameters (dependent on the shape type)
	 * Postconditions: Returns the area of the shape in StdDraw canvas units
	 * Exceptions: N/A
	 */
	public abstract double calculateArea();
	
	/*
	 * Method Name: calculatePerimeter
	 * Purpose: Abstract method to calculate the perimeter of the GraphicObject shape. Specific implementation depends on the child class
	 * Parameters: N/A
	 * Preconditions:
	 * - The shape must have valid size parameters (dependent on the shape type)
	 * Postconditions: Returns the perimeter of the shape in StdDraw canvas units
	 * Exceptions: N/A
	 */
	public abstract double calculatePerimeter();
}