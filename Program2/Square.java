package Program2;
/*
 * Name: Camden Link
 * Assignment: Program 2
 * Lab Instructor: Jakob Kaivo
 * Date: 2023-03-02
 * Purpose: This file contains the Square class that extends the GraphicObject class
 */

/*
 * Class Name: Square
 * Purpose: Allows for calculation of area + perimeter of a Square, as well as drawing to the screen using the StdDraw library
 * Exceptions: N/A
 */
public class Square extends GraphicObject {
	private double sideLength;
	
	/*
	 * Method Name: Square
	 * Purpose: Constructs a new Square object extending the GraphicObject class
	 * Parameters:
	 * - newX: The x-coordinate of the object on the StdDraw canvas
	 * - newY: The y-coordinate of the object on the StdDraw canvas
	 * - red: The red RGB value for the color of the Square
	 * - green: The green RGB value for the color of the Square
	 * - blue: The blue RGB value for the color of the Square
	 * - sideLength: The length of one side of the Square
	 * Preconditions: 
	 * - The x, y coordinates should be within the bounds of the canvas
	 * - The sideLength should be a valid length
	 * Postconditions: Constructs a new Square object at the specified location with the specified color and side lengths
	 * Exceptions: N/A
	 */
	public Square(double newX, double newY, int red, int green, int blue, double sideLength) {
		super(newX, newY, red, green, blue);
		this.sideLength = sideLength;
	}
	
	/*
	 * Method Name: draw
	 * Purpose: Override method to draw the Square object in the active StdDraw canvas
	 * Parameters: N/A
	 * Preconditions:
	 * - The StdDraw canvas must be setup and configured properly before drawing
	 * Postconditions: A square is drawn at the (x, y) coordinates with the color, 
	 * 		and side lengths specified in this object
	 * Exceptions: N/A
	 */
	public void draw() {
		StdDraw.setPenColor(this.getColor());
		StdDraw.filledSquare(this.getX(), this.getY(), this.sideLength);
	}

	/*
	 * Method Name: calculateArea
	 * Purpose: Override method to calculate the area of this Square object in StdDraw canvas units (pixels)
	 * Parameters: N/A
	 * Preconditions:
	 * - This Square should have a valid side length to be drawn properly
	 * Postconditions: Returns the area of the Square in StdDraw canvas units
	 * Exceptions: N/A
	 */
	public double calculateArea() {
		//Multiply the length of the side by itself
		return Math.pow(this.sideLength * 2, 2);
	}

	/*
	 * Method Name: calculatePerimeter
	 * Purpose: Override method to calculate the perimeter of this Square object 
	 * 		in StdDraw canvas units (pixels)
	 * Parameters: N/A
	 * Preconditions:
	 * - This Rectangle should have a valid side length
	 * Postconditions: Returns the perimeter of the Square in StdDraw canvas units
	 * Exceptions: N/A
	 */
	public double calculatePerimeter() {
		//A square has 4 sides, so multiply the side length by 4
		return (this.sideLength * 2) * 4;
	}
}