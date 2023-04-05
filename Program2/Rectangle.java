package Program2;
/*
 * Name: Camden Link
 * Assignment: Program 2
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-03-02
 * Purpose: This file contains the Rectangle class that extends the GraphicObject class
 */

/*
 * Class Name: Rectangle
 * Purpose: Allows for calculation of area + perimeter of a Rectangle, as well as drawing to the screen using the StdDraw library
 * Exceptions: N/A
 */
public class Rectangle extends GraphicObject {
	private double length;
	private double width;
	
	/*
	 * Method Name: Rectangle
	 * Purpose: Constructs a new Rectangle object extending the GraphicObject class
	 * Parameters:
	 * - newX: The x-coordinate of the object on the StdDraw canvas
	 * - newY: The y-coordinate of the object on the StdDraw canvas
	 * - red: The red RGB value for the color of the Rectangle
	 * - green: The green RGB value for the color of the Rectangle
	 * - blue: The blue RGB value for the color of the Rectangle
	 * - newLength: The length of the rectangle
	 * - newWidth: The width of the rectangle
	 * Preconditions: 
	 * - The x, y coordinates should be within the bounds of the canvas
	 * - The width and length should be valid (>0)
	 * Postconditions: Constructs a new Rectangle object at the specified location with the specified color, length, and width
	 * Exceptions: N/A
	 */
	public Rectangle(double newX, double newY, int red, int green, int blue, double newLength, double newWidth) {
		super(newX, newY, red, green, blue);
		this.length = newLength;
		this.width = newWidth;
	}

	/*
	 * Method Name: draw
	 * Purpose: Override method to draw the Rectangle object in the active StdDraw canvas
	 * Parameters: N/A
	 * Preconditions:
	 * - The StdDraw canvas must be setup and configured properly before drawing
	 * Postconditions: A rectangle is drawn at the (x, y) coordinates with the color, 
	 * 		length, and width specified in this object
	 * Exceptions: N/A
	 */
	public void draw() {
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledRectangle(this.getX(), this.getY(), this.length, this.width);
	}

	/*
	 * Method Name: calculateArea
	 * Purpose: Override method to calculate the area of this Rectangle object in StdDraw canvas units (pixels)
	 * Parameters: N/A
	 * Preconditions:
	 * - This Rectangle should have a valid length and width to be drawn properly
	 * Postconditions: Returns the area of the Rectangle in StdDraw canvas units
	 * Exceptions: N/A
	 */
	public double calculateArea() {
		return (this.length * 2) * (this.width * 2);
	}

	/*
	 * Method Name: calculatePerimeter
	 * Purpose: Override method to calculate the perimeter of this Rectangle object 
	 * 		in StdDraw canvas units (pixels)
	 * Parameters: N/A
	 * Preconditions:
	 * - This Rectangle should have a valid length and width
	 * Postconditions: Returns the perimeter of the Rectangle in StdDraw canvas units
	 * Exceptions: N/A
	 */
	public double calculatePerimeter() {
		return ((this.length * 2) * 2) + ((this.width * 2) * 2);
	}
}